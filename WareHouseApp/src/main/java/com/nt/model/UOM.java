package com.nt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "uom_tab")
public class UOM {
	@Id
     @GeneratedValue(generator = "seq",strategy = GenerationType.SEQUENCE)
     @SequenceGenerator(name ="seq",sequenceName = "uom_seq")
	 @Column(name ="uom_id")
     private Integer id;
	@Column(name ="uom_type")
	 private String uomtype;
	@Column(name ="uom_model")
	 private String uomModel;
	@Column(name ="uom_descrip")
	 private String description;
	 
}
