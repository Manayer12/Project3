package com.example.project3.Service;

import com.example.project3.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    ArrayList<Product>products=new ArrayList<>();
    public ArrayList<Product> getAllProducts(){
        return products;
    }
    public void addProducts(Product product){
        products.add(product);

    }


    public boolean updateProduct(Integer id,Product product){
        for(int i=0;i<products.size();i++){
            if(products.get(i).getId() == id){
                products.set(i,product);
                return true;
            }
        }
    return false;
    }

    public boolean deleteProduct(Integer id){

        for(int i=0;i<products.size();i++){
            if(products.get(i).getId()==id){
                products.remove(i);
                return true;

            }
        }
        return false;

        }

    public boolean checkPid(Integer product_id){
        for(int i=0;i<products.size();i++){
            if (products.get(i).getId() == (product_id)){
                return true;
            }

        }
        return false;}


    public int returnPrice(Integer product_id){
        for(int i=0;i<products.size();i++){
            if (products.get(i).getId() == (product_id)) {
                return products.get(i).getPrice();
            }}

    return 0;}

    public boolean returnId(Integer category_id){
        for(int i=0;i<products.size();i++){
            if (products.get(i).getCategoryId() == (category_id)) {
                return true;
            }}

        return false;}

    public boolean deleteCategoryByID(Integer category_id){

        for(int i=0;i<products.size();i++){
            if(products.get(i).getCategoryId()==category_id){
                products.remove(i);
                return true;

            }
        }
        return false;

    }









}


















