package in.wwpy.server.service;

import in.wwpy.server.exception.type.SubCategoryNotFoundException;
import in.wwpy.server.model.SubCategory;

import java.util.List;

public interface SubCategoryService {

    SubCategory findSubCategoryById(Long id) throws SubCategoryNotFoundException;

    SubCategory findSubCategoryByName(String name);

    List<SubCategory> findSubCategoryByCategoryName(String name);

    List<SubCategory> getSubCategories();
}
