package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table
public class Comments extends AuditModel {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String Comment_field;
	@JsonIgnore
	@ManyToOne
	private User user;
	@JsonIgnore
	@ManyToOne
	private Publication pub_id;
	@OneToMany(mappedBy="com",cascade=CascadeType.ALL)
	private List<LikeComments> like_comments;
	
	
	
}
