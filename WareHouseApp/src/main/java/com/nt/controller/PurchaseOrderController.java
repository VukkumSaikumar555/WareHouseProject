package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.model.PurchaseOrder;

@Controller
@RequestMapping("/po")
public class PurchaseOrderController {
	
	@GetMapping("/record")
	public String getHome(Model model) {
		PurchaseOrder po=new PurchaseOrder();
		po.setStatus("OPEN");po.setOrderCode("A145");
		model.addAttribute("PO", po);
		return "PurchaseRegister";
	}

}
