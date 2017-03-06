package ua.kravchenko.youq.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kravchenko.youq.entity.City;
import ua.kravchenko.youq.repositories.CityRepository;

import java.util.List;

/**
 * Created by Егор on 03.03.2017.
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository repository;

    @Override
    public List<City> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(City cityModel) {
        repository.save(cityModel);
    }

    @Override
    public City findOneById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
