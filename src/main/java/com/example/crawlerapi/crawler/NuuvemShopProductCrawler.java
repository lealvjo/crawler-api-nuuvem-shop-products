package com.example.crawlerapi.crawler;

import com.example.crawlerapi.model.NuuvemShopProductModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class NuuvemShopProductCrawler {
    private static final Logger logger = Logger.getLogger(NuuvemShopProductCrawler.class.getName());
    private Document web;
    private List<NuuvemShopProductModel> listShopProduct = new ArrayList<>();

    public NuuvemShopProductCrawler() {
        try {
            web = Jsoup.connect("https://www.nuuvem.com/promo/nintendo?utm_source=Nintendo&utm_medium=landing_page")
                    .get();
            logger.info("Collecting promotions from https://www.nuuvem.com/promo");
        } catch (IOException e) {
            logger.info("Failed to crawl: " + e.getMessage());
            addDefaultShopProduct();
        }
    }

    public List<NuuvemShopProductModel> getShopProductsCollection() {
        try {
            getAttributeProduct();
            logger.info("Successfully collected data");
        } catch (Exception e) {
            logger.info("Failed to crawl: " + e.getMessage());
            addDefaultShopProduct();
        }

        return listShopProduct;
    }

    private void addDefaultShopProduct() {
        listShopProduct.add(new NuuvemShopProductModel(
                "The Legend of Zelda - Breath of the Wild",
                "https://www.nintendo.com/pt_BR/games/detail/the-legend-of-zelda-breath-of-the-wild-switch/",
                "https://assets.nintendo.com/image/upload/c_pad,f_auto,h_613,q_auto,w_1089/ncom/pt_BR/games/switch/t/the-legend-of-zelda-breath-of-the-wild-switch/hero?v=2022042121",
                "1",
                "R$ 299,00"
        ));
    }

    private void getAttributeProduct() {
        Elements shopProductsList = web.select("div.products-dock--main.nvm-mod.mod-group-sell.mod-group-sell-offer")
                .select("div.product-card--grid");
        for (Element p : shopProductsList) {
            Element util = p.selectFirst("div.product__available.product__purchasable.product-card.product-card__cover.product-btn-add-to-cart--container");
            listShopProduct.add(new NuuvemShopProductModel(
                    util.attr("data-track-product-name"),
                    util.attr("data-track-product-url"),
                    util.attr("data-track-product-image-url"),
                    "1",
                    util.attr("data-track-product-price")
            ));
        }
    }
}

