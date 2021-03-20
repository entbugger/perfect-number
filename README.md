This is a Spring Boot application dealing with perfect numbers:
1. it checks if a given number is perfect: endpoint `/perfect-number/check`
2. finds all perfect numbers between a range (start-end): endpoint `/perfect-number/generate`

Example when running on localhost:8080:
1. http://localhost:8080/perfect-number/check?number=28
2. http://localhost:8080/perfect-number/generate?start=20&end=29