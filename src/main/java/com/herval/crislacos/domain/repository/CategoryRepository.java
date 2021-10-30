package com.herval.crislacos.domain.repository;

import com.herval.crislacos.domain.model.Category;

import java.util.List;

public interface CategoryRepository {

    List<Category> list();
    Category search(Long id);
    Category save(Category category);
    Category activate(Category category);
}
