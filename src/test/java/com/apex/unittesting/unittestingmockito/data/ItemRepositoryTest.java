package com.apex.unittesting.unittestingmockito.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.apex.unittesting.unittestingmockito.model.Item;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

	@Autowired
	private ItemRepository repo;
	
	@Test
	public void testFinalAll() {
		List<Item> items = repo.findAll();
		
		assertEquals(4,items.size());
	}
	
	@Test
	public void testAValue_fromDb() {
		
		Item item = repo.getOne(10001);
		
		assertEquals("Item1",item.getName());
	}
	
	
	
}
