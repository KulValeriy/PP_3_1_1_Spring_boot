package springboot.spring_crud_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.spring_crud_boot.model.User;
import springboot.spring_crud_boot.service.UserServiceImpl;

import javax.validation.Valid;


@Controller
public class UserController {

    private UserServiceImpl userServiceImpl;

    @Autowired
    public void setUserService(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/")
    public String users(Model model) {
        model.addAttribute("users", userServiceImpl.findAll());
        return "users";
    }

    @GetMapping(value = "/user")
    public String getUser(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", userServiceImpl.getById(id));
        return "user";
    }

    @GetMapping(value = "/edit")
    public String edit(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", userServiceImpl.getById(id));
        return "editPage";
    }

    @PostMapping("/edit")
    public String editUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editPage";
        } else {
            userServiceImpl.save(user);
            return "redirect:/";
        }
    }

    @GetMapping("/add")
    public String add(User user) {
        return "add";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add";
        } else {
            userServiceImpl.save(user);
            return "redirect:/";
        }
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam(value = "id") int id) {
        userServiceImpl.deleteById(id);
        return "redirect:/";
    }


}