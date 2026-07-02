package com.cms.prototype.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/kitchen")
public class KitchenController {

    @GetMapping
    public String dashboard(Model m) { m.addAttribute("pageTitle","Kitchen Dashboard"); m.addAttribute("activeModule","kitchen"); return "kitchen/dashboard"; }

    @GetMapping("/recipe-items") public String recipeItems(Model m) { m.addAttribute("pageTitle","Recipe Items"); m.addAttribute("activeModule","kitchen-recipe-items"); return "kitchen/recipe-items/list"; }
    @GetMapping("/recipe-items/create") public String riCreate(Model m) { m.addAttribute("pageTitle","Add Recipe Item"); m.addAttribute("activeModule","kitchen-recipe-items"); return "kitchen/recipe-items/create"; }
    @PostMapping("/recipe-items/create") public String riDoCreate() { return "redirect:/kitchen/recipe-items?saved=true"; }
    @GetMapping("/recipe-items/{id}") public String riView(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Recipe Item Details"); m.addAttribute("activeModule","kitchen-recipe-items"); return "kitchen/recipe-items/view"; }
    @GetMapping("/recipe-items/{id}/edit") public String riEdit(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Edit Recipe Item"); m.addAttribute("activeModule","kitchen-recipe-items"); return "kitchen/recipe-items/edit"; }
    @PostMapping("/recipe-items/{id}/edit") public String riDoEdit(@PathVariable String id) { return "redirect:/kitchen/recipe-items?saved=true"; }
    @GetMapping("/recipe-items/{id}/delete") public String riDelete(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Delete Recipe Item"); m.addAttribute("activeModule","kitchen-recipe-items"); return "kitchen/recipe-items/delete-confirm"; }
    @PostMapping("/recipe-items/{id}/delete") public String riDoDelete(@PathVariable String id) { return "redirect:/kitchen/recipe-items?deleted=true"; }

    @GetMapping("/recipes") public String recipes(Model m) { m.addAttribute("pageTitle","Recipes"); m.addAttribute("activeModule","kitchen-recipes"); return "kitchen/recipes/list"; }
    @GetMapping("/recipes/create") public String recCreate(Model m) { m.addAttribute("pageTitle","Create Recipe"); m.addAttribute("activeModule","kitchen-recipes"); return "kitchen/recipes/create"; }
    @PostMapping("/recipes/create") public String recDoCreate() { return "redirect:/kitchen/recipes?saved=true"; }
    @GetMapping("/recipes/{id}") public String recView(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Recipe Details"); m.addAttribute("activeModule","kitchen-recipes"); return "kitchen/recipes/view"; }
    @GetMapping("/recipes/{id}/edit") public String recEdit(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Edit Recipe"); m.addAttribute("activeModule","kitchen-recipes"); return "kitchen/recipes/edit"; }
    @PostMapping("/recipes/{id}/edit") public String recDoEdit(@PathVariable String id) { return "redirect:/kitchen/recipes?saved=true"; }

    @GetMapping("/production-orders") public String prodList(Model m) { m.addAttribute("pageTitle","Production Orders"); m.addAttribute("activeModule","kitchen-production"); return "kitchen/production/list"; }
    @GetMapping("/production-orders/create") public String prodCreate(Model m) { m.addAttribute("pageTitle","Create Production Order"); m.addAttribute("activeModule","kitchen-production"); return "kitchen/production/create"; }
    @PostMapping("/production-orders/create") public String prodDoCreate() { return "redirect:/kitchen/production-orders?saved=true"; }
    @GetMapping("/production-orders/{id}") public String prodView(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Production Order Details"); m.addAttribute("activeModule","kitchen-production"); return "kitchen/production/view"; }
    @GetMapping("/production-orders/{id}/start") public String prodStart(@PathVariable String id) { return "redirect:/kitchen/production-orders/" + id + "?saved=true"; }
    @GetMapping("/production-orders/{id}/complete") public String prodComplete(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Complete Production"); m.addAttribute("activeModule","kitchen-production"); return "kitchen/production/complete"; }
    @PostMapping("/production-orders/{id}/complete") public String prodDoComplete(@PathVariable String id) { return "redirect:/kitchen/production-orders/" + id + "?saved=true"; }
    @GetMapping("/production-orders/{id}/cancel") public String prodCancel(@PathVariable String id) { return "redirect:/kitchen/production-orders?saved=true"; }

    @GetMapping("/stock") public String stock(Model m) { m.addAttribute("pageTitle","Kitchen Stock"); m.addAttribute("activeModule","kitchen-stock"); return "kitchen/stock/list"; }
    @GetMapping("/ledger") public String ledger(Model m) { m.addAttribute("pageTitle","Kitchen Ledger"); m.addAttribute("activeModule","kitchen-ledger"); return "kitchen/stock/ledger"; }

    @GetMapping("/transfers") public String transfers(Model m) { m.addAttribute("pageTitle","Kitchen Transfers"); m.addAttribute("activeModule","kitchen-transfers"); return "kitchen/transfers/list"; }
    @GetMapping("/transfers/create") public String transferCreate(Model m) { m.addAttribute("pageTitle","Create Transfer"); m.addAttribute("activeModule","kitchen-transfers"); return "kitchen/transfers/create"; }
    @PostMapping("/transfers/create") public String transferDoCreate() { return "redirect:/kitchen/transfers?saved=true"; }
    @GetMapping("/transfers/{id}") public String transferView(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Transfer Details"); m.addAttribute("activeModule","kitchen-transfers"); return "kitchen/transfers/view"; }
    @GetMapping("/transfers/{id}/dispatch") public String transferDispatch(@PathVariable String id) { return "redirect:/kitchen/transfers/" + id + "?sent=true"; }
    @GetMapping("/transfers/{id}/receive") public String transferReceive(@PathVariable String id) { return "redirect:/kitchen/transfers/" + id + "?saved=true"; }
}
