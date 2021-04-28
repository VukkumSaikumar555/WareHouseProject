package com.nt.controller;

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

import com.nt.model.ShipmentType;
import com.nt.service.IShipmentType;

@Controller("ctr")
@RequestMapping("/st")
public class ShipmentTypeController {
	
	  @Autowired
	  private IShipmentType service;
	 
	@GetMapping("/register")
	public String ShowReg() {
		return "ShipmentTypeRegisterboot";
	}
	
	@PostMapping("/record")
	public String saveShipmentType(@ModelAttribute ShipmentType shipmentType,Model model) {
		Integer sid=service.saveShipmentType(shipmentType);
		//creating message
		String message="The Record inserted with id" +sid;
		//send to ui
		model.addAttribute("message",message);
		return "ShipmentTypeRegisterboot";
		
	}
    @GetMapping("/all")
	public String showAllShipmentTypes(Model model) {
    	List<ShipmentType> list=service.getAllShipmentTypes();
    	//sending to ui
    	model.addAttribute("list", list);
		return "ShipmentTypeDataBoot";
    }
  
    @GetMapping("/delete")
    public String deleteById(@RequestParam Integer id,Model model) {
    	
    	if(service.isShipmentTypeExists(id))
    	{     
    		service.deleteShipmentType(id);
    		//create message
    		String message=new StringBuffer().append("Shipment Type").append(id).append("Deleted").toString();
    		model.addAttribute("message", message);
    	}
    	else {
    		model.addAttribute("Shipment Type"+id+"Not Available");
    		
    	}
    	//latest data
    	model.addAttribute("list",service.getAllShipmentTypes());
		return "ShipmentTypeDataBoot";
    	
    }
   @GetMapping("/edit")
    public String EditShipment(@RequestParam("id") Integer sid,Model model) {
    	String page=null;
	   Optional<ShipmentType> opt=service.getOneShipmentType(sid);
	   if(opt.isPresent()) {
		   model.addAttribute("shipmentType",opt.get());
		   page="ShipmentTypeEditBoot";
	   }
	   else {
		   return "redirect:all";
	   }
		return page;
	   
   }//edit
   
   @PostMapping("/update")
   public String UpdateShipment(@ModelAttribute ShipmentType shipmentType,Model model) {
	  Integer id=service.UpdateShipMentType(shipmentType);
	  //pass the data to ui
	 model.addAttribute("message","Shipment Type with id "+id+" Updated successfully");
	  //sending latest data to ui
	 
	 model.addAttribute("list",service.getAllShipmentTypes());
	  
	 return "ShipmentTypeDataBoot";
	   
   }
    
    
	
	
}//class
