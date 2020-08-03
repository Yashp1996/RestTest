package com.apex.unittesting.unittestingmockito.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.apex.unittesting.unittestingmockito.bo.ItemBusinessService;
import com.apex.unittesting.unittestingmockito.model.Item;

import ch.qos.logback.core.status.Status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ItemController.class) //(HelloWorldController.class)
public class ItemControllerTest {
	
	@Autowired
	MockMvc mockMvc; 
	
	@MockBean
	private ItemBusinessService businessService;
	
	 
	
	@Test
	public void DummyItem_basic() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item")
				                 .accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(request)
									.andExpect(status().isOk())
									.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
									.andReturn();
		
	
		
	}
	
	@Test
	public void Item_From_Bo_basic() throws Exception {
		
		when(businessService.retrieveHardcordedItem()).thenReturn(new Item(2, "Item2", 10, 10));
		
		RequestBuilder request = MockMvcRequestBuilders.get("/item-from-bo")
				                 .accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(request)
									.andExpect(status().isOk())
									.andExpect(content().json("{id:2,name:Item2,price:10,quantity:10}"))
									.andReturn();
		
	
		
	}
	
	@Test
	public void retrieveAllItems() throws Exception {
		
		
		
		when(businessService.retrieveAllItems()).thenReturn
			(Arrays.asList(new Item(2,"Item2",20,20),new Item(3,"Item3",30,30) ));
		
		RequestBuilder request = MockMvcRequestBuilders.get("/get-all-from-db")
				                 .accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(request)
									.andExpect(status().isOk())
									.andExpect(content().json("[{id:2,name:Item2,price:20,quantity:20},{id:3,name:Item3,price:30,quantity:30}]"))
									.andReturn();
		
	
		
	}

}
