package in.wwpy.server.service.impl;

import in.wwpy.server.exception.type.SubCategoryNotFoundException;
import in.wwpy.server.model.SubCategory;
import in.wwpy.server.repository.SubCategoryRepository;
import in.wwpy.server.service.SubCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static in.wwpy.server.constant.SubCategoryConstant.THIS_SUBCATEGORY_DOES_NOT_EXIST;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private SubCategoryRepository subCategoryRepository;


    @Override
    public SubCategory findSubCategoryById(Long id) throws SubCategoryNotFoundException {
        Optional<SubCategory> optionalSubCategory = this.subCategoryRepository.findById(id);
        if (!optionalSubCategory.isPresent()) {
            LOGGER.error(THIS_SUBCATEGORY_DOES_NOT_EXIST);
            throw new SubCategoryNotFoundException(THIS_SUBCATEGORY_DOES_NOT_EXIST);
        }
        return optionalSubCategory.get();
    }

    @Override
    public SubCategory findSubCategoryByName(String name) {
        return this.subCategoryRepository.findSubCategoryByName(name);
    }

    @Override
    public List<SubCategory> findSubCategoryByCategoryName(String name) {
        return this.subCategoryRepository.findSubCategoryByCategoriesName(name);
    }

    @Override
    public List<SubCategory> getSubCategories() {
        return this.subCategoryRepository.findAll();
    }
}
