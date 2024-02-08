package com.hks713.jpashop.service;

import com.hks713.jpashop.domain.*;
import com.hks713.jpashop.repository.OrderRepository;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderServiceTest {

    @Autowired
    EntityManager em;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void 상품주문() {
        // given
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address("서울", "강남", "123-123"));
        em.persist(member);

        Book book = new Book();
        book.setName("시골 프로그래밍");
        book.setPrice(10000);
        book.setStockQuantity(10);
        em.persist(book);

        // when
        Long orderId = orderService.order(member.getId(), book.getId(), 2);

        // then
        Order getOrder = orderRepository.findOne(orderId);

        assertThat(OrderStatus.ORDER).isEqualTo(getOrder.getOrderStatus());
        assertThat(1).isEqualTo(getOrder.getOrderItems().size());
        assertThat(10000 * 2).isEqualTo(getOrder.getTotalPrice());
        assertThat(8).isEqualTo(book.getStockQuantity());
    }

    @Test
    public void 주문취소() {
        // given

        // when

        // then
    }

    @Test
    public void 상품주문1() {
        // given

        // when

        // then
    }

}