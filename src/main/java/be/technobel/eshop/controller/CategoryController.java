package be.technobel.eshop.controller;

import be.technobel.eshop.model.dto.CategoryDto;
import be.technobel.eshop.model.form.CategoryForm;
import be.technobel.eshop.service.impl.CategoryServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController implements BaseController<CategoryForm, CategoryDto, Long>{

    private final CategoryServiceImpl service;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.service = categoryService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<CategoryDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/{id}")
    @Override
    public ResponseEntity<CategoryDto> findOne(@PathVariable("id") Long id) {

        return ResponseEntity.ok(service.findOne(id));
    }

    @PostMapping
    @Override
    public ResponseEntity<Boolean> create(@RequestBody CategoryForm form) throws Exception {


        return ResponseEntity.ok(service.save(form));
    }

    @DeleteMapping(path = "/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {

        return ResponseEntity.ok(service.delete(id));
    }

    @PutMapping(path = "/{id}")
    @Override
    public ResponseEntity<CategoryDto> update(@RequestBody CategoryForm form, @PathVariable("id") Long id) {

        return ResponseEntity.ok(service.update(form, id));
    }
}
