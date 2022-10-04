package com.youtube.jwt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="admin_user"
   
    , uniqueConstraints = @UniqueConstraint(columnNames="username") 
)
public class AdminUser {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
     private Integer id;
	
	//@Column(name = "username")
     private String username;
	//@Column(name = "password")

     private String password;
	//@Column(name = "active")

     private byte active;

    public AdminUser() {
    }

    public AdminUser(String username, String password, byte active) {
       this.username = username;
       this.password = password;
       this.active = active;
    }
   
    
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

    
    @Column(name="username", unique=true, nullable=false, length=45)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="password", nullable=false, length=45)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="active", nullable=false)
    public byte getActive() {
        return this.active;
    }
    
    public void setActive(byte active) {
        this.active = active;
    }




}


