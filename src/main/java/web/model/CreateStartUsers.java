package web.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class CreateStartUsers {

    final
    UserService userService;

    public CreateStartUsers(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void getUsers(){
        userService.addUser(new User("Sergei", "Ivanov",
                37, "Sus@ya.ru", "1234", "Admin"));
        userService.addUser(new User("Dima", "Egorov",
                32, "Eg@ya.ru", "1234", "User"));
    }
}
