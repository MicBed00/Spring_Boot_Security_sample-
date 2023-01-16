package com.example.spring_security_exe.controller;

import com.example.spring_security_exe.message.WelcomeMessageService;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageController {

    private final WelcomeMessageService welcomeMessageService;

    @Autowired
    public HomePageController(WelcomeMessageService welcomeMessageService) {
        this.welcomeMessageService = welcomeMessageService;
    }
/*
standardowy endpoint zwracający widok
 */

    //    @GetMapping(value = "/")
//    public String getHomePage() {
//        return "index";
//    }


/*    Dostanie się z poziomu kontrolera do kontekstu bezpieczeństwa (czyli do informacji o zalogownaym użytkowniku) i
      przekazanie tych danych do warstwy widoku wykorzystując wstrzyknięcie obiektu Authentication
*/

//    @GetMapping(value = "/")
//    public String homePage(Authentication authentication, Model model) {
//        model.addAttribute("username", authentication.getName());
//        return "index";
//    }

    /*
    wykorzystanie adnotacji @CurretnSecurityContex
     */
    @GetMapping(value = "/")
//    public String homePage(@CurrentSecurityContex(expression="authentication.name") String username, Model model)
    public String homePage(@CurrentSecurityContext SecurityContext securityContext, Model model) {
        model.addAttribute("username", securityContext.getAuthentication().getName());
        return "index";
    }

    /*
    wykorzystanie serwisu WelcomeMassageService do przekazania tekstu do warstwy widoku
//     */
//    @GetMapping(value = "/")
//    public String homePage(@RequestParam(defaultValue = "en") String lang, Model model) {
//        String welcomeMessage = welcomeMessageService.getWelcomeMessage(lang);
//        model.addAttribute("welcomeMassage", welcomeMessage);
//        return "index";
//    }


}
