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
import com.metro.app.metro.application.entity.Server;
import com.metro.app.metro.application.service.ServerService;

@Controller
public class ServerController{

	private final ServerService serverService;
	
	public ServerController(ServerService serverService) {
		this.serverService = serverService;
	}
	
	@GetMapping("/serverdetails.html")
	public String showServerDetails(Model model) {
		List<Server> servers = serverService.getAllServers();
		model.addAttribute("servers",servers);
		return "serverdetails";
		
	}
	
	
	
	@PostMapping("/addserver")
	public String addServer(@ModelAttribute Server server) {
		
		if (server.getModel().equals("Others")) {
			server.setModel(server.getOtherModel());
		}
		
		if (server.getStorage().equals("Others")) {
			server.setStorage(server.getOtherStorage());
		}
		
		if (server.getRam().equals("Others")) {
			server.setRam(server.getOtherRAM());
		}
		
		if (server.getWarrantyType().equals("Othesr")) {
			server.setWarrantyType(server.getOtherWarrantyType());
		}
		
		if (server.getLocation().equals("Others")) {
			server.setLocation(server.getOtherLocation());
		}
		serverService.addServer(server);
		return "redirect:/serverdetails.html";
	}
	
	@GetMapping("/serveradd.html")
	public String showAddServerForm() {
		return "serveradd";
	}
	
	@GetMapping(("/checkDuplicateSerialNumberServer/{serialNumber}"))
	public ResponseEntity<Map<String, Boolean>> checkDuplicateSerialNumberServer(@PathVariable String serialNumber){
		boolean isDuplicateServer = serverService.isSerialNumberDuplicateServer(serialNumber);
		Map<String, Boolean> response = new HashMap<>();
		response.put("isDuplicateServer", isDuplicateServer);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/update-data-server")
	public ResponseEntity<Server> create(@RequestBody Server updatedServer){
		Server created = serverService.updateServer(updatedServer);
		return new ResponseEntity<>(created, HttpStatus.OK);
	}
	
	
}
