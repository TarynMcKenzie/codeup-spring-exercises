package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{numberOne}+{numberTwo}") // 2. GET request at this url
    @ResponseBody // 3. Return HTML
    public String add(@PathVariable int numberOne, @PathVariable int numberTwo ){
        return numberOne + " + " + numberTwo + " = " + (numberOne + numberTwo);
    }

    @GetMapping("/subtract/{numberOne}-{numberTwo}") // 2. GET request at this url
    @ResponseBody // 3. Return HTML
    public String subtract(@PathVariable int numberOne, @PathVariable int numberTwo ){
        return numberOne + " - " + numberTwo + " = " + (numberOne - numberTwo);
    }

    @GetMapping("/multiply/{numberOne}x{numberTwo}") // 2. GET request at this url
    @ResponseBody // 3. Return HTML
    public String multiply(@PathVariable int numberOne, @PathVariable int numberTwo ){
        return numberOne + " * " + numberTwo + " = " + (numberOne * numberTwo);
    }

    @GetMapping("/divide/{numberOne}/{numberTwo}") // 2. GET request at this url
    @ResponseBody // 3. Return HTML
    public String divide(@PathVariable int numberOne, @PathVariable int numberTwo ){
        return numberOne + " / " + numberTwo + " = " + (numberOne / numberTwo);
    }

}
