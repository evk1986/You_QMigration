package ua.kravchenko.youq.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kravchenko.youq.entity.Category;
import ua.kravchenko.youq.entity.City;
import ua.kravchenko.youq.repositories.CategoryRepository;

import java.util.List;

/**
 * Created by Егор on 03.03.2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository repository;
    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Category category) {
        repository.save(category);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public Category findOneById(Long id) {
        return repository.findOne(id);
    }
}
