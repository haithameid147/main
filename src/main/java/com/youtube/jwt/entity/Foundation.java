package com.youtube.jwt.entity;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Provider generated by hbm2java                
 * 
{
    "userName":"admin",
    "userPassword":"admin"
}
 */

@Entity
@Table(name = "foundation"
)
public class Foundation implements java.io.Serializable {
      
    private Integer id;
    private String nameAr;
    private String nameEn;
    private String phone;
    private String photo;
    private boolean active ;
    private String description;
    private String advantages;
    @Column(name = "imageDB", length = 10000)
    private byte[] logo ;
    @Column(name = "filenameDB")
    private String filenameDB ;
    private String communication;
    //  private Service service ;

    private User user;
        	@Column(name = "picByte", length = 1000)
	  private byte[] picByte;

    private Service service;
    private City city;
//     private Set<Category> categories = new HashSet<Category>(0);
//     private Set<Branch> branches = new HashSet<Branch>(0);
//     private Set<ProviderUser> providerUsers = new HashSet<ProviderUser>(0);

    public Foundation() {
    }

    public Foundation(String nameAr) {
        this.nameAr = nameAr;
    }

    public Foundation(Integer id, String nameAr, String nameEn, String phone, String photo, String description,
            String advantages, String communication) {
        super();
        this.id = id;
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.phone = phone;
        this.photo = photo;
        this.description = description;
        this.advantages = advantages;
        this.communication = communication;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    @Column(name = "name_ar", nullable = false, length = 250)
    public String getNameAr() {
        return this.nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }
     
    @Column(name = "name_en", length = 250)
    public String getNameEn() {
        return this.nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    @Column(name = "phone", nullable = false, length = 15)
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "photo")
    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Column(name = "description", nullable = false , length = 750)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "advantages", nullable = false , length = 750)
    public String getAdvantages() {
        return advantages;
    }

    public void setAdvantages(String advantages) {
        this.advantages = advantages;
    }

    @Column(name = "communication", nullable = false , length = 250)
    public String getCommunication() {
        return communication;
    }
      
    public void setCommunication(String communication) {
        this.communication = communication;
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
    @JoinColumn(name = "User_id", nullable = false)
        
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "city_id", nullable = false)
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public String getFilenameDB() {
		return filenameDB;
	}

	public void setFilenameDB(String filenameDB) {
		this.filenameDB = filenameDB;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

    




}

