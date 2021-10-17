package in.wwpy.server.controller;

import in.wwpy.server.exception.type.SubCategoryNotFoundException;
import in.wwpy.server.model.SubCategory;
import in.wwpy.server.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = {"/subcategory"})
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;


    @GetMapping("/find/{id}")
    public ResponseEntity<SubCategory> findSubCategoryById(
            @PathVariable("id") Long id
    ) throws SubCategoryNotFoundException {
        SubCategory subCategory = this.subCategoryService.findSubCategoryById(id);
        return new ResponseEntity<>(subCategory, OK);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<SubCategory> findSubCategoryByName(
            @PathVariable("name") String name
    ) {
        SubCategory subCategory = this.subCategoryService.findSubCategoryByName(name);
        return new ResponseEntity<>(subCategory, OK);
    }

    @GetMapping("/find/category/{name}")
    public ResponseEntity<List<SubCategory>> findSubCategoryByCategoryName(
            @PathVariable("name") String name
    ) {
        List<SubCategory> subCategories = this.subCategoryService.findSubCategoryByCategoryName(name);
        return new ResponseEntity<>(subCategories, OK);
    }
}
