package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table
public class LikePosts {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int like_id;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@Column
	private boolean isLiked;
	@JsonIgnore
	@ManyToOne
	private Publication pub;
}
