package ua.kravchenko.youq.services;

import ua.kravchenko.youq.entity.Region;

import java.util.List;

/**
 * Created by Егор on 03.03.2017.
 */
public interface RegionService {
    List<Region> findAll();

    Region findOneById(Long id);

    void save(Region regionModel);
}
