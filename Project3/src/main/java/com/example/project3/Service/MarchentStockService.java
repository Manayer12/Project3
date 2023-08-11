package com.example.project3.Service;

import com.example.project3.Model.Merchant;
import com.example.project3.Model.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MarchentStockService {

    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();

    public ArrayList<MerchantStock> getAllMerchantsStock() {
        return merchantStocks;
    }

    public void addMerchantStock(MerchantStock merchantStock) {
        merchantStocks.add(merchantStock);

    }

    public boolean updateMerchantStock(Integer id, MerchantStock merchantStock) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId() == id) {
                merchantStocks.set(i, merchantStock);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMerchantStock(Integer id) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId() == id) {
                merchantStocks.remove(i);
                return true;

            }
        }
        return false;

    }
    public void updateStock(Integer quantity) {
        for (int i = 0; i < merchantStocks.size(); i++) {
                merchantStocks.get(i).setStock(merchantStocks.get(i).getStock()+quantity);
            }


        }

    public boolean checkstock(Integer product_id){
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (product_id == merchantStocks.get(i).getProductId() && merchantStocks.get(i).getStock()>0){
                merchantStocks.get(i).setStock(merchantStocks.get(i).getStock()-1);
                return true;
            }

        }return false;

    }
    public boolean returnToStock(Integer product_id){
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (product_id == merchantStocks.get(i).getProductId() && merchantStocks.get(i).getStock()>0){
                merchantStocks.get(i).setStock(merchantStocks.get(i).getStock()+1);
                return true;
            }

        }return false;

    }


}








