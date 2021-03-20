package ro.gal.perfectnumber.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.gal.perfectnumber.service.PerfectNumberService;

@Controller
@RequestMapping(value = "/perfect-number")
public class PerfectNumberController {

    private final PerfectNumberService service;

    @Autowired
    public PerfectNumberController(PerfectNumberService service) {
        this.service = service;
    }

    @RequestMapping("/check")
    public @ResponseBody boolean checkNumber(@RequestParam("number") long number) {
        return service.isPerfectNumber(number);
    }
}
