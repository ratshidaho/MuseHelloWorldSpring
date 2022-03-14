package org.muse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {

    @RequestMapping("/")
    public String helloWord() {
        return "<html>" +
                "<label>Name:</label>" +
                "<input type=text>" +
                "<br>"+
                "<input type=submit>"+
                "</html>";
    }

    @RequestMapping("/again")
    public String helloWorld2() {
        return "Hello Again";
    }

    @RequestMapping("/add")
    public int sum(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }
}
