package com.ynmio.Thimeleaf.Controller;


import com.ynmio.Thimeleaf.dao.UserRepository;
import com.ynmio.Thimeleaf.helper.Message;
import com.ynmio.Thimeleaf.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;


@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public String HomeController(Model model){
        model.addAttribute("title","Home");
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("title","login");
        return "login";
    }

    @GetMapping("/sign-up")
    public String signUp(Model model){
        model.addAttribute("title","sign-up");
        model.addAttribute("user",new User());
        return "sign-up";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("title","About");
        return "about";
    }
    @PostMapping("/do_register")
    public String registerUser(@ModelAttribute("user") User user, @RequestParam(value ="checkbox",defaultValue = "false")
                               boolean checkbox , Model model, HttpSession session)
    {
        try {
            user.setRole("role_user");
            user.setEnabled(true);
            User result =userRepository.save(user);
            model.addAttribute("user",new User());
            session.setAttribute("message",new Message("Successfully Register","alert-success"));
            return "sign-up";
        }catch (Exception e){
            session.setAttribute("message",new Message("Something went wrong","alert-danger"));
            System.out.println("error is "+e);
            return "sign-up";
        }
    }
}
