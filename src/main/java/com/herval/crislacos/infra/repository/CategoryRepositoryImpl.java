package com.herval.crislacos.infra.repository;

import com.herval.crislacos.domain.model.Category;
import com.herval.crislacos.domain.repository.CategoryRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CategoryRepositoryImpl implements CategoryRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Category> list() {
        return manager.createQuery("from Category", Category.class).getResultList();
    }

    @Override
    public Category search(Long id) {
        return manager.find(Category.class, id);
    }

    @Override
    public Category save(Category category) {
        return manager.merge(category);
    }

    @Override
    public Category activate(Category category, boolean is_active) {
        category = search(category.getId());
        category.setIs_active(is_active);
        return manager.merge(category);
    }
}
