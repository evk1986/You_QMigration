package ua.kravchenko.youq.services;

import ua.kravchenko.youq.entity.City;

import java.util.List;

/**
 * Created by Егор on 03.03.2017.
 */
public interface CityService {
    List<City> findAll();

    void save(City cityModel);

    City findOneById(Long id);

    void delete(Long id);
}
