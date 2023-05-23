package com.example.crawlerapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_NUUVEM_SHOP")
public class NuuvemShopProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "product_name")
    @NotBlank
    @JsonProperty("product_name")
    private String productName;

    @Column(name = "product_link")
    @NotBlank
    @JsonProperty("product_link")
    private String productLink;

    @Column(name = "product_pht")
    @NotBlank
    @JsonProperty("product_pht")
    private String productPht;

    @Column(name = "product_page")
    @JsonProperty("product_page")
    private String productPage;

    @Column(name = "product_price")
    @JsonProperty("product_price")
    private String productPrice;

    public NuuvemShopProductModel(@NotBlank String productName, @NotBlank String productLink,
                                  @NotBlank String productPht, String productPage, String productPrice) {
        this.productName = productName;
        this.productLink = productLink;
        this.productPht = productPht;
        this.productPage = productPage;
        this.productPrice = productPrice;
    }

}
