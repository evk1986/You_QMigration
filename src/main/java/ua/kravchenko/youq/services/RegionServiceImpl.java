package ua.kravchenko.youq.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kravchenko.youq.entity.Region;
import ua.kravchenko.youq.repositories.RegionRepository;

import java.util.List;

/**
 * Created by Егор on 03.03.2017.
 */
@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    RegionRepository repository;

    @Override
    public List<Region> findAll() {
        return repository.findAll();
    }

    @Override
    public Region findOneById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void save(Region regionModel) {
        repository.save(regionModel);
    }
}
