package com.cms.prototype.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String list(Model m) {
        m.addAttribute("pageTitle","User Management"); m.addAttribute("activeModule","users-list");
        return "users/list";
    }
    @GetMapping("/create")
    public String create(Model m) {
        m.addAttribute("pageTitle","Add User"); m.addAttribute("activeModule","users-create");
        return "users/create";
    }
    @PostMapping("/create")
    public String doCreate() { return "redirect:/users?saved=true"; }

    @GetMapping("/{id}")
    public String view(@PathVariable String id, Model m) {
        m.addAttribute("pageTitle","User Details"); m.addAttribute("activeModule","users-list");
        return "users/view";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable String id, Model m) {
        m.addAttribute("pageTitle","Edit User"); m.addAttribute("activeModule","users-list");
        return "users/edit";
    }
    @PostMapping("/{id}/edit")
    public String doEdit(@PathVariable String id) { return "redirect:/users?saved=true"; }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable String id, Model m) {
        m.addAttribute("pageTitle","Delete User"); m.addAttribute("activeModule","users-list");
        return "users/delete-confirm";
    }
    @PostMapping("/{id}/delete")
    public String doDelete(@PathVariable String id) { return "redirect:/users?deleted=true"; }

    @GetMapping("/{id}/audit")
    public String userAudit(@PathVariable String id, Model m) {
        m.addAttribute("pageTitle","User Audit Trail"); m.addAttribute("activeModule","users-list");
        return "users/audit";
    }
}
