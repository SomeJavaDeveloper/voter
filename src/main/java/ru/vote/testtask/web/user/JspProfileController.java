package ru.vote.testtask.web.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.vote.testtask.model.User;
import ru.vote.testtask.to.UserTo;
import ru.vote.testtask.web.SecurityUtil;

import javax.validation.Valid;
import java.net.URI;

@Controller
@RequestMapping("/profile")
public class JspProfileController extends AbstractUserController {

    @GetMapping
    public String profile() {
        return "profile";
    }

    @GetMapping("/register")
    public String register(ModelMap model) {
        model.addAttribute("userTo", new UserTo());
        model.addAttribute("register", true);
        return "profile";
    }

    @PostMapping("/register")
    public String saveRegister(@Valid UserTo userTo, BindingResult result, SessionStatus status, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("register", true);
            return "profile";
        }
        super.create(userTo);
        status.setComplete();
        return "redirect:/login";
    }

    @PostMapping
    public String updateProfile(@Valid UserTo userTo, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "profile";
        } else {
            super.update(userTo, SecurityUtil.authUserId());
            SecurityUtil.get().update(userTo);
            status.setComplete();
            return "redirect:restaurants";
        }
    }

}
