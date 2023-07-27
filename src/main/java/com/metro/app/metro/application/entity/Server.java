package com.metro.app.metro.application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="server")
public class Server {
	
	@Id
	private String serialNumber;
	private String model;
	private String deviceMac;
	private String processor;
	private String screenSize;
	private String storageType;
	private String storage;
	private String ram;
	private String assetInDate;
	private String warranty;
	private String warrantyType;
	private String remarks;
	private String location;
	private String employeeName;
	private String employeeId;
	private String employeePhoneNumber;
	private String assetProvider;
	
	@Transient // Mark the field as transient so that it is not persisted in the database
    private String otherModel;

    @Transient
    private String otherStorage;

    @Transient
    private String otherRAM;

    @Transient
    private String otherWarrantyType;
    
    @Transient
    private String otherLocation;
	
	
	public Server() {
		
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDeviceMac() {
		return deviceMac;
	}
	public void setDeviceMac(String deviceMac) {
		this.deviceMac = deviceMac;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}
	public String getStorageType() {
		return storageType;
	}
	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getAssetInDate() {
		return assetInDate;
	}
	public void setAssetInDate(String assetInDate) {
		this.assetInDate = assetInDate;
	}
	public String getWarranty() {
		return warranty;
	}
	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}
	public String getWarrantyType() {
		return warrantyType;
	}
	public void setWarrantyType(String warrantyType) {
		this.warrantyType = warrantyType;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeePhoneNumber() {
		return employeePhoneNumber;
	}
	public void setEmployeePhoneNumber(String employeePhoneNumber) {
		this.employeePhoneNumber = employeePhoneNumber;
	}
	public String getAssetProvider() {
		return assetProvider;
	}
	public void setAssetProvider(String assetProvider) {
		this.assetProvider = assetProvider;
	}
	

	public String getOtherModel() {
        return otherModel;
    }

    public void setOtherModel(String otherModel) {
        this.otherModel = otherModel;
    }
    
    public String getOtherStorage() {
        return otherStorage;
    }

    public void setOtherStorage(String otherStorage) {
        this.otherStorage = otherStorage;
    }
    
    public String getOtherRAM() {
        return otherRAM;
    }

    public void setOtherRAM(String otherRAM) {
        this.otherRAM = otherRAM;
    }
    
    public String getOtherWarrantyType() {
        return otherWarrantyType;
    }

    public void setOtherWarrantyType(String otherWarrantyType) {
        this.otherWarrantyType = otherWarrantyType;
    }
    
    public String getOtherLocation() {
        return otherLocation;
    }

    public void setOtherLocation(String otherLocation) {
        this.otherLocation = otherLocation;
    }
	
	
	
	public Server(String serialNumber, String model, String deviceMac, String processor, String screenSize,
			String storageType, String storage, String ram, String assetInDate, String warranty, String warrantyType,
			String remarks, String location, String employeeName, String employeeId, String employeePhoneNumber,
			String assetProvider) {
		super();
		this.serialNumber = serialNumber;
		this.model = model;
		this.deviceMac = deviceMac;
		this.processor = processor;
		this.screenSize = screenSize;
		this.storageType = storageType;
		this.storage = storage;
		this.ram = ram;
		this.assetInDate = assetInDate;
		this.warranty = warranty;
		this.warrantyType = warrantyType;
		this.remarks = remarks;
		this.location = location;
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.employeePhoneNumber = employeePhoneNumber;
		this.assetProvider = assetProvider;
	}
	@Override
	public String toString() {
		return "Sever [serialNumber=" + serialNumber + ", model=" + model + ", deviceMac=" + deviceMac + ", processor="
				+ processor + ", screenSize=" + screenSize + ", storageType=" + storageType + ", storage=" + storage
				+ ", ram=" + ram + ", assetInDate=" + assetInDate + ", warranty=" + warranty + ", warrantyType="
				+ warrantyType + ", remarks=" + remarks + ", location=" + location + ", employeeName=" + employeeName
				+ ", employeeId=" + employeeId + ", employeePhoneNumber=" + employeePhoneNumber + ", assetProvider="
				+ assetProvider + "]";
	}
	
	

}
