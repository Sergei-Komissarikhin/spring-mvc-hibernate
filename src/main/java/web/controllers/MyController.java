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
    public String fromUpdate(@RequestParam("id") Long id, Model model) {
        User user = userService.getUserById(id);
        System.out.println("inside update controller" + user);
        model.addAttribute("user", user);
        model.addAttribute("id",id);
        return "update-page";
    }

    @RequestMapping("updateById")
    public String updateUser(@ModelAttribute("user") User user){
        System.out.println("get in controller" +  user);
        userService.updateUser(user);
        return "redirect:/";
    }

    @RequestMapping("delete")
    public String deleteUser(@RequestParam("id") Long id){
        userService.deleteUser(id);
        return "redirect:/";
    }
}
