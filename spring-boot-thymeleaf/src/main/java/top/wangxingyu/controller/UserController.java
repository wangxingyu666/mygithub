package top.wangxingyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.wangxingyu.model.User;

import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

    private List<User> users = new ArrayList<>();


    @GetMapping("/userList")
    public String listUsers(Model model) {
        model.addAttribute("users", users);
        return "userList";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String name, @RequestParam String email, Model model) {
        User newUser = new User((long) users.size()+1, name, email);
        users.add(newUser);
        return "redirect:/userList";
    }
}