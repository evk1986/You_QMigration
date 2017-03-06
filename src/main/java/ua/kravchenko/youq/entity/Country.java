package ua.kravchenko.youq.entity;


import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Egor on 29.01.2017.
 */
@Entity
@Audited/*(targetAuditMode = NOT_AUDITED)*/
@EntityListeners(AuditingEntityListener.class)
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_en")
    private String nameEn;

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "phone_code")
    private String code;

    @Column(name = "iso2")
    private String codeIso2;

    @Column(name = "iso3")
    private String codeIso3;

    @OneToMany(mappedBy = "country", cascade = {CascadeType.ALL})
    private List<Ds> discountSystems;

    @OneToMany(mappedBy = "country", cascade = {CascadeType.ALL})
    private List<Region> regions;

    public Country() {
    }

    public Country(String countryName, String nameEn, String code, int id) {
        this.nameEn = nameEn;
        this.nameRu = countryName;
        this.code = code;
        this.id = id;
    }

    public String getCodeIso2() {
        return codeIso2;
    }

    public void setCodeIso2(String codeIso2) {
        this.codeIso2 = codeIso2;
    }

    public String getCodeIso3() {
        return codeIso3;
    }

    public void setCodeIso3(String codeIso3) {
        this.codeIso3 = codeIso3;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public List<Ds> getDiscountSystems() {
        return discountSystems;
    }

    public void setDiscountSystems(List<Ds> discountSystems) {
        this.discountSystems = discountSystems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String countryName) {
        this.nameRu = countryName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (id != country.id) return false;
        if (nameRu != null ? !nameRu.equals(country.nameRu) : country.nameRu != null) return false;
        return code != null ? code.equals(country.code) : country.code == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameRu != null ? nameRu.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return nameRu;
       /* return "Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", code='" + code + '\'' +
                '}';*/
    }
}
