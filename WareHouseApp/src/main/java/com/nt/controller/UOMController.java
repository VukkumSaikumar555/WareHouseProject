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

import com.nt.model.UOM;
import com.nt.service.IUOMService;

@Controller
@RequestMapping("/uom")
public class UOMController {
	@Autowired
	private IUOMService service;
	
	@GetMapping("/show")
	public String getDetails() {
		return "UomRegister";
	}
	
	@GetMapping("/all")
	public String getAllDetails(Model model) {
		List<UOM> list=service.getAllDetails();
		model.addAttribute("list",list);
		return "UomDetailsRegister";
	}
	
	
	@PostMapping("/save")
	public String saveDetails(@ModelAttribute UOM uom,Model model) {
		UOM ent=service.saveRecord(uom);
		String msg="Record saved with id"+ent.getId();
		model.addAttribute("message",msg);
		return "UomRegister";
		
	}
	
	
	@GetMapping("/edit")
	public String editDetails(@RequestParam("id") Integer sid,Model model) {
		Optional<UOM> opt=service.editRecord(sid);
		model.addAttribute("uom",opt.get());
		return "UomEdit";
		
	}
	
	@PostMapping("/update")
	public String updateDetails(@ModelAttribute UOM uom,Model model) {
		UOM uom1=service.updateRecord(uom);
		String msg="The Record with id"+uom1.getId()+"is updated";
		model.addAttribute("message",msg);
		List<UOM> list=service.getAllDetails();
		model.addAttribute("list",list);
		
		return "UomDetailsRegister";
		
	}
	
	
	@GetMapping("/delete")
	public String deleteDetails(@RequestParam("id") Integer sid,Model model) {
		service.deleteOrder(sid);
		List<UOM> list=service.getAllDetails();
		model.addAttribute("list",list);
		model.addAttribute("uom","The Order With id"+sid+"deleted");
		return "UomEdit";
		
	}
	
	
	
	
	

}//class
