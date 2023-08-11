package com.example.project3.Controller;

import com.example.project3.ApiResponse.ApiResponse;
import com.example.project3.Model.Category;
import com.example.project3.Model.Product;
import com.example.project3.Service.CategoryService;
import com.example.project3.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

   private final CategoryService categoryService;

private final ProductService productService;
   @GetMapping("/get")
   public ResponseEntity getCategory(){

      return ResponseEntity.status(200).body(categoryService.getAllCategory());
   }


   @PostMapping("/add")
   public ResponseEntity addCategory(@RequestBody @Valid Category category, Errors errors){
      if (errors.hasErrors()){
         String message=errors.getFieldError().getDefaultMessage();
         return ResponseEntity.status(400).body(message);
      }
      categoryService.addCategory(category);
      return ResponseEntity.status(200).body(new ApiResponse("category added"));
   }


   @PutMapping("/update/{id}")
   public ResponseEntity updateCategory(@PathVariable Integer id ,@RequestBody @Valid Category category,Errors errors ){
      if (errors.hasErrors()){
         String message=errors.getFieldError().getDefaultMessage();
         return ResponseEntity.status(400).body(message);
      }
      boolean isUpdated=categoryService.updateCategory(id,category);
      if (isUpdated){
         return ResponseEntity.status(200).body(new ApiResponse("category is updated"));
      }
      return ResponseEntity.status(400).body(new ApiResponse("category is not updated"));
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity deleteCategory(@PathVariable Integer id){
      boolean isTrue= productService.returnId(id);
      boolean isdeletd = categoryService.deleteCategory(id);
     // It will delete a product along with its category
      if (isdeletd) {
         if(isTrue){
        productService.deleteCategoryByID(id);
         return ResponseEntity.status(200).body(new ApiResponse("category deleted"));
      }}

      return ResponseEntity.status(400).body(new ApiResponse("category can not be deleted"));
   }

}




