package com.apex.unittesting.unittestingmockito.bo;

import static org.junit.Assert.*;

import org.junit.Test;

public class BusinessTest {

	@Test
	public void CalculateSum_basic() {
		
		BusinessImpl business = new BusinessImpl();
		int actualResult = business.calculateSum(new int[] {1,2,3});
		int expected = 6;
		assertEquals(expected, actualResult);
		
	}
	
	@Test
	public void CalculateSum_empty() {
		
		BusinessImpl business = new BusinessImpl();
		int actualResult = business.calculateSum(new int[] {});
		int expected = 0;
		assertEquals(expected, actualResult);
		
	}
	
	@Test
	public void CalculateSum_oneValue() {
		
		BusinessImpl business = new BusinessImpl();
		int actualResult = business.calculateSum(new int[] {5});
		int expected = 5;
		assertEquals(expected, actualResult);
		
	}

}
