package com.metro.app.metro.application.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.metro.app.metro.application.entity.Desktop;
import com.metro.app.metro.application.repository.DesktopRepository;


@Service
public class DesktopService {
	
	private final DesktopRepository desktopRepository;
	public DesktopService(DesktopRepository desktopRepository)
	{
		this.desktopRepository = desktopRepository;
	}
	
	public List<Desktop> getAllDesktop()
	{
		return desktopRepository.findAll();
	}
	
	public void addDesktop(Desktop desktop)
	{
	 desktopRepository.save(desktop);
	}
	
    public Desktop updateDesktop(Desktop updatedDesktop) {
	    Desktop existingDesktop = desktopRepository.findById(updatedDesktop.getSerialNumber()).orElseThrow();
		existingDesktop.setModel(updatedDesktop.getModel());
		existingDesktop.setStorage(updatedDesktop.getStorage());
		existingDesktop.setRam(updatedDesktop.getRam());
		existingDesktop.setAssetInDate(updatedDesktop.getAssetInDate());
		existingDesktop.setWarrantyType(updatedDesktop.getWarrantyType());
		existingDesktop.setLocation(updatedDesktop.getLocation());
		existingDesktop.setEmployeeName(updatedDesktop.getEmployeeName());
		existingDesktop.setEmployeeId(updatedDesktop.getEmployeeId());
		existingDesktop.setEmployeePhoneNumber(updatedDesktop.getEmployeePhoneNumber());
		existingDesktop.setRemarks(updatedDesktop.getRemarks());
		existingDesktop.setAssetProvider(updatedDesktop.getAssetProvider());
		
		return desktopRepository.save(existingDesktop);
		
	}
    
   

	public boolean isSerialNumberDuplicateDesktop(String serialNumber) {
		return desktopRepository.existsBySerialNumber(serialNumber);
	}

}
