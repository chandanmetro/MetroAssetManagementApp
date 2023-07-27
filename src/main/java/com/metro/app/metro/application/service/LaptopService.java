package com.metro.app.metro.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.metro.app.metro.application.entity.Laptop;
import com.metro.app.metro.application.repository.LaptopRepository;

@Service
public class LaptopService {

	private final LaptopRepository laptopRepository;

	public LaptopService(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

	public void addLaptop(Laptop laptop) {
		laptopRepository.save(laptop);
		// TODO Auto-generated method stub

	}

	public void editLaptop(Laptop laptop) {
		laptopRepository.save(laptop);
		// TODO Auto-generated method stub
		
	}
	

	 public void deleteBySerialNumber(String serialNumber) {
		 laptopRepository.deleteById(serialNumber);
	        //laptopRepository.deleteById(serialNumber);
	    }
	 
	 
	 
	 public boolean isSerialNumberDuplicate(String serialNumber) {
	        return laptopRepository.existsBySerialNumber(serialNumber);
	    }
	 public Laptop getBySerialNumber(String serialNumber) {
	        Optional<Laptop> laptopOptional = laptopRepository.findById(serialNumber);
	        return laptopOptional.orElse(null);
	    }

	 public Laptop updateLaptop(Laptop updatedLaptop) {
	        Laptop existingLaptop = laptopRepository.findById(updatedLaptop.getSerialNumber())
	                .orElseThrow();
	        existingLaptop.setModel(updatedLaptop.getModel());
	        existingLaptop.setStorage(updatedLaptop.getStorage());
	        existingLaptop.setRam(updatedLaptop.getRam());
	        
	        
	        existingLaptop.setAssetInDate(updatedLaptop.getAssetInDate());
	        existingLaptop.setWarrantyType(updatedLaptop.getWarrantyType());
	        existingLaptop.setLocation(updatedLaptop.getLocation());
	        existingLaptop.setEmployeeName(updatedLaptop.getEmployeeName());
	        existingLaptop.setEmployeeId(updatedLaptop.getEmployeeId());
	        existingLaptop.setEmployeePhoneNumber(updatedLaptop.getEmployeePhoneNumber());
	        existingLaptop.setRemarks(updatedLaptop.getRemarks());
	        existingLaptop.setAssetProvider(updatedLaptop.getAssetProvider());

	        return laptopRepository.save(existingLaptop);
	    }



    // Add more methods for additional operations (e.g., adding a laptop, updating, deleting, etc.)



}
