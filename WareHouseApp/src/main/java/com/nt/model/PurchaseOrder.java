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

import lombok.Data;

@Data
@Entity
@Table(name = "purchase_order_table")
public class PurchaseOrder {
	      @Id
	      @GeneratedValue(generator ="purchase",strategy = GenerationType.SEQUENCE)
	      @SequenceGenerator(name = "purchase",sequenceName = "po_seq")
	      @Column(name = "po_id_col")
          private Integer id;
	      @Column(name = "po_code_col")
          private String OrderCode;
	      @Column(name = "po_ref_num_col")
          private String refNumber;
	      @Column(name = "po_qty_check_col")
          private String qtycheck;
	      @Column(name = "po_status_col")
          private String status;
	      @Column(name = "po_description_col")
          private String description;
	     
	      @ManyToOne
	     @JoinColumn(name = "shipment_idfk_col")
          private ShipmentType code;
         
	     @ManyToOne
	    @JoinColumn(name = "vendor_idfk_col")
           private WhUserType vendor;
        
         
               
}


