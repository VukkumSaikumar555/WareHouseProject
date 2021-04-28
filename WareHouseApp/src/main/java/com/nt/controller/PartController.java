package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Parts;
import com.nt.service.IOrderMethodService;
import com.nt.service.IPart;
import com.nt.service.IUOMService;
import com.nt.util.Apputil;

@Controller
@RequestMapping("/pt")
public class PartController {
	
	@Autowired
	private IPart service;
	
	@Autowired
	private Apputil util;
	
	@Autowired
	private IUOMService uomservice;
	
	@Autowired
	private IOrderMethodService saleService;
     
	@GetMapping("/show")
	public String getPage(Model model) {
		childUi(model);
		childSaleUi(model);
		return "PartsRegister";
	}
	
	
	
	@PostMapping("/save")
	public String saveRecord(@ModelAttribute Parts parts,Model model) {
		Integer id=service.savePart(parts);
		String message="The Record with id "+id+"is saved";
		childUi(model);
		model.addAttribute("message", message);
		return "PartsRegister";
	}
	
	
	@GetMapping("/all")
	public String getAllRecord(Model model) {
		List<Parts> list=service.getallParts();
		model.addAttribute("list",list);
		return "PartsRecord";
	}
	
	@GetMapping("/edit")
	public String editRecord(@RequestParam("id") Integer sid,Model model) {
		Optional<Parts> opt=service.getOnePart(sid);
		if(opt.isPresent()) {
			model.addAttribute("parts", opt.get());
			childUi(model);
			childSaleUi(model);
			return "PartsEdit";
		}else {
			return "redirect:all";
		}
		
	}
	@PostMapping("/update")
	public String updateRecord(@ModelAttribute Parts parts,Model model) {
		Integer id=service.UpdatePart(parts);
		String msg=new StringBuffer("The Record with id")
				                                                  .append(id).append("is updated")
				                                                 .toString();
		model.addAttribute("message", msg);
		//util.getdetails(model);
		List<Parts> list=service.getallParts();
		childUi(model);
		childSaleUi(model);
		model.addAttribute("list",list);
		return "PartsRecord";
		
	}
	
	@GetMapping("/delete")
	public String deleteRecord(@RequestParam Integer id,Model model) {
		boolean flag=service.isPartExist(id);
		if(flag==true) {
			service.deletePart(id);
			String message=new StringBuffer().append("Part Type").append(id).append("Deleted").toString();
			model.addAttribute("message", message);
		}else {
			model.addAttribute("message", "The Part Type is Not Available");
		}
		util.getdetails(model);
		return "PartsRecord";
		
	}
	
	
	private void childUi(Model model) {
		Map<Integer,String> uoms=uomservice.getUomIdAndModel();
		model.addAttribute("uoms", uoms);
	}
	
	private void childSaleUi(Model model) {
		Map<Integer,String> sales=saleService.getOrderMethodIdAndCode("sale");
		model.addAttribute("sales", sales);
	}
	
}//class
