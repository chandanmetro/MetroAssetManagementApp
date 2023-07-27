package com.metro.app.metro.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.metro.app.metro.application.entity.Device;
import com.metro.app.metro.application.entity.Laptop;
import com.metro.app.metro.application.repository.DeviceRepository;
import com.metro.app.metro.application.service.DeviceService;


@Controller
public class DeviceController {
	
	@Autowired
	private final DeviceService deviceService;
	
	public DeviceController(DeviceService deviceService)
	{
		this.deviceService = deviceService;
	}
	
	@GetMapping("/devicedetails.html")
	public String showDeviceDetails(Model model) {
        List<Device> devices = deviceService.getAllDevices();
        model.addAttribute("devices", devices);
        return "devicedetails";
    }
	
	@PostMapping("/adddevice")
	public String addDevice(@ModelAttribute Device device) {
	    // Save the device to the database using a repository or service
		deviceService.addDevice(device);
	    //deviceRepository.save(device);

	    // Redirect to the device list page after successful addition
	    return "redirect:/devicedetails.html";
	}
	
	@GetMapping("/deviceadd.html")
    public String showAddDeviceForm() {
        return "deviceadd"; // Return the name of the HTML file (without the extension)
    }
	
	
	
	



}
