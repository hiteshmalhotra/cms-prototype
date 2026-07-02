package com.cms.prototype.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @GetMapping({"/", "/login"})
    public String login() { return "auth/login"; }

    @PostMapping("/login")
    public String doLogin() { return "redirect:/dashboard"; }

    @GetMapping("/forgot-password")
    public String forgotPassword() { return "auth/forgot-password"; }

    @PostMapping("/forgot-password")
    public String doForgotPassword() { return "redirect:/otp-verify"; }

    @GetMapping("/otp-verify")
    public String otpVerify() { return "auth/otp-verify"; }

    @PostMapping("/otp-verify")
    public String doOtpVerify() { return "redirect:/change-password"; }

    @GetMapping("/change-password")
    public String changePassword() { return "auth/change-password"; }

    @PostMapping("/change-password")
    public String doChangePassword() { return "redirect:/login?changed=true"; }

    @GetMapping("/logout")
    public String logout() { return "redirect:/login?logout=true"; }
}
