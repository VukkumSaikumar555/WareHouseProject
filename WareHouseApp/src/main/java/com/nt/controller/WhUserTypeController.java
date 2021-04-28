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

import com.nt.model.WhUserType;
import com.nt.service.IWhUserType;

@Controller
@RequestMapping("/wh")
public class WhUserTypeController {
	
	@Autowired
	private IWhUserType service;
	
	@GetMapping("/record")
	public String getHome() {
		return "WhUserTypeRegister";
	}
	
	@PostMapping("/save")
	public String saveRecord(@ModelAttribute WhUserType whusertype,Model model) {
		Integer id=service.saveWhUserType(whusertype);
		String msg="The Record Inserted with id"+id;
		model.addAttribute("message",msg);
		return "WhUserTypeRegister";
	}
	
	@GetMapping("/all")
	public String getAllRecords(Model model) {
		List<WhUserType> listentities=service.getAllWhUserTypes();
		model.addAttribute("list",listentities);
		return "WhUserTypeDetails";
	}
	
	@GetMapping("/delete")
	public String deleteRecord(@RequestParam("id") Integer sid,Model model) {
		if(service.isWhUserTypeExists(sid)) {
			service.deleteWhUserType(sid);
			String message=new StringBuffer().append("Shipment Type"+sid+"Deleted").toString();
			model.addAttribute("message", message);
		}
		else {
			model.addAttribute("WhuserType with id"+sid+"not available");
		}
		model.addAttribute("list", service.getAllWhUserTypes());
		return "WhUserTypeDetails";
		
	}//delete
	
	@GetMapping("/edit")
	public String editRecord(@RequestParam("id") Integer sid,Model model) {
		String page=null;
		Optional<WhUserType> opt=service.getOneWhUserType(sid);
		if(opt.isPresent()) {
			model.addAttribute("WhUserType",opt.get());
			page="WhUserTypeEdit";
		}else {
			return "redirect:all";
		}
		return page;
	}
	
	@PostMapping("/update")
	public String updateRecord(@ModelAttribute WhUserType whusertype,Model model) {
		Integer id=service.UpdateWhUserType(whusertype);
		String message="The Record with id"+id+ "is Updated";
		model.addAttribute("message",message);
		model.addAttribute("list", service.getAllWhUserTypes());
		return "WhUserTypeDetails";
		
	}
	

}//class
