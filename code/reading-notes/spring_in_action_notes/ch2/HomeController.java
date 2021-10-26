package com.springInAction.tacoCloud.tacos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author BoZhao
 */
@Controller
public class HomeController
{
    @GetMapping("/")
    public String home()
    {
        return "home";
    }
}
