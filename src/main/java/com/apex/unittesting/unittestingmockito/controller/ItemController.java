package com.apex.unittesting.unittestingmockito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apex.unittesting.unittestingmockito.bo.ItemBusinessService;
import com.apex.unittesting.unittestingmockito.model.Item;

@RestController
public class ItemController {
	
	
	
	@Autowired
	private ItemBusinessService businessService;

	@GetMapping("/dummy-item")
	public Item dummyItem(){
		return new Item(1,"Ball",10,100);
	}
	
	@GetMapping("/item-from-bo")
	public Item itemFromBo(){
		return businessService.retrieveHardcordedItem();
	}
	
	@GetMapping("/get-all-from-db")
	public List<Item> retriveAllItems(){
		return businessService.retrieveAllItems();
	}
	
}
