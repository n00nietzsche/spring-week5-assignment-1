package com.codesoom.assignment.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {
    @Test
    void toStringTest() {
        String builderToString = Product.builder()
                .id(1L)
                .name("쥐돌이")
                .maker("냥이월드")
                .price(5000)
                .toString();

        assertThat(builderToString).isEqualTo("Product.ProductBuilder(id=1, name=쥐돌이, maker=냥이월드, price=5000, imageUrl=null)");
    }

    @Test
    void creationWithBuilder() {
        Product product = Product.builder()
                .id(1L)
                .name("쥐돌이")
                .maker("냥이월드")
                .price(5000)
                .build();

        assertThat(product.getId()).isEqualTo(1L);
        assertThat(product.getName()).isEqualTo("쥐돌이");
        assertThat(product.getMaker()).isEqualTo("냥이월드");
        assertThat(product.getPrice()).isEqualTo(5000);
        assertThat(product.getImageUrl()).isNull();
    }

    @Test
    void change() {
        Product product = Product.builder()
                .id(1L)
                .name("쥐돌이")
                .maker("냥이월드")
                .price(5000)
                .build();

        product.change("쥐순이", "코드숨", 10000,
                "http://localhost:8080/rat");

        assertThat(product.getName()).isEqualTo("쥐순이");
        assertThat(product.getMaker()).isEqualTo("코드숨");
        assertThat(product.getPrice()).isEqualTo(10000);
        assertThat(product.getImageUrl())
                .isEqualTo("http://localhost:8080/rat");
    }
}
