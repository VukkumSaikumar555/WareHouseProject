package com.nt.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;

import com.nt.model.Parts;
import com.nt.service.IPart;

@Configuration
public class Apputil {
	
	@Autowired
	private IPart service;
     
	
	public  Model getdetails(Model model) {
		List<Parts> list=service.getallParts();
		model.addAttribute("list",list);
		return model;
	}

}
