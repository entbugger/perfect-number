package ro.gal.perfectnumber.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/perfect-number")
public class PerfectNumberController {

    @RequestMapping("/check")
    public @ResponseBody boolean checkNumber() {
        return false;
    }
}
