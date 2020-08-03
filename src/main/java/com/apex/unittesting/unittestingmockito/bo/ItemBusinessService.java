package com.apex.unittesting.unittestingmockito.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apex.unittesting.unittestingmockito.data.ItemRepository;
import com.apex.unittesting.unittestingmockito.model.Item;

@Component
public class ItemBusinessService {
	
	@Autowired
	private ItemRepository repo;
	

	public Item retrieveHardcordedItem() {
		return new Item(1,"Ball",10,100);
	}
	
	public List<Item> retrieveAllItems(){
		List<Item> items = repo.findAll();
		for (Item item : items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		return items;
	}

}
