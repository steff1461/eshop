package be.technobel.eshop.controller;

import be.technobel.eshop.model.dto.ProductDto;
import be.technobel.eshop.model.form.ProductForm;
import be.technobel.eshop.service.impl.ProductServiceImpl;
import lombok.var;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/products")

public class ProductController implements  BaseController<ProductForm, ProductDto,Long> {

    private final ProductServiceImpl service;

    public ProductController(ProductServiceImpl productService) {
        this.service = productService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ProductDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/{id}")
    @Override
    public ResponseEntity<ProductDto> findOne(@PathVariable("id") Long id) {

        return ResponseEntity.ok(service.findOne(id));
    }

    @PostMapping
    @Override
    public ResponseEntity<Boolean> create(@RequestBody ProductForm form) throws Exception {


        return ResponseEntity.ok(service.save(form));
    }

    @DeleteMapping(path = "/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {

        return ResponseEntity.ok(service.delete(id));
    }

    @PutMapping(path = "/{id}")
    @Override
    public ResponseEntity<ProductDto> update(@RequestBody ProductForm form, @PathVariable("id") Long id) {

        return ResponseEntity.ok(service.update(form, id));
    }


    @GetMapping(
            value = "/get-img",
            produces = MediaType.IMAGE_PNG_VALUE
    )
    public ResponseEntity<InputStreamResource> getImage() throws IOException {

        var imgFile = new ClassPathResource("image/westpole_log.png");

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(new InputStreamResource(imgFile.getInputStream()));
    }
}
