package ua.kravchenko.youq.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kravchenko.youq.entity.Country;
import ua.kravchenko.youq.repositories.CountryRepository;

import java.util.List;

/**
 * Created by Egor on 29.01.2017.
 */
@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    CountryRepository repository;

    /**
     * find country by Id
     *
     * @param id
     * @return Country
     */
    @Override
    public Country findOne(Integer id) {
        return repository.findOne(id);
    }

    /**
     * Saves the country to db
     *
     * @param country
     * @return Country
     */
    @Override
    public Country save(Country country) {
        return repository.save(country);
    }

    @Override
    public List<Country> findAll() {
        return repository.findAll();
    }

    @Override
    public Country findByName(String countryName) {
        return repository.findByCountryName(countryName);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}
