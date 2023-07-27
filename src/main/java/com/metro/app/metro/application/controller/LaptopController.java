package com.metro.app.metro.application.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.metro.app.metro.application.entity.Laptop;
import com.metro.app.metro.application.service.LaptopService;

@Controller
class LaptopController {


	private final LaptopService laptopService;

    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @GetMapping("/laptopdetails.html")
    public String showLaptopDetails(Model model) {
        List<Laptop> laptops = laptopService.getAllLaptops();
        model.addAttribute("laptops", laptops);
        return "laptopdetails";
    }

    @PostMapping("/addlaptop")
    public String addLaptop(@ModelAttribute Laptop laptop) {
    	
    	if (laptop.getModel().equals("Others")) {
            laptop.setModel(laptop.getOtherModel());
        }

        // Check if the selected storage is "Others" and use the value from "otherStorage" field if available
        if (laptop.getStorage().equals("Others")) {
            laptop.setStorage(laptop.getOtherStorage());
        }

        // Check if the selected RAM is "Others" and use the value from "otherRAM" field if available
        if (laptop.getRam().equals("Others")) {
            laptop.setRam(laptop.getOtherRAM());
        }

        // Check if the selected warranty type is "Others" and use the value from "otherWarrantyType" field if available
        if (laptop.getWarrantyType().equals("Others")) {
            laptop.setWarrantyType(laptop.getOtherWarrantyType());
        }
    	
    	
      laptopService.addLaptop(laptop);
      return "redirect:/laptopdetails.html";
    }

    @PostMapping("/editlaptop")
    public String editLaptop(@ModelAttribute Laptop laptop) {
      laptopService.editLaptop(laptop);
      return "redirect:/laptopdetails.html";
    }
    
   

    // Other methods for handling requests

    @GetMapping("/laptopedit.html")
	public String showEditLaptopForm() {
        return "laptopedit"; // Return the name of the HTML file (without the extension)
    }


    @GetMapping("/laptopadd.html")
    public String showAddLaptopForm() {
        return "laptopadd"; // Return the name of the HTML file (without the extension)
    }


@DeleteMapping("/delete/{serialNumber}")
public String deleteLaptop(@PathVariable(value = "serialNumber") String serialNumber) {
    laptopService.deleteBySerialNumber(serialNumber);
    return "laptopdetails";
    
   // return ResponseEntity.ok("Laptop deleted successfully");
}


@GetMapping("/checkDuplicateSerialNumber/{serialNumber}")
public ResponseEntity<Map<String, Boolean>> checkDuplicateSerialNumber(@PathVariable String serialNumber) {
    boolean isDuplicate = laptopService.isSerialNumberDuplicate(serialNumber);
    Map<String, Boolean> response = new HashMap<>();
    response.put("isDuplicate", isDuplicate);
    return ResponseEntity.ok(response);
}


@PostMapping("/update-data")
public ResponseEntity<Laptop> create(@RequestBody  Laptop updatedLaptop) {
	Laptop created = laptopService.updateLaptop(updatedLaptop);
    return new ResponseEntity<>(created, HttpStatus.OK);
}


}




