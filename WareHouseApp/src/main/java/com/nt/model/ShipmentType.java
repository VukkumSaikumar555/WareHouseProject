package com.nt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ShippingDetails")
public class ShipmentType {
	@Id
	@GeneratedValue
	private Integer id;
	private String ShipmentMode;
	private String ShipmentCode;
	private String EnableShipment;
	private String ShipmentGrade;
	private String ShipmentDescription;
	

}
