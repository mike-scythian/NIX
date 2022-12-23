package nix.springboot.project.controller;

import com.google.gson.Gson;
import nix.springboot.project.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class WelcomeController {

    private User user;

    @GetMapping("/")
    public String greeting(Model model){
        return "welcome";
    }
    @GetMapping("/hello")
    public String hello(Model model){

        String name = user.getName();
        model.addAttribute("name", name);
        model.addAttribute("object",new Gson().toJson(user) );
        return "hello";
    }
    @PostMapping("/")
    public String sayHello(@RequestParam(defaultValue = "Friend") String name, Model model){
        user = new User();
        user.setName(name);
        Optional<User> oUser = Optional.of(user);
        model.addAttribute("name", oUser.get().getName());
        return "redirect:hello";
    }
}
