package com.example.crawlerapi.service;

import com.example.crawlerapi.model.NuuvemShopProductModel;

import java.util.List;

public interface NuuvemShopProductIpl {
    NuuvemShopProductModel addNuuvemShopProduct(NuuvemShopProductModel NuuvemShop);
    List<NuuvemShopProductModel> getNuuvemShopProductAll();
    NuuvemShopProductModel getNuuvemShopProductById(long productId);
    void deleteNuuvemShopProductById(long productId);
    void updateNuuvemShopProduct(NuuvemShopProductModel nuuvemShop);
}
