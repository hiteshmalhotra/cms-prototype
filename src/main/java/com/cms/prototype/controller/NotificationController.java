package com.cms.prototype.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notifications")
public class NotificationController {

    @GetMapping
    public String list(Model m) { m.addAttribute("pageTitle","Notifications"); m.addAttribute("activeModule","notif-list"); return "notifications/list"; }

    @GetMapping("/{id}")
    public String view(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Notification Details"); m.addAttribute("activeModule","notif-list"); return "notifications/view"; }

    @GetMapping("/{id}/retry")
    public String retry(@PathVariable String id) { return "redirect:/notifications?saved=true"; }

    @GetMapping("/stats")
    public String stats(Model m) { m.addAttribute("pageTitle","Notification Statistics"); m.addAttribute("activeModule","notif-stats"); return "notifications/stats"; }
}
