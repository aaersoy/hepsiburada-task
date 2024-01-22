package org.example.modal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    String name;
    String price;
    int count;

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
        this.count = 0;
    }
}
