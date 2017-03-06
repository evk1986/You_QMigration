package ua.kravchenko.youq.entity;

import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Egor on 03.03.2017.
 */
@Entity
@Audited
@EntityListeners(AuditingEntityListener.class)
public class Region implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "name_en")
    private String nameEn;

    @Column(name = "created_date", updatable = false, nullable = false)
    @CreatedDate
    private long createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private long modifiedDate;

    @OneToMany(mappedBy = "region", cascade = {CascadeType.ALL})
    private List<City> cities;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "countryName")
    private Country country;

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
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

    public List<City> getCities() {
        return cities;
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

        Region region = (Region) o;

        if (id != region.id) return false;
        if (createdDate != region.createdDate) return false;
        if (modifiedDate != region.modifiedDate) return false;
        if (nameRu != null ? !nameRu.equals(region.nameRu) : region.nameRu != null) return false;
        if (nameEn != null ? !nameEn.equals(region.nameEn) : region.nameEn != null) return false;
        if (cities != null ? !cities.equals(region.cities) : region.cities != null) return false;
        return country != null ? country.equals(region.country) : region.country == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nameRu != null ? nameRu.hashCode() : 0);
        result = 31 * result + (nameEn != null ? nameEn.hashCode() : 0);
        result = 31 * result + (int) (createdDate ^ (createdDate >>> 32));
        result = 31 * result + (int) (modifiedDate ^ (modifiedDate >>> 32));
        result = 31 * result + (cities != null ? cities.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", nameRu='" + nameRu + '\'' +
                ", nameEn='" + nameEn + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", cities=" + cities +
                ", country=" + country +
                '}';
    }


}
