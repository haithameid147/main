/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youtube.jwt.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author eid
 */

@Entity
@Table(name = "orders")
public class Orders implements java.io.Serializable {
	private Integer id;
	// @JsonManagedReference
	private Service service;
	// @JsonManagedReference
	private City city;
	private String phone;
	private String name;
	private String communication;
	private String information;
	private Date created = new Date();

	public Orders() {
	}

	public Orders(Integer id, Service service, City city, String phone, String name, String communication,
			String information) {
		this.id = id;
		this.service = service;
		this.city = city;
		this.phone = phone;
		this.name = name;
		this.communication = communication;
		this.information = information;
		this.created = new Date();

	}
//  @Id
//  @Column(name = "id")
//  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
//  @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "service_id", nullable = false)

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "city_id", nullable = false)
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Column(name = "phone", nullable = false, length = 15)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "name", nullable = false, length = 250)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "communication")
	public String getCommunication() {
		return communication;
	}

	public void setCommunication(String communication) {
		this.communication = communication;
	}

	@Column(name = "information" , length = 500 )
	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	@Column(name = "created")

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
