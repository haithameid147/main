package com.youtube.jwt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="area"
 
)
public class Area  implements java.io.Serializable {
     private Integer id;
     private City city;
     private String nameAr;
     private String nameEn;
//     private Set<DeliveryArea> deliveryAreas = new HashSet<DeliveryArea>(0);
//     private Set<Order> orders = new HashSet<Order>(0);
//     private Set<Branch> branches = new HashSet<Branch>(0);

    public Area() {
    }

	
    public Area(City city, String nameAr, String nameEn) {
        this.city = city;
        this.nameAr = nameAr;
        this.nameEn = nameEn;
    }
//    public Area(City city, String nameAr, String nameEn, Set<DeliveryArea> deliveryAreas, Set<Order> orders, Set<Branch> branches) {
//       this.city = city;
//       this.nameAr = nameAr;
//       this.nameEn = nameEn;
//       this.deliveryAreas = deliveryAreas;
//       this.orders = orders;
//       this.branches = branches;
//    }
   
//  @Id
//  @Column(name = "id")
//  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
//  @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    
    
    
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    
    @ManyToOne(fetch=FetchType.EAGER , cascade = CascadeType.MERGE)
    @JoinColumn(name="city_id", nullable=false)
    public City getCity() {
        return this.city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    
    @Column(name="name_ar", nullable=false, length=100)
    public String getNameAr() {
        return this.nameAr;
    }
    
    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    
    @Column(name="name_en", nullable=false, length=100)
    public String getNameEn() {
        return this.nameEn;
    }
    
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
//
//@OneToMany(fetch=FetchType.LAZY, mappedBy="area")
//    public Set<DeliveryArea> getDeliveryAreas() {
//        return this.deliveryAreas;
//    }
//    
//    public void setDeliveryAreas(Set<DeliveryArea> deliveryAreas) {
//        this.deliveryAreas = deliveryAreas;
//    }
//
//@OneToMany(fetch=FetchType.LAZY, mappedBy="area")
//    public Set<Order> getOrders() {
//        return this.orders;
//    }
//    
//    public void setOrders(Set<Order> orders) {
//        this.orders = orders;
//    }
//
//@OneToMany(fetch=FetchType.LAZY, mappedBy="area")
//    public Set<Branch> getBranches() {
//        return this.branches;
//    }
//    
//    public void setBranches(Set<Branch> branches) {
//        this.branches = branches;
//    }




}

