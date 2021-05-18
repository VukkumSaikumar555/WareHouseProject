package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.model.PurchaseOrder;
import com.nt.service.IPurchaseOrder;
import com.nt.service.IShipmentType;
import com.nt.service.IWhUserType;

@Controller
@RequestMapping("/po")
public class PurchaseOrderController {
	
	@Autowired
	private IPurchaseOrder service;
	
	@Autowired
	private IShipmentType ships;
	
	@Autowired
	private IWhUserType whuser;
	
	private void childsui(Model model) {
	  Map<Integer,String> maps= ships.getShipmentTypeIdCode();
	  model.addAttribute("ships", maps);
	}
	
	private void childswhui(Model model) {
		Map<Integer,String> maps=whuser.getIdAndCodeByType("Vendor");
		model.addAttribute("whuser", maps);
	}
	
	@GetMapping("/record")
	public String getHome(Model model) {
		PurchaseOrder po=new PurchaseOrder();
		childsui(model);
		childswhui(model);
		po.setStatus("OPEN");
		//po.setOrderCode("AK125");
		
		  model.addAttribute("PO", po);
		  
		  return "PurchaseRegister";
		 
	}
	@PostMapping("/save")
	public String savePurchaseOrder(@ModelAttribute PurchaseOrder po1,Model model) {
		PurchaseOrder order=service.savePO(po1);
		String msg=new StringBuffer( ).
				                         append("The Record inserted with id").
				                         append(order.getId()).
				                         append("Successfully").
				                         toString();
		PurchaseOrder po=new PurchaseOrder();
			  po.setStatus("OPEN"); 
		 model.addAttribute("PO", po);
		  
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
