package in.wwpy.server.repository;

import in.wwpy.server.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "subcategory-resource")
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    SubCategory findSubCategoryByName(String name);
    List<SubCategory> findSubCategoryByCategoriesName(String name);
}
