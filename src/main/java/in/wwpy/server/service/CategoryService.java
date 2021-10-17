package in.wwpy.server.service;

import in.wwpy.server.exception.type.CategoryNotFoundException;
import in.wwpy.server.model.Category;

import java.util.List;

public interface CategoryService {

    Category findCategoryById(Long id) throws CategoryNotFoundException;

    Category findCategoryByName(String name);

    List<Category> findCategoryBySubCategoryName(String name);

    List<Category> getCategories();
}
