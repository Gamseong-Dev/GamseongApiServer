package com.highluck.gamseong.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/files")
public class FileController {
	
	@RequestMapping("/{img}")
	public String getImg(@PathVariable("img") String img){
		System.out.println("redirect:/resources/" + img+".png");
		
		return "redirect:/resources/" + img+".png";
	}

}
