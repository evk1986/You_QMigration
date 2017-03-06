package ua.kravchenko.youq.services;

import ua.kravchenko.youq.entity.Category;

import java.util.List;

/**
 * Created by Егор on 03.03.2017.
 */
public interface CategoryService {
    List<Category> findAll();

    void save(Category category);

    void delete(Long id);

    Category findOneById(Long id);
}
