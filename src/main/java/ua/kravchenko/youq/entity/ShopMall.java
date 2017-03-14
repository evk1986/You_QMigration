package ua.kravchenko.youq.entity;

import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Егор on 09.03.2017.
 */
@Entity
@Audited
@EntityListeners(AuditingEntityListener.class)
public class ShopMall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "subname")
    private String subName;

    @Column
    private String title;

    @Column(length = 600, name = "license")
    private String about;

    @Column(name = "status")
    private String status;

    @Column(name = "logo")
    private String img;

    @Column(name = "background_image")
    private String backImage;

    @Column(length = 25, name = "color")
    private String colorBg;

    @Column
    private String email;

    @Column(length = 100)
    private String url;

    @Column(length = 70, name = "phone_title")
    private String telName;

    @Column(length = 25, name = "phone")
    private String telNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country")
    private Country country;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "region")
    private Region region;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city")
    private City city;

    @Column(name = "street")
    private String street;

    @Column(name = "additional_adress")
    private String addAdress;

    @Column(name = "post_code")
    private String postCode;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longtitude")
    private String longtitude;

    @Column(name = "created_date", updatable = false, nullable = false)
    @CreatedDate
    private long createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private long modifiedDate;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "workDays")
    private List<WorkDay> workDays = new ArrayList<>(7);

    public List<WorkDay> getWorkDays() {
        return workDays;
    }

    public void setWorkDays(List<WorkDay> workDays) {
        this.workDays = workDays;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBackImage() {
        return backImage;
    }

    public void setBackImage(String backImage) {
        this.backImage = backImage;
    }

    public String getColorBg() {
        return colorBg;
    }

    public void setColorBg(String colorBg) {
        this.colorBg = colorBg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTelName() {
        return telName;
    }

    public void setTelName(String telName) {
        this.telName = telName;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddAdress() {
        return addAdress;
    }

    public void setAddAdress(String addAdress) {
        this.addAdress = addAdress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public long getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(long modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopMall shopMall = (ShopMall) o;

        if (createdDate != shopMall.createdDate) return false;
        if (modifiedDate != shopMall.modifiedDate) return false;
        if (id != null ? !id.equals(shopMall.id) : shopMall.id != null) return false;
        if (name != null ? !name.equals(shopMall.name) : shopMall.name != null) return false;
        if (subName != null ? !subName.equals(shopMall.subName) : shopMall.subName != null) return false;
        if (title != null ? !title.equals(shopMall.title) : shopMall.title != null) return false;
        if (about != null ? !about.equals(shopMall.about) : shopMall.about != null) return false;
        if (status != null ? !status.equals(shopMall.status) : shopMall.status != null) return false;
        if (img != null ? !img.equals(shopMall.img) : shopMall.img != null) return false;
        if (backImage != null ? !backImage.equals(shopMall.backImage) : shopMall.backImage != null) return false;
        if (colorBg != null ? !colorBg.equals(shopMall.colorBg) : shopMall.colorBg != null) return false;
        if (email != null ? !email.equals(shopMall.email) : shopMall.email != null) return false;
        if (url != null ? !url.equals(shopMall.url) : shopMall.url != null) return false;
        if (telName != null ? !telName.equals(shopMall.telName) : shopMall.telName != null) return false;
        if (telNumber != null ? !telNumber.equals(shopMall.telNumber) : shopMall.telNumber != null) return false;
        if (country != null ? !country.equals(shopMall.country) : shopMall.country != null) return false;
        if (region != null ? !region.equals(shopMall.region) : shopMall.region != null) return false;
        if (city != null ? !city.equals(shopMall.city) : shopMall.city != null) return false;
        if (street != null ? !street.equals(shopMall.street) : shopMall.street != null) return false;
        if (addAdress != null ? !addAdress.equals(shopMall.addAdress) : shopMall.addAdress != null) return false;
        if (postCode != null ? !postCode.equals(shopMall.postCode) : shopMall.postCode != null) return false;
        if (latitude != null ? !latitude.equals(shopMall.latitude) : shopMall.latitude != null) return false;
        return longtitude != null ? longtitude.equals(shopMall.longtitude) : shopMall.longtitude == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (subName != null ? subName.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (about != null ? about.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        result = 31 * result + (backImage != null ? backImage.hashCode() : 0);
        result = 31 * result + (colorBg != null ? colorBg.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (telName != null ? telName.hashCode() : 0);
        result = 31 * result + (telNumber != null ? telNumber.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (addAdress != null ? addAdress.hashCode() : 0);
        result = 31 * result + (postCode != null ? postCode.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longtitude != null ? longtitude.hashCode() : 0);
        result = 31 * result + (int) (createdDate ^ (createdDate >>> 32));
        result = 31 * result + (int) (modifiedDate ^ (modifiedDate >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "ShopMall{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subName='" + subName + '\'' +
                ", title='" + title + '\'' +
                ", about='" + about + '\'' +
                ", status='" + status + '\'' +
                ", img='" + img + '\'' +
                ", backImage='" + backImage + '\'' +
                ", colorBg='" + colorBg + '\'' +
                ", email='" + email + '\'' +
                ", url='" + url + '\'' +
                ", telName='" + telName + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", country=" + country +
                ", region=" + region +
                ", city=" + city +
                ", street='" + street + '\'' +
                ", addAdress='" + addAdress + '\'' +
                ", postCode='" + postCode + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longtitude='" + longtitude + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", workDays=" + workDays +
                '}';
    }
}
