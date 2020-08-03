package com.apex.unittesting.unittestingmockito.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.apex.unittesting.unittestingmockito.model.Item;


public interface ItemRepository extends JpaRepository<Item, Integer> {

}
