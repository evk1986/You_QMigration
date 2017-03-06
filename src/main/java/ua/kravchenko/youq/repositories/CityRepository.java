package ua.kravchenko.youq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kravchenko.youq.entity.City;

/**
 * Created by Егор on 03.03.2017.
 */
public interface CityRepository extends JpaRepository<City, Long> {
}
