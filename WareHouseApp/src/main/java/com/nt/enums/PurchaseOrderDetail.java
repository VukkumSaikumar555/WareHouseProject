package com.nt.enums;

public enum PurchaseOrderDetail {
        OPEN("OPEN"),PICKING("PICKING"),ORDERED("ORDERED");
	private String value;
	
	PurchaseOrderDetail(String value){
		this.value=value;
	}
	public String getValue() {
		return value;
	}
}
