package com.cms.prototype.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("pageTitle", "Dashboard");
        model.addAttribute("activeModule", "dashboard");
        return "dashboard/index";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("pageTitle", "My Profile");
        model.addAttribute("activeModule", "profile");
        return "shared/profile";
    }

    @GetMapping("/settings")
    public String settings(Model model) {
        model.addAttribute("pageTitle", "Settings");
        model.addAttribute("activeModule", "settings");
        return "shared/settings";
    }

    @GetMapping("/audit")
    public String audit(Model model) {
        model.addAttribute("pageTitle", "System Audit Trail");
        model.addAttribute("activeModule", "audit");
        return "shared/audit-trail";
    }
}
