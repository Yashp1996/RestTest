package com.apex.unittesting.unittestingmockito.bo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.apex.unittesting.unittestingmockito.data.ItemRepository;
import com.apex.unittesting.unittestingmockito.model.Item;

@RunWith(value = MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {
	
	@Mock
	private ItemRepository repo;
	
	@InjectMocks
	private ItemBusinessService service;

	@Test
	public void retrieveAllItems_basic() {
	
	when(repo.findAll()).thenReturn(Arrays.asList(new Item(2, "Item2", 20, 20),
			new Item(3, "Item3", 30, 30)));
	
	List<Item> items = service.retrieveAllItems();
	
	assertEquals(2, service.retrieveAllItems().size());
	assertEquals(400, items.get(0).getValue());
	assertEquals(900, items.get(1).getValue());

//	repo.findAll();
//	verify(repo,times(1)).findAll();
	
	
	
	}

}
