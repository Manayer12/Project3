package com.example.project3.Service;

import com.example.project3.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
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
             return true;}


        }
        return false;
    }


 public boolean checkbalance(int price) {
     for (int i = 0; i < users.size(); i++) {
         if (users.get(i).getBalance() > price) {
             users.get(i).setBalance(users.get(i).getBalance() - price);
             return true;
         }
     }
 return  false;}

    public boolean addToBalance(int price) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getBalance() > price) {
                users.get(i).setBalance(users.get(i).getBalance() + price);
                return true;
            }
        }
        return  false;}










}
