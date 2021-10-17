package in.wwpy.server.repository;

import in.wwpy.server.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(path = "category-resource")
public interface CategoryRepository  extends JpaRepository<Category, Long> {
    Category findCategoryByName(String name);
    List<Category> findCategoryBySubCategoriesName(String name);
}
