package ua.kravchenko.youq.entity;


import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;

/**
 * Created by Egor on 29.01.2017.
 */
@Entity
@Audited(targetAuditMode = NOT_AUDITED)
public class Country implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String countryName;

    @Column
    private String code;

    @OneToMany(mappedBy = "country")
    private List<Ds> discountSystems;

    public Country() {
    }

    public Country(String countryName, String code, int id) {
        this.countryName = countryName;
        this.code = code;
        this.id = id;
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

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (id != country.id) return false;
        if (countryName != null ? !countryName.equals(country.countryName) : country.countryName != null) return false;
        return code != null ? code.equals(country.code) : country.code == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return countryName;
       /* return "Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", code='" + code + '\'' +
                '}';*/
    }
}
