package com.hks713.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Order order;

    @Embedded
    private Address address;

    @Enumerated(value = EnumType.STRING)
    private DeliveryStatus deliveryStatus;

}
