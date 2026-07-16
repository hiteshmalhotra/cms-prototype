package com.cms.prototype.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/store")
public class StoreController {

    @GetMapping
    public String dashboard(Model m) {
        m.addAttribute("pageTitle","Store Dashboard"); m.addAttribute("activeModule","store");
        return "store/index";
    }

    // ── Items ──
    @GetMapping("/items") public String items(Model m) { m.addAttribute("pageTitle","Item Master"); m.addAttribute("activeModule","store-items"); return "store/items/list"; }
    @GetMapping("/items/create") public String itemCreate(Model m) { m.addAttribute("pageTitle","Add Item"); m.addAttribute("activeModule","store-items"); return "store/items/create"; }
    @PostMapping("/items/create") public String itemDoCreate() { return "redirect:/store/items?saved=true"; }
    @GetMapping("/items/{id}") public String itemView(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Item Details"); m.addAttribute("activeModule","store-items"); return "store/items/view"; }
    @GetMapping("/items/{id}/edit") public String itemEdit(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Edit Item"); m.addAttribute("activeModule","store-items"); return "store/items/edit"; }
    @PostMapping("/items/{id}/edit") public String itemDoEdit(@PathVariable String id) { return "redirect:/store/items?saved=true"; }
    @GetMapping("/items/{id}/delete") public String itemDelete(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Delete Item"); m.addAttribute("activeModule","store-items"); return "store/items/delete-confirm"; }
    @PostMapping("/items/{id}/delete") public String itemDoDelete(@PathVariable String id) { return "redirect:/store/items?deleted=true"; }

    // ── Categories ──
    @GetMapping("/categories") public String categories(Model m) { m.addAttribute("pageTitle","Item Categories"); m.addAttribute("activeModule","store-categories"); return "store/categories/list"; }
    @GetMapping("/categories/create") public String catCreate(Model m) { m.addAttribute("pageTitle","Add Category"); m.addAttribute("activeModule","store-categories"); return "store/categories/create"; }
    @PostMapping("/categories/create") public String catDoCreate() { return "redirect:/store/categories?saved=true"; }
    @GetMapping("/categories/{id}/edit") public String catEdit(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Edit Category"); m.addAttribute("activeModule","store-categories"); return "store/categories/edit"; }
    @PostMapping("/categories/{id}/edit") public String catDoEdit(@PathVariable String id) { return "redirect:/store/categories?saved=true"; }

    // ── Suppliers ──
    @GetMapping("/suppliers") public String suppliers(Model m) { m.addAttribute("pageTitle","Suppliers"); m.addAttribute("activeModule","store-suppliers"); return "store/suppliers/list"; }
    @GetMapping("/suppliers/create") public String supCreate(Model m) { m.addAttribute("pageTitle","Add Supplier"); m.addAttribute("activeModule","store-suppliers"); return "store/suppliers/create"; }
    @PostMapping("/suppliers/create") public String supDoCreate() { return "redirect:/store/suppliers?saved=true"; }
    @GetMapping("/suppliers/{id}") public String supView(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Supplier Details"); m.addAttribute("activeModule","store-suppliers"); return "store/suppliers/view"; }
    @GetMapping("/suppliers/{id}/edit") public String supEdit(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Edit Supplier"); m.addAttribute("activeModule","store-suppliers"); return "store/suppliers/edit"; }
    @PostMapping("/suppliers/{id}/edit") public String supDoEdit(@PathVariable String id) { return "redirect:/store/suppliers?saved=true"; }

    // ── Stock ──
    @GetMapping("/stock") public String stock(Model m) { m.addAttribute("pageTitle","Stock Levels"); m.addAttribute("activeModule","store-stock"); return "store/stock/list"; }
    @GetMapping("/stock/adjust") public String stockAdjust(Model m) { m.addAttribute("pageTitle","Stock Adjustment"); m.addAttribute("activeModule","store-stock"); return "store/stock/adjust"; }
    @PostMapping("/stock/adjust") public String stockDoAdjust() { return "redirect:/store/stock?saved=true"; }
    @GetMapping("/ledger") public String ledger(Model m) { m.addAttribute("pageTitle","Stock Ledger"); m.addAttribute("activeModule","store-ledger"); return "store/stock/ledger"; }

    // ── Purchase Orders ──
    @GetMapping("/purchase-orders") public String poList(Model m) { m.addAttribute("pageTitle","Purchase Orders"); m.addAttribute("activeModule","store-po"); return "store/po/list"; }
    @GetMapping("/purchase-orders/create") public String poCreate(Model m) { m.addAttribute("pageTitle","Create Purchase Order"); m.addAttribute("activeModule","store-po"); return "store/po/create"; }
    @PostMapping("/purchase-orders/create") public String poDoCreate() { return "redirect:/store/purchase-orders?saved=true"; }
    @GetMapping("/purchase-orders/{id}") public String poView(@PathVariable String id, Model m) { m.addAttribute("pageTitle","PO Details"); m.addAttribute("activeModule","store-po"); return "store/po/view"; }
    @GetMapping("/purchase-orders/{id}/edit") public String poEdit(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Edit PO"); m.addAttribute("activeModule","store-po"); return "store/po/edit"; }
    @PostMapping("/purchase-orders/{id}/edit") public String poDoEdit(@PathVariable String id) { return "redirect:/store/purchase-orders?saved=true"; }
    @GetMapping("/purchase-orders/{id}/send") public String poSend(@PathVariable String id) { return "redirect:/store/purchase-orders/" + id + "?sent=true"; }
    @GetMapping("/purchase-orders/{id}/receive") public String poReceive(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Record GRN"); m.addAttribute("activeModule","store-po"); return "store/po/receive"; }
    @PostMapping("/purchase-orders/{id}/receive") public String poDoReceive(@PathVariable String id) { return "redirect:/store/purchase-orders/" + id + "?saved=true"; }
    @GetMapping("/purchase-orders/{id}/cancel") public String poCancel(@PathVariable String id) { return "redirect:/store/purchase-orders?saved=true"; }

    // ── Challans ──
    @GetMapping("/challans") public String challans(Model m) { m.addAttribute("pageTitle","Transfer Challans"); m.addAttribute("activeModule","store-challans"); return "store/challans/list"; }
    @GetMapping("/challans/create") public String challanCreate(Model m) { m.addAttribute("pageTitle","Create Challan"); m.addAttribute("activeModule","store-challans"); return "store/challans/create"; }
    @PostMapping("/challans/create") public String challanDoCreate() { return "redirect:/store/challans?saved=true"; }
    @GetMapping("/challans/{id}") public String challanView(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Challan Details"); m.addAttribute("activeModule","store-challans"); return "store/challans/view"; }
    @GetMapping("/challans/{id}/approve") public String challanApprove(@PathVariable String id) { return "redirect:/store/challans/" + id + "?approved=true"; }
    @GetMapping("/challans/{id}/dispatch") public String challanDispatch(@PathVariable String id) { return "redirect:/store/challans/" + id + "?sent=true"; }
    @GetMapping("/challans/{id}/receive") public String challanReceive(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Receive Challan"); m.addAttribute("activeModule","store-challans"); return "store/challans/receive"; }
    @PostMapping("/challans/{id}/receive") public String challanDoReceive(@PathVariable String id) { return "redirect:/store/challans/" + id + "?saved=true"; }
    @PostMapping("/challans/{id}/cancel") public String challanCancel(@PathVariable String id) { return "redirect:/store/challans?deleted=true"; }

    // ── Canteen Material Requests (received by Store for fulfilment) ──
    @GetMapping("/material-requests") public String mrList(Model m) { m.addAttribute("pageTitle","Canteen Material Requests"); m.addAttribute("activeModule","store-mr"); return "store/material-requests/list"; }
    @GetMapping("/material-requests/{id}") public String mrView(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Material Request Details"); m.addAttribute("activeModule","store-mr"); return "store/material-requests/view"; }
    @PostMapping("/material-requests/{id}/approve") public String mrApprove(@PathVariable String id) { return "redirect:/store/material-requests/" + id + "?approved=true"; }
    @PostMapping("/material-requests/{id}/reject") public String mrReject(@PathVariable String id) { return "redirect:/store/material-requests/" + id + "?rejected=true"; }
    @PostMapping("/material-requests/{id}/pack") public String mrPack(@PathVariable String id) { return "redirect:/store/material-requests/" + id + "?saved=true"; }
    @PostMapping("/material-requests/{id}/dispatch") public String mrDispatch(@PathVariable String id) { return "redirect:/store/material-requests/" + id + "?sent=true"; }

    // ── Day Book ──
    @GetMapping("/day-book") public String dayBook(Model m) { m.addAttribute("pageTitle","Day Book"); m.addAttribute("activeModule","store-daybook"); return "store/day-book"; }

    // ── Store Production (PLANNED) ──
    @GetMapping("/production") public String productionIndex(Model m) { m.addAttribute("pageTitle","Store Production"); m.addAttribute("activeModule","store-production"); return "redirect:/store/production/bom"; }
    @GetMapping("/production/bom") public String bomList(Model m) { m.addAttribute("pageTitle","BOM Master"); m.addAttribute("activeModule","store-production"); return "store/production/bom-list"; }
    @GetMapping("/production/bom/create") public String bomCreate(Model m) { m.addAttribute("pageTitle","Create BOM"); m.addAttribute("activeModule","store-production"); return "store/production/bom-create"; }
    @PostMapping("/production/bom/create") public String bomDoCreate() { return "redirect:/store/production/bom?saved=true"; }
    @GetMapping("/production/bom/{id}") public String bomView(@PathVariable String id, Model m) { m.addAttribute("pageTitle","BOM Details"); m.addAttribute("activeModule","store-production"); return "store/production/bom-view"; }
    @GetMapping("/production/orders") public String prodOrderList(Model m) { m.addAttribute("pageTitle","Production Orders"); m.addAttribute("activeModule","store-production"); return "store/production/order-list"; }
    @GetMapping("/production/orders/create") public String prodOrderCreate(Model m) { m.addAttribute("pageTitle","Create Production Order"); m.addAttribute("activeModule","store-production"); return "store/production/order-create"; }
    @PostMapping("/production/orders/create") public String prodOrderDoCreate() { return "redirect:/store/production/orders?saved=true"; }
    @GetMapping("/production/orders/{id}") public String prodOrderView(@PathVariable String id, Model m) { m.addAttribute("pageTitle","Production Order Details"); m.addAttribute("activeModule","store-production"); return "store/production/order-view"; }
    @GetMapping("/production/orders/{id}/start") public String prodOrderStart(@PathVariable String id) { return "redirect:/store/production/orders/" + id + "?saved=true"; }
    @GetMapping("/production/orders/{id}/complete") public String prodOrderComplete(@PathVariable String id) { return "redirect:/store/production/orders/" + id + "?saved=true"; }
}
