package com.example.project3.Service;
import com.example.project3.Model.Category;
import com.example.project3.Model.Merchant;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
@Service
public class MerchantService {
    ArrayList<Merchant> merchants=new ArrayList<>();

    public ArrayList<Merchant> getAllMerchants(){
        return merchants;
    }
    public void addMerchant(Merchant merchant){
        merchants.add(merchant);

    }

    public boolean updateMerchant(Integer id,Merchant merchant){
        for(int i=0;i<merchants.size();i++){
            if(merchants.get(i).getId() == id){
                merchants.set(i,merchant);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMerchant(Integer id){

        for(int i=0;i<merchants.size();i++){
            if(merchants.get(i).getId()==id){
                merchants.remove(i);
                return true;

            }
        }
        return false;

    }

    public boolean checkMid(Integer merchant_id){
        for(int i=0;i<merchants.size();i++){
            if (merchants.get(i).getId() == (merchant_id)){
                return true;
            }

        }
        return false;}











}
