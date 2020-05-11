package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {


    @GetMapping("/math")
    @ResponseBody
    public String home(){
        return "This is the Math Page.";
    }

    @GetMapping("math/add/{numberOne}+{numberTwo}") // 2. GET request at this url
    @ResponseBody // 3. Return HTML
    public String add(@PathVariable int numberOne, @PathVariable int numberTwo ){
        return numberOne + " + " + numberTwo + " = " + (numberOne + numberTwo);
    }

    @GetMapping("math/subtract/{numberOne}-{numberTwo}") // 2. GET request at this url
    @ResponseBody // 3. Return HTML
    public String subtract(@PathVariable int numberOne, @PathVariable int numberTwo ){
        return numberOne + " - " + numberTwo + " = " + (numberOne - numberTwo);
    }

    @GetMapping("math/multiply/{numberOne}x{numberTwo}") // 2. GET request at this url
    @ResponseBody // 3. Return HTML
    public String multiply(@PathVariable int numberOne, @PathVariable int numberTwo ){
        return numberOne + " * " + numberTwo + " = " + (numberOne * numberTwo);
    }

    @GetMapping("math/divide/{numberOne}/{numberTwo}") // 2. GET request at this url
    @ResponseBody // 3. Return HTML
    public String divide(@PathVariable int numberOne, @PathVariable int numberTwo ){
        return numberOne + " / " + numberTwo + " = " + (numberOne / numberTwo);
    }

}
