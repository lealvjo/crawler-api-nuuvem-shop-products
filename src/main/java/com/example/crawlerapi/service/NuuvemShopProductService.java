package com.example.crawlerapi.service;

import com.example.crawlerapi.model.NuuvemShopProductModel;
import com.example.crawlerapi.repository.NuuvemShopProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.text.similarity.FuzzyScore;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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


    @Override
    public List<NuuvemShopProductModel> getNuuvemShopProductsByName(String productName) {
        List<NuuvemShopProductModel> newFuzzyProductsList = new ArrayList<>();
        List<NuuvemShopProductModel> productListAll = nuuvemShopProductRepository.findAll();
        FuzzyScore fuzzyScore = new FuzzyScore(Locale.getDefault());

        for (NuuvemShopProductModel product : productListAll) {
            int similarity = fuzzyScore.fuzzyScore(productName, product.getProductName());
            double similarityPercentage = (double) similarity / Math.max(productName.length(), product.getProductName().length());
            if (similarityPercentage >= 0.8) {
                newFuzzyProductsList.add(product);
            }
        }

        return newFuzzyProductsList;
    }

}