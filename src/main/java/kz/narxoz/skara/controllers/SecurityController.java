package kz.narxoz.skara.controllers;


import kz.narxoz.skara.entity.Users;
import kz.narxoz.skara.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *Контроллер логина и регистрации.
 */
@Controller
public class SecurityController {

  @Autowired
  private UserService userService;

  private boolean isAuthenticated() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null || AnonymousAuthenticationToken.class
        .isAssignableFrom(authentication.getClass())) {
      return false;
    }
    return authentication.isAuthenticated();
  }

  /**
   *Логин.
   */
  @GetMapping("/login")
  public String getUserLoginPage(Model model) {
    if (isAuthenticated()) {
      model.addAttribute("currentUser", getUserData());
      return "redirect:/news";
    }
    return "login";
  }

  @GetMapping("/index")
  public String log() {
    return "redirect:/news";
  }

  @GetMapping("/logout")
  public String logout() {
    return "login";
  }

  /**
   *Регистрация - форма.
   */
  @GetMapping(value = "/register")
  public String register(Model model) {
    model.addAttribute("currentUser", getUserData());

    return "register";
  }

  /**
   *Регистрация.
   */
  @PostMapping(value = "/register")
  public String registerForm(@RequestParam(name = "user_email")String email,
                             @RequestParam(name = "user_password")String password,
                             @RequestParam(name = "re_user_password")String rePassword,
                             @RequestParam(name = "user_fullName")String fullName) {
    if (password.equals(rePassword)) {

      Users newUser = new Users();
      newUser.setFullName(fullName);
      newUser.setPassword(password);
      newUser.setEmail(email);

      if (userService.createUser(newUser) != null) {
        return "redirect:/login";
      }
    }
    return "redirect:?register?error";
  }

  private Users getUserData() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (!(authentication instanceof AnonymousAuthenticationToken)) {
      User secUser = (User) authentication.getPrincipal();
      Users myUser = userService.getUserByEmail(secUser.getUsername());
      return myUser;
    }
    return null;
  }

}
