package com.nt.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.OrderMethod;
import com.nt.service.IOrderMethodService;

@Controller("com")
@RequestMapping("/om")
public class OrderMethodController {
   
	@Autowired	
	private IOrderMethodService service;
	
	@GetMapping("/reg")
	public String saveRecord() {
		return "OrderMethodRegister";
		//return "Order1";
	}
	
	@PostMapping("/save")
	public String saveRecords(@ModelAttribute OrderMethod  orderMethod,Model model) {
		OrderMethod message=service.saveRecord(orderMethod);
		//Integer ent=service.saveRecord(orderMethod);
		model.addAttribute("message","Record inserted with id" +message.getId());
		return "OrderMethodRegister";
		//return "Order1";
	}
    @GetMapping("/all")
	public String getRecords(Model model) {
		List<OrderMethod> list=service.getAllDetails();
		model.addAttribute("list",list);
		return "OrderDetails";
		
	}
	
	  @GetMapping("/edit") 
	  public String editRecord(@RequestParam("id") Integer sid,Model model) { 
	  String page=null; 
	 Optional<OrderMethod> opt=service.editRecord(sid); 
	 if(opt.isPresent()) { 
	  model.addAttribute("opt", opt.get());
	   page="OrderEditboot"; 
	   } 
	   else { 
	           page="redirect:all";
	    } 
	   return page;
	  
	  
	 }
	 
    @PostMapping("/update")
   public String UpdateRecord(@ModelAttribute OrderMethod orderMethod,Model model) {
	   OrderMethod om=service.updateRecord(orderMethod);
	   String message="The person with Id"+om.getId()+"is updated";
	   model.addAttribute("message", message);
	   List<OrderMethod> list=service.getAllDetails();
		model.addAttribute("list",list);
	return "OrderDetails";
	   
   }
	
    
    
    @GetMapping("/delete")
    public String deleteRecord(@RequestParam("id") Integer sid,Model  model) {
    	service.deleteOrder(sid);
    	String message="The Order Method with id"+sid+"is deleted";
    	model.addAttribute("message", message);
    	 List<OrderMethod> list=service.getAllDetails();
 		model.addAttribute("list",list);
		return "OrderDetails";
    	
    }
	
}//class
