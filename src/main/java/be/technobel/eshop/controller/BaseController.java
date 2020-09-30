package be.technobel.eshop.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BaseController<TFORM, DTO, TID> {

    ResponseEntity<List<DTO>> findAll();

    ResponseEntity<DTO> findOne(TID id);

    ResponseEntity<Boolean> create(TFORM form) throws Exception;

    ResponseEntity<Boolean> delete(TID id);

    ResponseEntity<DTO> update(TFORM form, TID id);
}
