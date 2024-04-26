package com.bmg.ecommercedemo.business.concretes;

import com.bmg.ecommercedemo.business.abstracts.ProductService;
import com.bmg.ecommercedemo.business.dtos.request.productRequests.CreateProductRequest;
import com.bmg.ecommercedemo.business.dtos.request.productRequests.UpdateProductRequest;
import com.bmg.ecommercedemo.business.dtos.response.productResponses.GetAllProductResponse;
import com.bmg.ecommercedemo.business.mappers.ModelMapperService;
import com.bmg.ecommercedemo.dataaccess.abstracts.ProductDao;
import com.bmg.ecommercedemo.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ModelMapperService modelMapperService;
    private ProductDao productDao;

    @Override
    public List<GetAllProductResponse> getAll() {

        List<Product> products = this.productDao.findAll();

        List<GetAllProductResponse> getAllProductResponses = products.stream()
                .map(product -> this.modelMapperService.forResponse()
                        .map(product, GetAllProductResponse.class))
                .collect(Collectors.toList());

        return getAllProductResponses;
    }

    @Override
    public List<GetAllProductResponse> findByName(String name) {

        List<Product> products = this.productDao.findByName(name);

        List<GetAllProductResponse> getAllProductResponses = products.stream()
                .map(product -> this.modelMapperService.forResponse()
                        .map(product, GetAllProductResponse.class))
                .collect(Collectors.toList());

        return getAllProductResponses;
    }

    @Override
    public List<GetAllProductResponse> findByCost(int cost) {

        List<Product> products = this.productDao.findByCost(cost);

        List<GetAllProductResponse> getAllProductResponses = products.stream()
                .map(product -> this.modelMapperService.forResponse()
                        .map(product, GetAllProductResponse.class))
                .collect(Collectors.toList());

        return getAllProductResponses;
    }

    @Override
    public List<GetAllProductResponse> getProductById(long id) {

        List<Product> products = this.productDao.getProductById(id);

        List<GetAllProductResponse> getAllProductResponses = products.stream()
                .map(product -> this.modelMapperService.forResponse()
                        .map(product, GetAllProductResponse.class))
                .collect(Collectors.toList());

        return getAllProductResponses;
    }

    @Override
    public void addProduct(CreateProductRequest createProductRequest) {

        Product product = this.modelMapperService.forRequest()
                .map(createProductRequest, Product.class);

        this.productDao.save(product);
    }

    @Override
    public void updateProduct(UpdateProductRequest updateProductRequest){

        Product product = this.modelMapperService.forRequest()
                .map(updateProductRequest, Product.class);

        this.productDao.save(product);
    }

    @Override
    public void deleteProduct(long id) throws Exception {

        Optional<Product> product = this.productDao.findById(id);

        if (product == null) {
            throw new Exception("Not found with id: " + id);
        }
        this.productDao.deleteById(id);
    }
}
