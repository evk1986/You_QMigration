package ua.kravchenko.youq.entity;

import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Discount system.
 * base entity.
 * Created by Egor on 29.01.2017.
 */
@Entity
@Audited
@EntityListeners(AuditingEntityListener.class)
@Table(name = "discount_system")
public class Ds implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String title;

    @Column(length = 600)
    private String about;

    @Column
    private String img;

    @Column(length = 25)
    private String colorBg;
    @Column(length = 25)
    private String colorFont;

    @Column(length = 25)
    private String codeFormat;


    @ManyToOne
    @JoinColumn(name = "countryName")
    private Country country;

    @Column(length = 100)
    private String url;

    @Column(length = 25)
    private String telName;

    @Column(length = 25)
    private String telNumber;

    @Column(name = "created_date", updatable = false, nullable = false)
    @CreatedDate
    private long createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private long modifiedDate;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getColorBg() {
        return colorBg;
    }

    public void setColorBg(String colorBg) {
        this.colorBg = colorBg;
    }

    public String getColorFont() {
        return colorFont;
    }

    public void setColorFont(String colorFont) {
        this.colorFont = colorFont;
    }

    public String getCodeFormat() {
        return codeFormat;
    }

    public void setCodeFormat(String codeFormat) {
        this.codeFormat = codeFormat;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ds ds = (Ds) o;

        if (id != null ? !id.equals(ds.id) : ds.id != null) return false;
        if (name != null ? !name.equals(ds.name) : ds.name != null) return false;
        if (title != null ? !title.equals(ds.title) : ds.title != null) return false;
        if (about != null ? !about.equals(ds.about) : ds.about != null) return false;
        if (img != null ? !img.equals(ds.img) : ds.img != null) return false;
        if (colorBg != null ? !colorBg.equals(ds.colorBg) : ds.colorBg != null) return false;
        if (colorFont != null ? !colorFont.equals(ds.colorFont) : ds.colorFont != null) return false;
        if (codeFormat != null ? !codeFormat.equals(ds.codeFormat) : ds.codeFormat != null) return false;
        if (country != null ? !country.equals(ds.country) : ds.country != null) return false;
        if (url != null ? !url.equals(ds.url) : ds.url != null) return false;
        if (telName != null ? !telName.equals(ds.telName) : ds.telName != null) return false;
        return telNumber != null ? telNumber.equals(ds.telNumber) : ds.telNumber == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (about != null ? about.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        result = 31 * result + (colorBg != null ? colorBg.hashCode() : 0);
        result = 31 * result + (colorFont != null ? colorFont.hashCode() : 0);
        result = 31 * result + (codeFormat != null ? codeFormat.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (telName != null ? telName.hashCode() : 0);
        result = 31 * result + (telNumber != null ? telNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DS{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", about='" + about + '\'' +
                ", img='" + img + '\'' +
                ", colorBg='" + colorBg + '\'' +
                ", colorFont='" + colorFont + '\'' +
                ", codeFormat='" + codeFormat + '\'' +
                ", country=" + country +
                ", url='" + url + '\'' +
                ", telName='" + telName + '\'' +
                ", telNumber='" + telNumber + '\'' +
                '}';
    }
}
