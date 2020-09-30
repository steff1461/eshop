package be.technobel.eshop.service.impl;

import be.technobel.eshop.mapper.BaseMapper;
import be.technobel.eshop.model.dto.CategoryDto;
import be.technobel.eshop.model.entity.Category;
import be.technobel.eshop.model.form.CategoryForm;
import be.technobel.eshop.repository.CategoryRepository;
import be.technobel.eshop.service.BaseService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@PreAuthorize("hasAnyAuthority('USER','ADMIN','RESPONSABLE')")

public class CategoryServiceImpl implements BaseService<CategoryDto, CategoryForm,Long> {

    private final CategoryRepository repository;
    private final BaseMapper mapper;

    public CategoryServiceImpl(CategoryRepository repository, BaseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<CategoryDto> findAll() {


        return repository
                .findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findOne(Long id) {

        return repository
                .findById(id)
                .map(mapper::toDto)
                .orElseThrow(()-> new IllegalArgumentException("Category not found"));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','RESPONSABLE')")
    @Override
    public boolean save(CategoryForm form) {

        Category toSave = mapper.fromFormToEntity(form);
        repository.save(toSave);

        return repository.existsById(toSave.getIdCategory());
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','RESPONSABLE')")
    @Override
    public boolean delete(Long id) {

        Category toDelete = repository.findById(id).orElseThrow(()->new IllegalArgumentException("Category not found"));
        repository.delete(toDelete);

        return !repository.existsById(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','RESPONSABLE')")
    @Override
    public CategoryDto update(CategoryForm form, Long id) {

        Category toUpdate = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Category not found"));
        toUpdate.setName(form.getName());

        return mapper.toDto( repository.save(toUpdate));
    }
}
