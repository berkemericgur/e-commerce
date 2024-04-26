package com.bmg.ecommercedemo.controller;

import com.bmg.ecommercedemo.business.abstracts.ProductService;
import com.bmg.ecommercedemo.business.dtos.request.productRequests.CreateProductRequest;
import com.bmg.ecommercedemo.business.dtos.request.productRequests.UpdateProductRequest;
import com.bmg.ecommercedemo.business.dtos.response.productResponses.GetAllProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping(value = "/getAll")
    @Operation(summary = "Get All")
    public ResponseEntity<List<GetAllProductResponse>> getAll() {

        return ResponseEntity.ok(this.productService.getAll());
    }

    @GetMapping(value = "/getByName")
    @Operation(summary = "Get w Name")
    public ResponseEntity<List<GetAllProductResponse>> getByName(@RequestParam String name) {

        return ResponseEntity.ok(this.productService.findByName(name));
    }

    @GetMapping(value = "/getByCost/{cost}")
    @Operation(summary = "Get w Cost")
    public ResponseEntity<List<GetAllProductResponse>> getByCost(@PathVariable int cost) {

        return ResponseEntity.ok(this.productService.findByCost(cost));
    }

    @PostMapping(value = "/add")
    @Operation(summary = "Add")
    public void add(@RequestBody CreateProductRequest request) {

        this.productService.addProduct(request);
    }

    @PutMapping(value = "/update")
    @Operation(summary = "Update")
    public void update(@RequestBody UpdateProductRequest request) {

        this.productService.updateProduct(request);
    }

    @DeleteMapping(value = "/delete/{id}")
    @Operation(summary = "Delete")
    public void delete(@PathVariable long id) {

        try {
            this.productService.deleteProduct(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
