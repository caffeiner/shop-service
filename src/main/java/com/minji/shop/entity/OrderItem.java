package com.minji.shop.entity;

import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "order_item")
/**
 * 주문은 여러개일 수 있고 아이템도 여러개일 수 있으니 다대다관계가 맞지만
 * 다대다 관계는 웬만하면 사용하지 X, 따라서 중간에 OrderItem 이라는 테이블을 만들어
 * 일대다, 다대일 관계로 풀어냄
 * */
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item; //주문 상품

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order; //주문

    private int orderPrice; //주문 가격

    private int count; //주문 수량
}
