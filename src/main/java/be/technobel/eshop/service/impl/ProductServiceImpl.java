package be.technobel.eshop.service.impl;

import be.technobel.eshop.mapper.BaseMapper;
import be.technobel.eshop.model.dto.ProductDto;
import be.technobel.eshop.model.entity.Category;
import be.technobel.eshop.model.entity.Product;
import be.technobel.eshop.model.form.ProductForm;
import be.technobel.eshop.repository.CategoryRepository;
import be.technobel.eshop.repository.ProductRepository;
import be.technobel.eshop.service.BaseService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@PreAuthorize("hasAnyAuthority('ADMIN','USER','RESPONSABLE')")
@Service
public class ProductServiceImpl implements BaseService<ProductDto, ProductForm, Long> {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;
    private final BaseMapper mapper;

    public ProductServiceImpl(ProductRepository repository, CategoryRepository categoryRepository, BaseMapper mapper) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductDto> findAll() {

        return repository
                .findAll()
                .stream()
                .map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto findOne(Long id) {

        return repository
                .findById(id)
                .map(mapper::toDto)
                .orElseThrow(()->new IllegalArgumentException("Product not find"));
    }

    @Override
    @PreAuthorize("hasAnyAuthority('ADMIN','RESPONSABLE')")
    public boolean save(ProductForm form) {

        Product product = mapper.fromFormToEntity(form);
        Category category = categoryRepository.findById(form.getCategoryId()).orElseThrow(()-> new IllegalArgumentException("Category not found"));
        product.setCategory(category);

        repository.save(product);
        return repository.existsById(product.getIdProduct());
    }

    @Override
    @PreAuthorize("hasAnyAuthority('ADMIN','RESPONSABLE')")
    public boolean delete(Long id) {

        Product product = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Product not found"));
        repository.delete(product);
        return !repository.existsById(id);
    }

    @Override
    @PreAuthorize("hasAnyAuthority('ADMIN','RESPONSABLE')")
    public ProductDto update(ProductForm form, Long id) {

        ProductDto dto;
        if (repository.existsById(id)) {
            Product product = mapper.fromFormToEntity(form);
            product.setIdProduct(id);
           dto = mapper.toDto(repository.save(product));
        }

        else throw new IllegalArgumentException("Product not found");

        return dto;
    }
}
