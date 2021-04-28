package com.nt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parts_tab")
public class Parts {
	@Id
	@GeneratedValue(generator ="part",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "part",sequenceName = "part_seq")
	private Integer id;
	@Column(name = "code_tab")
	private String partcode;
	
	@Column(name="partwid_col")
	private Double partwid;
	
	@Column(name="partlen_col")
	private Double partlen;
	
	@Column(name="partht_col")
	private Double partht;
	
	@Column(name = "basecost_tab")
	private Double basecost;
	
	@Column(name = "currency_tab")
	private String Currency;
	
	@Column(name = "description_tab")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="uom_id_fk_col")
	private UOM uom;
	
	@ManyToOne
	@JoinColumn(name="sale_id_fk_col")
	private OrderMethod sale;
		
		

}
