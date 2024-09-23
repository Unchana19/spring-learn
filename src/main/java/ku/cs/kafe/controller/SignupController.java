package ku.cs.kafe.controller;

import jakarta.validation.Valid;
import ku.cs.kafe.request.SignupRequest;
import ku.cs.kafe.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {
    @Autowired
    private SignupService service;

    @GetMapping("/signup")
    public String getSignupPage(Model model) {
        model.addAttribute("signupRequest", new SignupRequest());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupUser(@Valid SignupRequest request, BindingResult result, Model model) {
        if(result.hasErrors())
            return "signup";

        if (service.isUsernameAvailable(request.getUsername())) {
            service.createUser(request);
            model.addAttribute("signupSuccess", true);
        } else {
            model.addAttribute("signupError", "Username not available");
        }
        model.addAttribute("signupRequest", new SignupRequest());
        return "signup";
    }
}
