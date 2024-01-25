package com.hks713.jpashop.service;

import com.hks713.jpashop.domain.Book;
import com.hks713.jpashop.domain.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Test
    public void 아이템저장() throws Exception {
        // given
        Book book = new Book();
        book.setName("미움받을용기");
        book.setPrice(10000);
        book.setStockQuantity(10);
        book.setAuthor("hks713");
        book.setIsbn("isbn");

        itemService.save(book);
        // when
        Item findItem = itemService.findOne(1L);

        // then
        assertThat(findItem.getId()).isEqualTo(1L);


    }
}