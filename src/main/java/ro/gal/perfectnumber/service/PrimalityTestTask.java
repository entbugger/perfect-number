package ro.gal.perfectnumber.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Boolean.FALSE;
import static java.math.BigInteger.*;

/**
 * RecursiveTask for ForkJoinPool for checking whether a number is prime. Do NOT use this directly, but rather
 * call NaivePrimeNumberService.isPrimeNumber() because some edge cases are not tested here.
 */
public class PrimalityTestTask extends RecursiveTask<Boolean> {

    private static final BigInteger TWO = valueOf(2);

    private static final BigInteger FIVE = valueOf(5);
    private static final BigInteger SIX = valueOf(6);

    private static final BigInteger PRIME_STEP = SIX;
    private static final BigInteger SUBTASK_SIZE = PRIME_STEP.multiply(valueOf(50_000_000));

    private final BigInteger num;
    private final BigInteger maxDivisor;
    private final BigInteger minDivisor;
    private final AtomicBoolean isPrime;

    public PrimalityTestTask(BigInteger num) {
        this(num, FIVE, num.sqrt().add(ONE), new AtomicBoolean(true));
    }

    /**
     * Checks whether 'num' divides any numbers between 'minDivisor' (incl.) and 'maxDivisor' (excl.).
     */
    private PrimalityTestTask(BigInteger num, BigInteger minDivisor, BigInteger maxDivisor,
                              AtomicBoolean isPrime) {
        this.num = num;
        this.maxDivisor = maxDivisor;
        this.minDivisor = minDivisor;
        this.isPrime = isPrime;
    }

    @Override
    protected Boolean compute() {



        if (maxDivisor.subtract(minDivisor).compareTo(SUBTASK_SIZE) > 0) {
            return ForkJoinTask.invokeAll(createSubtasks())
                .stream()
                .allMatch(ForkJoinTask::join);
        } else {
            return process();
        }
    }

    private Collection<PrimalityTestTask> createSubtasks() {
        List<PrimalityTestTask> dividedTasks = new ArrayList<>();
        BigInteger startInterval = minDivisor;
        BigInteger endInterval = startInterval.add(SUBTASK_SIZE);
        while (endInterval.compareTo(maxDivisor)<0) {
            PrimalityTestTask crtTask = new PrimalityTestTask(num, startInterval, endInterval, isPrime);
            dividedTasks.add(crtTask);
            startInterval = endInterval;
            endInterval = startInterval.add(SUBTASK_SIZE);
        }
        if (startInterval.compareTo(maxDivisor)<=0) {
            dividedTasks.add( new PrimalityTestTask(num, startInterval, maxDivisor, isPrime));
        }
        return dividedTasks;
    }

    private Boolean process() {
        if (FALSE.equals(isPrime.get())) {
            return false;
        }
        int ops = 0;
        for(BigInteger i = minDivisor; i.compareTo(maxDivisor)<=0; i=i.add(PRIME_STEP)) {
            if (ops>1000) {
                ops=0;
                if (FALSE.equals(isPrime.get())) {
                    return false;
                }
            }
            ops++;
            if (isDivisibleBy(num, i) || isDivisibleBy(num, i.add(TWO))) {
                isPrime.set(false);
                return false;
            }
        }
        return true;
    }

    private boolean isDivisibleBy(BigInteger n, BigInteger by) {
        return ZERO.equals(n.remainder(by));
    }
}
