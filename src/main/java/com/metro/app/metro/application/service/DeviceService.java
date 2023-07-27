package com.metro.app.metro.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metro.app.metro.application.entity.Device;
import com.metro.app.metro.application.repository.DeviceRepository;

@Service
public class DeviceService {
	
	private final DeviceRepository deviceRepository;
	
	public DeviceService(DeviceRepository deviceRepository)
	{
		this.deviceRepository = deviceRepository;
	}
	
	
	public List<Device> getAllDevices() {
		// TODO Auto-generated method stub
		return deviceRepository.findAll();
	}
	public void addDevice(Device device)
	{
		deviceRepository.save(device);
	}

}
