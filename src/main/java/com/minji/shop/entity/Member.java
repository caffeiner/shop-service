package com.minji.shop.entity;

import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    //엔티티 객체는 타입으로 구분하면 되기 때문에 id라는 이름만으로도 쉽게 구별할 수 있다, 하지만 테이블은 그렇지 않기 때문에 테이블명_id 를 사용한다.
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

}
