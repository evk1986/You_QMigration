package ua.kravchenko.youq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kravchenko.youq.entity.Country;

/**
 * Created by Egor on 29.01.2017.
 */
public interface CountryRepository extends JpaRepository<Country, Integer> {
    Country findByNameRu(String nameRu);
}
