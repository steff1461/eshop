package be.technobel.eshop.controller;

import be.technobel.eshop.model.dto.OrderDto;
import be.technobel.eshop.model.dto.OrderDto;
import be.technobel.eshop.model.form.OrderForm;
import be.technobel.eshop.model.form.OrderForm;
import be.technobel.eshop.service.impl.OrderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/orders")
public class OrderController implements BaseController<OrderForm, OrderDto,Long> {

    private final OrderServiceImpl service;

    public OrderController(OrderServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<OrderDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/{id}")
    @Override
    public ResponseEntity<OrderDto> findOne(@PathVariable("id") Long id) {

        return ResponseEntity.ok(service.findOne(id));
    }

    @PostMapping
    @Override
    public ResponseEntity<Boolean> create(@RequestBody OrderForm form) throws Exception {


        return ResponseEntity.ok(service.save(form));
    }

    @DeleteMapping(path = "/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {

        return ResponseEntity.ok(service.delete(id));
    }

    @PutMapping(path = "/{id}")
    @Override
    public ResponseEntity<OrderDto> update(@RequestBody OrderForm form, @PathVariable("id") Long id) {

        return ResponseEntity.ok(service.update(form, id));
    }
}
