package com.example.project3.Controller;

import com.example.project3.ApiResponse.ApiResponse;
import com.example.project3.Model.Merchant;
import com.example.project3.Model.MerchantStock;
import com.example.project3.Model.User;
import com.example.project3.Service.MarchentStockService;
import com.example.project3.Service.MerchantService;
import com.example.project3.Service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/mstock")
@AllArgsConstructor
public class MarchentStockController {

    private final MarchentStockService marchentStockService;


    @GetMapping("/get")
    public ResponseEntity getMerchantStock(){

        return ResponseEntity.status(200).body(marchentStockService.getAllMerchantsStock());
    }


    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@RequestBody @Valid MerchantStock merchantStock, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        marchentStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(200).body(new ApiResponse("merchant stock added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchantStock(@PathVariable Integer id , @RequestBody @Valid MerchantStock merchantStock, Errors errors ){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated= marchentStockService.updateMerchantStock(id,merchantStock);
        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("merchant stock is updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("merchant stock is not updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable Integer id){
        boolean isdeletd = marchentStockService.deleteMerchantStock(id);
        if (isdeletd) {
            return ResponseEntity.status(200).body(new ApiResponse("merchant stock deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("merchant stock can not be deleted"));
    }

 


    @PutMapping("/updatestock/{pId}/{mId}/{quantity}")
    public ResponseEntity addtostock(@PathVariable Integer quantity ,@PathVariable Integer mId, @PathVariable Integer pId){
         boolean itcorrect=marchentStockService.updateStock(quantity, mId, pId);
        if(itcorrect){
            return ResponseEntity.status(200).body(new ApiResponse("you added to stock "));
    }
            return ResponseEntity.status(400).body(new ApiResponse("can not add to stock"));
    }

}
