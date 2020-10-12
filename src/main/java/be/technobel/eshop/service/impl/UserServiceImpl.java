package be.technobel.eshop.service.impl;

import be.technobel.eshop.config.PasswordEncoderConfig;
import be.technobel.eshop.mapper.BaseMapper;
import be.technobel.eshop.model.dto.UserDto;
import be.technobel.eshop.model.entity.User;
import be.technobel.eshop.model.form.UserForm;
import be.technobel.eshop.repository.UserRepository;
import be.technobel.eshop.service.BaseService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserServiceImpl implements UserDetailsService, BaseService<UserDto, UserForm,Long> {

    private final UserRepository repository;
    private final BaseMapper mapper;
    private final PasswordEncoderConfig encoder;

    public UserServiceImpl(UserRepository repository, BaseMapper mapper, PasswordEncoderConfig encoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.encoder = encoder;
    }

    @Override
    @PreAuthorize("hasAnyAuthority('ADMIN','RESPONSABLE')")
    public List<UserDto> findAll() {

        return repository
                .findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @PreAuthorize("hasAnyAuthority('ADMIN','RESPONSABLE')")
    public UserDto findOne(Long id) {

        return repository
                .findById(id)
                .map(mapper::toDto)
                .orElseThrow(()-> new IllegalArgumentException("User not found"));
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public boolean save(UserForm form) {

        User newUser = mapper.fromFormtoEntity(form);
        newUser.setAccountNonExpired(true)
                .setAccountNonLocked(true)
                .setEnabled(true)
                .setCredentialsNonExpired(true)
                .setPassword(encoder.getPasswordEncoder().encode(newUser.getPassword()));

        User savedUser = repository.save(newUser);
        return repository.existsById(savedUser.getIdUser());
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public boolean delete(Long id) {

        User todelete = repository
                        .findById(id)
                        .orElseThrow(()-> new IllegalArgumentException("User not found"));

        repository.delete(todelete);

        return !repository.existsById(id);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public UserDto update(UserForm form, Long id) {

        User toUpdate = repository
                        .findById(id)
                        .orElseThrow(()-> new IllegalArgumentException("User not found"));

        toUpdate.setPassword(encoder.getPasswordEncoder().encode(form.getPassword()))
                .setUsername(form.getUsername())
                .setRoles(form.getRoles());

        return mapper.toDto(repository.save(toUpdate));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return repository
                .findByUsername(s)
                .orElseThrow(()->new UsernameNotFoundException("The user with the name :"+s+" doesn't exists"));
    }
}
