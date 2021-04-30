package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.model.PurchaseOrder;
import com.nt.service.IPurchaseOrder;

@Controller
@RequestMapping("/po")
public class PurchaseOrderController {
	
	@Autowired
	private IPurchaseOrder service;
	
	@GetMapping("/record")
	public String getHome(Model model) {
		PurchaseOrder po=new PurchaseOrder();
		po.setStatus("OPEN");
		//po.setOrderCode("CX1234");
		model.addAttribute("PO", po);
		return "PurchaseRegister";
	}
    
	@PostMapping("/save")
	public String savePurchaseOrder(@ModelAttribute PurchaseOrder purchaseOrder,Model model) {
		PurchaseOrder order=service.savePO(purchaseOrder);
		String msg=new StringBuffer( ).
				                         append("The Record inserted with id").
				                         append(order.getId()).
				                         append("Successfully").
				                         toString();
		model.addAttribute("message",msg);
		return "PurchaseRegister";
	}
	
	@GetMapping("/all")
	public String getAllRecords(Model model) {
		List<PurchaseOrder> listpo=service.getAllRecord();
		model.addAttribute("list", listpo);
		return "PurchaseDataList";
	}
	
}//class
