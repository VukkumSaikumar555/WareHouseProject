package com.nt.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="order_method_tab")
public class OrderMethod {
	@Id
	@SequenceGenerator(name = "gen",sequenceName = "om_seq_test")
	@GeneratedValue(generator = "gen",strategy = GenerationType.SEQUENCE)
	@Column(name = "order_id_col")
    private Integer id;
	@Column(name = "order_mode_col")
    private String OrderMode;
	@Column(name = "order_code_col")
    private String OrderCode;
	@Column(name = "order_type_col")
    private String OrderType;
    @ElementCollection
    @CollectionTable(name="order_acpt_tab",
                                       joinColumns = @JoinColumn(name="order_id_col"))
    @Column(name = "order_acpt_col")
    private Set<String> orderAcpt;
    @Column(name = "order_desc_col")
    private String OrderDesc;
}
