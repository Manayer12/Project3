package com.example.project3.Controller;
import com.example.project3.ApiResponse.ApiResponse;
import com.example.project3.Model.Product;
import com.example.project3.Service.CategoryService;
import com.example.project3.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/get")
    public ResponseEntity getproduct(){

        return ResponseEntity.status(200).body(productService.getAllProducts());
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody @Valid Product product, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        productService.addProducts(product);
        return ResponseEntity.status(200).body(new ApiResponse("Product added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id ,@RequestBody @Valid Product product,Errors errors ){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated=productService.updateProduct(id,product);
        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("product is updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("product is not updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id){
        boolean isdeletd = productService.deleteProduct(id);
        if (isdeletd) {
            return ResponseEntity.status(200).body(new ApiResponse("category deleted"));
        }

        return ResponseEntity.status(400).body(new ApiResponse("category can not be deleted"));
    }




    }







