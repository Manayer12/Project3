package com.example.project3.Controller;

import com.example.project3.ApiResponse.ApiResponse;
import com.example.project3.Model.Category;
import com.example.project3.Model.Merchant;
import com.example.project3.Model.User;
import com.example.project3.Service.CategoryService;
import com.example.project3.Service.MerchantService;
import com.example.project3.Service.ProductService;
import com.example.project3.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;


    @GetMapping("/get")
    public ResponseEntity getMerchant(){

        return ResponseEntity.status(200).body(merchantService.getAllMerchants());
    }


    @PostMapping("/add")
    public ResponseEntity addMerchant(@RequestBody @Valid Merchant merchant, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body(new ApiResponse("merchant added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@PathVariable Integer id , @RequestBody @Valid Merchant merchant, Errors errors ){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated= merchantService.updateMerchant(id,merchant);
        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("merchant is updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("merchant is not updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable Integer id){
        boolean isdeletd = merchantService.deleteMerchant(id);
        if (isdeletd) {
            return ResponseEntity.status(200).body(new ApiResponse("merchant deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("merchant can not be deleted"));
    }




}
