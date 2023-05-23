package com.example.crawlerapi.service;

import com.example.crawlerapi.model.NuuvemShopProductModel;
import com.example.crawlerapi.repository.NuuvemShopProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NuuvemShopProductService implements NuuvemShopProductIpl {

    @Autowired
    public NuuvemShopProductRepository nuuvemShopProductRepository;

    @Override
    public NuuvemShopProductModel addNuuvemShopProduct(NuuvemShopProductModel product) {
        return nuuvemShopProductRepository.save(product);
    }

    @Override
    public List<NuuvemShopProductModel> getNuuvemShopProductAll() {
        return nuuvemShopProductRepository.findAll();
    }

    @Override
    public NuuvemShopProductModel getNuuvemShopProductById(long productId) {
        return nuuvemShopProductRepository.findById(productId).orElse(null);
    }

    @Override
    public void deleteNuuvemShopProductById(long productId) {
        nuuvemShopProductRepository.deleteById(productId);
    }

    @Override
    public void updateNuuvemShopProduct(NuuvemShopProductModel nuuvemShop) {
        nuuvemShopProductRepository.save(nuuvemShop);
    }

}