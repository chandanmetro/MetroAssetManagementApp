package com.metro.app.metro.application.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.metro.app.metro.application.entity.Desktop;
import com.metro.app.metro.application.service.DesktopService;

@Controller
public class DesktopController {
	
	private final DesktopService desktopService;
	
	public DesktopController(DesktopService desktopService)
	{
		this.desktopService = desktopService;
	}
	
	@GetMapping("/desktopdetails.html")
	public String showDesktopDetails(Model model)
	{
		List<Desktop> desktops = desktopService.getAllDesktop();
		model.addAttribute("desktops", desktops);
		return "desktopdetails";
	}
	
	@PostMapping("/adddesktop")
	public String addDesktop(@ModelAttribute Desktop desktop)
	{
		if(desktop.getModel().equals("Others")) {
			desktop.setModel(desktop.getOtherModel());
		}
		
		if(desktop.getStorage().equals("Others")) {
			desktop.setStorage(desktop.getOtherStorage());
		}
		
		if(desktop.getRam().equals("Others")) {
			desktop.setRam(desktop.getOtherRAM());
		}
		
		if(desktop.getWarrantyType().equals("Others")) {
			desktop.setWarrantyType(desktop.getOtherWarrantyType());
		}
			
		desktopService.addDesktop(desktop);
		return "redirect:/desktopdetails.html";
	}
	
	@GetMapping("/desktopadd.html")
	public String showAddDesktopForm()
	{
		return "desktopadd";
	}
	
	
	@GetMapping("/checkDuplicateSerialNumberDesktop/{serialNumber}")
	public ResponseEntity<Map<String, Boolean>> checkDuplicateSerialNumberDesktop(@PathVariable String serialNumber ){
		
		boolean isDuplicateDesktop = desktopService.isSerialNumberDuplicateDesktop(serialNumber);
		Map<String, Boolean> response = new HashMap<>();
		response.put("isDuplicateDesktop", isDuplicateDesktop);
		return ResponseEntity.ok(response);
		
	}
	
	
	
	@PostMapping("/update-data-desktop")
	 public ResponseEntity<Desktop> create(@RequestBody Desktop updatedDesktop){
		Desktop created = desktopService.updateDesktop(updatedDesktop);
		return new ResponseEntity<>(created, HttpStatus.OK);
	}

}
