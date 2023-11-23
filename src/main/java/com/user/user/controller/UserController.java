package com.user.user.controller;

import com.user.user.User;
import com.user.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired private UserService userService;

    @GetMapping("/users")
    public String showUserList(Model model){
        List<User> listUsers = userService.listAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/users/add-new")
    public String showNewForm(Model model){
        model.addAttribute("user", new User());
        return "new_form";
    }

    @PostMapping("/users/save")
    public String saveUser(User user){
        userService.save(user);
        return "redirect:/users";
    }

}
