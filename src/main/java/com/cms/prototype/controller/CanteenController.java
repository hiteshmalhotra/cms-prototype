package com.cms.prototype.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/canteen")
public class CanteenController {

    @GetMapping
    public String dashboard(Model m) { m.addAttribute("pageTitle","Canteen Dashboard"); m.addAttribute("activeModule","canteen"); return "canteen/index"; }

    @GetMapping("/menu-items") public String menu(Model m) { m.addAttribute("pageTitle","Menu Items"); m.addAttribute("activeModule","canteen-menu"); return "canteen/menu/list"; }
    @GetMapping("/menu-items/create") public String menuCreate(Model m) { m.addAttribute("pageTitle","Add Menu Item"); m.addAttribute("activeModule","canteen-menu"); return "canteen/menu/create"; }
    @PostMapping("/menu-items/create") public String menuDoCreate() { return "redirect:/canteen/menu-items?saved=true"; }
    @GetMapping("/menu-items/{id}") public String menuView(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Menu Item Details"); m.addAttribute("activeModule","canteen-menu"); return "canteen/menu/view"; }
    @GetMapping("/menu-items/{id}/edit") public String menuEdit(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Edit Menu Item"); m.addAttribute("activeModule","canteen-menu"); return "canteen/menu/edit"; }
    @PostMapping("/menu-items/{id}/edit") public String menuDoEdit(@PathVariable String id) { return "redirect:/canteen/menu-items?saved=true"; }

    @GetMapping("/preparation-orders") public String prepList(Model m) { m.addAttribute("pageTitle","Preparation Orders"); m.addAttribute("activeModule","canteen-prep"); return "canteen/preparation/list"; }
    @GetMapping("/preparation-orders/create") public String prepCreate(Model m) { m.addAttribute("pageTitle","Create Preparation Order"); m.addAttribute("activeModule","canteen-prep"); return "canteen/preparation/create"; }
    @PostMapping("/preparation-orders/create") public String prepDoCreate() { return "redirect:/canteen/preparation-orders?saved=true"; }
    @GetMapping("/preparation-orders/{id}") public String prepView(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Preparation Order Details"); m.addAttribute("activeModule","canteen-prep"); return "canteen/preparation/view"; }
    @GetMapping("/preparation-orders/{id}/start") public String prepStart(@PathVariable String id) { return "redirect:/canteen/preparation-orders/" + id + "?saved=true"; }
    @GetMapping("/preparation-orders/{id}/complete") public String prepComplete(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Complete Preparation"); m.addAttribute("activeModule","canteen-prep"); return "canteen/preparation/complete"; }
    @PostMapping("/preparation-orders/{id}/complete") public String prepDoComplete(@PathVariable String id) { return "redirect:/canteen/preparation-orders/" + id + "?saved=true"; }

    @GetMapping("/stock") public String stock(Model m) { m.addAttribute("pageTitle","Canteen Stock"); m.addAttribute("activeModule","canteen-stock"); return "canteen/stock/list"; }
    @GetMapping("/consumption") public String consumption(Model m) { m.addAttribute("pageTitle","Consumption Records"); m.addAttribute("activeModule","canteen-consumption"); return "canteen/consumption/list"; }
    @GetMapping("/consumption/record") public String consumptionRecord(Model m) { m.addAttribute("pageTitle","Record Consumption"); m.addAttribute("activeModule","canteen-consumption"); return "canteen/consumption/create"; }
    @PostMapping("/consumption/record") public String consumptionDoRecord() { return "redirect:/canteen/consumption?saved=true"; }
    @GetMapping("/wastage") public String wastage(Model m) { m.addAttribute("pageTitle","Wastage Records"); m.addAttribute("activeModule","canteen-wastage"); return "canteen/wastage/list"; }
    @GetMapping("/wastage/record") public String wastageRecord(Model m) { m.addAttribute("pageTitle","Record Wastage"); m.addAttribute("activeModule","canteen-wastage"); return "canteen/wastage/create"; }
    @PostMapping("/wastage/record") public String wastageDoRecord() { return "redirect:/canteen/wastage?saved=true"; }

    @GetMapping("/daily-reports") public String reports(Model m) { m.addAttribute("pageTitle","Daily Reports"); m.addAttribute("activeModule","canteen-reports"); return "canteen/reports/list"; }
    @GetMapping("/daily-reports/generate") public String reportGenerate(Model m) { m.addAttribute("pageTitle","Generate Daily Report"); m.addAttribute("activeModule","canteen-reports"); return "canteen/reports/generate"; }
    @PostMapping("/daily-reports/generate") public String reportDoGenerate() { return "redirect:/canteen/daily-reports?saved=true"; }
    @GetMapping("/daily-reports/{id}") public String reportView(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Daily Report Details"); m.addAttribute("activeModule","canteen-reports"); return "canteen/reports/view"; }
    @GetMapping("/daily-reports/{id}/submit") public String reportSubmit(@PathVariable String id) { return "redirect:/canteen/daily-reports/" + id + "?saved=true"; }
    @GetMapping("/daily-reports/{id}/approve") public String reportApprove(@PathVariable String id) { return "redirect:/canteen/daily-reports/" + id + "?approved=true"; }
    @GetMapping("/daily-reports/{id}/reject") public String reportReject(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Reject Report"); m.addAttribute("activeModule","canteen-reports"); return "canteen/reports/reject"; }
    @PostMapping("/daily-reports/{id}/reject") public String reportDoReject(@PathVariable String id) { return "redirect:/canteen/daily-reports/" + id + "?rejected=true"; }

    // ── Material Requests (Challan Requests to Store) ──
    @GetMapping("/material-requests") public String mrList(Model m) { m.addAttribute("pageTitle","Material Requests"); m.addAttribute("activeModule","canteen-mr"); return "canteen/material-requests/list"; }
    @GetMapping("/material-requests/create") public String mrCreate(Model m) { m.addAttribute("pageTitle","New Material Request"); m.addAttribute("activeModule","canteen-mr"); return "canteen/material-requests/create"; }
    @PostMapping("/material-requests/create") public String mrDoCreate() { return "redirect:/canteen/material-requests?saved=true"; }
    @GetMapping("/material-requests/{id}") public String mrView(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Request Details"); m.addAttribute("activeModule","canteen-mr"); return "canteen/material-requests/view"; }
    @PostMapping("/material-requests/{id}/submit") public String mrSubmit(@PathVariable String id) { return "redirect:/canteen/material-requests/" + id + "?sent=true"; }
    @PostMapping("/material-requests/{id}/cancel") public String mrCancel(@PathVariable String id) { return "redirect:/canteen/material-requests?deleted=true"; }
    @PostMapping("/material-requests/{id}/verify") public String mrVerify(@PathVariable String id) { return "redirect:/canteen/material-requests/" + id + "?saved=true"; }

    // ── Canteen Ledger ──
    @GetMapping("/ledger") public String ledger(Model m) { m.addAttribute("pageTitle","Canteen Ledger"); m.addAttribute("activeModule","canteen-ledger"); return "canteen/ledger"; }
}
