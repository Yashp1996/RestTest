package com.apex.unittesting.unittestingmockito.bo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.apex.unittesting.unittestingmockito.data.DataService;


@RunWith(value = MockitoJUnitRunner.class)
public class BusinessMockTest {
	
	@InjectMocks
	BusinessImpl business;// = new BusinessImpl();
	
	@Mock
	DataService dataService;// = mock(DataService.class);

//	@Before
//	public void before() {
//		business.setDataService(dataService);
//	}

	@Test
	public void CalculateSumUsingDataServive_basic() {

		when(dataService.retieveAllData()).thenReturn(new int[] { 1, 2, 3 });
		assertEquals(6, business.calculateSumUsingDataService());

	}

	@Test
	public void CalculateSumUsingDataServive_empty() {
		
		when(dataService.retieveAllData()).thenReturn(new int[] {});
		assertEquals(0, business.calculateSumUsingDataService());

	}

	@Test
	public void CalculateSumUsingDataServive_oneValue() {
		
		when(dataService.retieveAllData()).thenReturn(new int[] {5});
		assertEquals(5, business.calculateSumUsingDataService());
		
	}
	
	

}
