package ua.kravchenko.youq.entity;

import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Егор on 17.03.2017.
 */
@Entity
@Audited
@EntityListeners(AuditingEntityListener.class)
public class ShopNetwork {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String status;

    @Column
    private String color;

    @Column
    private String name;

    @Column
    private String subName;

    @Column
    private String url;

    @Column
    private String email;

    @Column
    private String phoneTitle;

    @Column
    private String phone;

    @Column
    private String backImage;

    @Column
    private String logo;

    @Column
    @CreatedDate
    private Date created;


    @Column
    @LastModifiedDate
    private Date modified;

    @JoinColumn(name = "country")
    @ManyToOne(fetch = FetchType.EAGER)
    private Country country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneTitle() {
        return phoneTitle;
    }

    public void setPhoneTitle(String phoneTitle) {
        this.phoneTitle = phoneTitle;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBackImage() {
        return backImage;
    }

    public void setBackImage(String backImage) {
        this.backImage = backImage;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopNetwork that = (ShopNetwork) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (subName != null ? !subName.equals(that.subName) : that.subName != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phoneTitle != null ? !phoneTitle.equals(that.phoneTitle) : that.phoneTitle != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (backImage != null ? !backImage.equals(that.backImage) : that.backImage != null) return false;
        if (logo != null ? !logo.equals(that.logo) : that.logo != null) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (modified != null ? !modified.equals(that.modified) : that.modified != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (subName != null ? subName.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneTitle != null ? phoneTitle.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (backImage != null ? backImage.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (modified != null ? modified.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}
