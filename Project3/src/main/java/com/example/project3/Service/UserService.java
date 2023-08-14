package com.example.project3.Service;

import com.example.project3.Model.Product;
import com.example.project3.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private ProductService productService;
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private MarchentStockService marchentStockService;

    ArrayList<User>users=new ArrayList<>();



    public ArrayList<User> getAllUser(){
        return users;
    }

    public void addUsers(User user){
        users.add(user);

    }

    public boolean updateUser(Integer id,User user){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getId() == id){
                users.set(i,user);
                return true;
            }
        }
        return false;
    }


    public boolean deleteUser(Integer id){
        for (int i=0;i<users.size();i++){
            if(users.get(i).getId()==id){
                users.remove(i);
                return true;
            }
        }
        return false;


    }

    public boolean addtostock(User role){
        if (role.getRole()=="Admin"){
            return true;
        }
        return false;

    }

    public boolean checkID(Integer id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id ){
             return true;}///


        }
        return false;
    }


 public void checkbalance(int price) {
     for (int i = 0; i < users.size(); i++) {
         if (users.get(i).getBalance() > price) {
             users.get(i).setBalance(users.get(i).getBalance() - price);
         }
     }}



    public void addToBalance(int price) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getBalance() > price) {
                users.get(i).setBalance(users.get(i).getBalance() + price);

            }
        }}


    public boolean buyproduct(Integer pId,Integer mId,Integer userId){
    boolean trueproduct=productService.checkPid(pId);
    boolean truemerchant=merchantService.checkMid(mId);
    boolean trueuser=checkID(userId);
    boolean checkstock=marchentStockService.checkstock(pId);
        if(truemerchant && trueproduct && trueuser){
        if(checkstock){
            checkbalance(productService.returnPrice(pId));
           return true;

                  }
        }

        return false;}

    public boolean returnProduct(Integer pId,Integer mId,Integer userId){
        boolean trueproduct=productService.checkPid(pId);
        boolean truemerchant=merchantService.checkMid(mId);
        boolean trueuser=checkID(userId);
        boolean checkstock=marchentStockService.checkstock(pId);
        if(truemerchant && trueproduct && trueuser){
            if(checkstock){
                addToBalance(productService.returnPrice(pId));

                return true;

            } }


        return false;}






}
