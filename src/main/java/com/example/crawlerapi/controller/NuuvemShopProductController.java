package com.example.crawlerapi.controller;

import com.example.crawlerapi.crawler.NuuvemShopProductCrawler;
import com.example.crawlerapi.model.NuuvemShopProductModel;
import com.example.crawlerapi.service.NuuvemShopProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/product")
public class NuuvemShopProductController {

    @Autowired
    private NuuvemShopProductService nuuvemShopProductService;

    private NuuvemShopProductCrawler nuuvemShopProductCrawler = new NuuvemShopProductCrawler();

    @GetMapping("/run-crawler")
    public ResponseEntity<List<NuuvemShopProductModel>> runCrawlerNuuvemShopProduct() {
        List<NuuvemShopProductModel> listShopProduct = nuuvemShopProductCrawler.getShopCollection();
        for (NuuvemShopProductModel product : listShopProduct) {
            NuuvemShopProductModel crawlerNuuvemShopProductModel = new NuuvemShopProductModel(
                    product.getProductName(),
                    product.getProductLink(),
                    product.getProductPht(),
                    product.getProductPage(),
                    product.getProductPrice()
            );
            nuuvemShopProductService.addNuuvemShopProduct(crawlerNuuvemShopProductModel);
        }
        return ResponseEntity.ok().body(nuuvemShopProductService.getNuuvemShopProductAll());
    }

    @PostMapping("/add")
    public ResponseEntity addNuuvemShopProduct(@RequestBody @Valid NuuvemShopProductModel nuuvemShopProductModel) {
        nuuvemShopProductService.addNuuvemShopProduct(nuuvemShopProductModel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<NuuvemShopProductModel>> getNuuvemShopAllProducts() {
        return ResponseEntity.ok().body(nuuvemShopProductService.getNuuvemShopProductAll());
    }

    @GetMapping("/get-by-id/{productId}")
    public ResponseEntity<NuuvemShopProductModel> getNuuvemShopProductById(@PathVariable long productId) {
        NuuvemShopProductModel product = nuuvemShopProductService.getNuuvemShopProductById(productId);
        if (product != null) {
            return ResponseEntity.ok().body(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity deleteNuuvemShopProductById(@PathVariable long productId) {
        nuuvemShopProductService.deleteNuuvemShopProductById(productId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity updateNuuvemShopProductIdById(@PathVariable long productId, @RequestBody @Valid NuuvemShopProductModel updatedShop) {
        NuuvemShopProductModel product = nuuvemShopProductService.getNuuvemShopProductById(productId);
        if (product != null) {
            product.setProductName(updatedShop.getProductName());
            product.setProductLink(updatedShop.getProductLink());
            product.setProductPht(updatedShop.getProductPht());
            product.setProductPage(updatedShop.getProductPage());
            product.setProductPrice(updatedShop.getProductPrice());

            nuuvemShopProductService.updateNuuvemShopProduct(product);

            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/render-all-products-default-template")
    public ResponseEntity<String> renderNuuvemShopAllProductsDefaultTemplate() throws IOException {
        Resource resource = new ClassPathResource("static/nuuvem-shop-all-products-default-template.html");

        if (resource.exists()) {
            Path filePath = resource.getFile().toPath();
            String html = new String(Files.readAllBytes(filePath), StandardCharsets.UTF_8);

            return ResponseEntity.ok()
                    .contentType(MediaType.TEXT_HTML)
                    .body(html);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}