package com.nt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="whuser_tab")
public class WhUserType {
	@Id
	@GeneratedValue(generator = "gen")
	@SequenceGenerator(name="gen",sequenceName = "wh_seq_type")
	@Column(name = "wh_id_col")
	private Integer id;
	@Column(name = "wh_usertype_col")
	private String usertype;
	@Column(name = "wh_usercode_col")
	private String usercode;
	@Column(name = "wh_userfor_col")
	private String userfor;
	@Column(name = "wh_email_col")
	private String email;
	@Column(name = "wh_contact_col")
	private String contact;
	@Column(name = "wh_userid_col")
	private String userid;
	@Column(name = "wh_userif_col")
	private String userif;
	@Column(name = "wh_idnumber_col")
	private String idnumber;
	

}
