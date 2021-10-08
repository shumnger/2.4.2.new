package SpringMvc.controller;

import SpringMvc.model.User;
import SpringMvc.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private userService userService;

    @Autowired
    public void setUserService(userService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String listUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "users";
    }

    @GetMapping(value = "/users/new")
    public String newUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        return "new";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    //страница для редактирования юзеров
    @GetMapping(value = "/edit/{id}")
    public String editUserForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String editUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/remove/{id}")
    public String removeUser(@PathVariable("id") long id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }
}
