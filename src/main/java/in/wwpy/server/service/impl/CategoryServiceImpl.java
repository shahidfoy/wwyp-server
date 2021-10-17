package in.wwpy.server.service.impl;

import in.wwpy.server.exception.type.CategoryNotFoundException;
import in.wwpy.server.model.Category;
import in.wwpy.server.repository.CategoryRepository;
import in.wwpy.server.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static in.wwpy.server.constant.CategoryConstant.THIS_CATEGORY_DOES_NOT_EXIST;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Category findCategoryById(Long id) throws CategoryNotFoundException {
        Optional<Category> optionalCategory = this.categoryRepository.findById(id);
        if (!optionalCategory.isPresent()) {
            LOGGER.error(THIS_CATEGORY_DOES_NOT_EXIST);
            throw new CategoryNotFoundException(THIS_CATEGORY_DOES_NOT_EXIST);
        }
        return optionalCategory.get();
    }

    @Override
    public Category findCategoryByName(String name) {
        return this.categoryRepository.findCategoryByName(name);
    }

    @Override
    public List<Category> findCategoryBySubCategoryName(String name) {
        return this.categoryRepository.findCategoryBySubCategoriesName(name);
    }

    @Override
    public List<Category> getCategories() {
        return this.categoryRepository.findAll();
    }
}
