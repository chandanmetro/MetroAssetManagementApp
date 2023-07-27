package com.metro.app.metro.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metro.app.metro.application.entity.Server;
import com.metro.app.metro.application.repository.ServerRepository;

@Service
public class ServerService {
	
	private final ServerRepository serverRepository;
	
	public ServerService(ServerRepository serverRepository) {
		this.serverRepository = serverRepository;
	}
	
	public List<Server> getAllServers(){
		return serverRepository.findAll();
	}
	
	public void addServer(Server server) {
		serverRepository.save(server);
		
	}
	
	
	
	public boolean isSerialNumberDuplicateServer(String serialNumber) {
		return serverRepository.existsBySerialNumber(serialNumber);
	}

	public Server updateServer(Server updatedServer) {
		Server existingServer = serverRepository.findById(updatedServer.getSerialNumber()).orElseThrow();
		existingServer.setModel(updatedServer.getModel());
		existingServer.setStorage(updatedServer.getStorage());
		existingServer.setRam(updatedServer.getRam());
		existingServer.setAssetInDate(updatedServer.getAssetInDate());
		existingServer.setWarrantyType(updatedServer.getWarrantyType());
		existingServer.setLocation(updatedServer.getLocation());
		existingServer.setRemarks(updatedServer.getRemarks());
		
		// TODO Auto-generated method stub
		return serverRepository.save(existingServer);
	}

}
