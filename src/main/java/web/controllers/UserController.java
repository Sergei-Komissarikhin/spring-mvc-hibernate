package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public String index(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "users/index";
    }

    @GetMapping("/{id}/")
    public String getUserById(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        System.out.println("hello");
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user){
        return "users/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id,
                       Model model){
        model.addAttribute("user",userService.getUserById(id));
        return "users/edit";
    }

    @PatchMapping("{id}")
    public String update(@PathVariable("id") long id,
                         @ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/users";
    }


}
