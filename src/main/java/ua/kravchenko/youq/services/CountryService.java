package ua.kravchenko.youq.services;

import ua.kravchenko.youq.entity.Country;

import java.util.List;

/**
 * Created by Egor on 29.01.2017.
 */
public interface CountryService{

    Country findOne(Integer id);
    Country save(Country country);


    List<Country> findAll();

    Country findByName(String countryName);

    void delete(int id);
}
