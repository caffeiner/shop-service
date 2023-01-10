package com.minji.shop.entity;

import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    protected Address() {
        /* JPA 스펙상
         엔티티나 임베디드 타입( @Embeddable )은 자바 기본 생성자(default constructor)를
         public 또는 protected 로 설정해야 한다 */
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
