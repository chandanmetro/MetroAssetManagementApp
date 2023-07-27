package com.metro.app.metro.application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "device")
public class Device {
	@Id
	private String deviceName;
	private int deviceStock;
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public int getDeviceStock() {
		return deviceStock;
	}
	public void setDeviceStock(int deviceStock) {
		this.deviceStock = deviceStock;
	}
	public Device(String deviceName, int deviceStock) {
		super();
		this.deviceName = deviceName;
		this.deviceStock = deviceStock;
	}
	public Device() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Device [deviceName=" + deviceName + ", deviceStock=" + deviceStock + "]";
	}
	

}
