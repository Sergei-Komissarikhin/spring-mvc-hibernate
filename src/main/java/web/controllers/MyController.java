package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("message", "Hello world!");
        List<User> users = userService.getAllUsers();
        model.addAttribute(users);
        return "start-page";
    }

    @RequestMapping("askDetails")
    public String askDetailsView(Model model) {
        model.addAttribute("user", new User());
        return "save-page";
    }

    @RequestMapping("saveUser")
    public String showDetailsView(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @RequestMapping("update")
    public String fromUpdate(@RequestParam("id") long id, Model model ) {
        model.addAttribute("user", userService.getUserById(id));
        return "update-page";
    }

    @RequestMapping("updateById")
    public String updateUser(@ModelAttribute("user") User user){
        System.out.println(user);
        userService.updateUser(user);
        return "redirect:/";
    }
}
