package in.wwpy.server.controller;

import in.wwpy.server.exception.type.CategoryNotFoundException;
import in.wwpy.server.model.Category;
import in.wwpy.server.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = {"/category"})
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/find/all")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = this.categoryService.getCategories();
        return new ResponseEntity<>(categories, OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Category> findCategoryById(
            @PathVariable("id") Long id
    ) throws CategoryNotFoundException {
        Category category = this.categoryService.findCategoryById(id);
        return new ResponseEntity<>(category, OK);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<Category> findCategoryByName(
            @PathVariable("name") String name
    ) {
        Category category = this.categoryService.findCategoryByName(name);
        return new ResponseEntity<>(category, OK);
    }

    @GetMapping("/find/subcategory/{name}")
    public ResponseEntity<List<Category>> findCategoryBySubCategoryName(
            @PathVariable("name") String name
    ) {
        List<Category> categories = this.categoryService.findCategoryBySubCategoryName(name);
        return new ResponseEntity<>(categories, OK);
    }
}
