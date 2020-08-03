package com.apex.unittesting.unittestingmockito.bo;

import static org.junit.Assert.*;

import org.junit.Test;

import com.apex.unittesting.unittestingmockito.data.DataService;

class DataServiceStub implements DataService{

	@Override
	public int[] retieveAllData() {
		return new int[] {1,2,3};
	}
	
}
class DataServiceStub_empty implements DataService{

	@Override
	public int[] retieveAllData() {
		return new int[] {};
	}
	
}
class DataServiceStub_oneValue implements DataService{

	@Override
	public int[] retieveAllData() {
		return new int[] {5};
	}
	
}
public class BusinessStubTest {

	@Test
	public void CalculateSumUsingDataServive_basic() {
		
		BusinessImpl business = new BusinessImpl();
		
		business.setDataService(new DataServiceStub()); 
		int actualResult = business.calculateSumUsingDataService();
		
		int expected = 6;
		assertEquals(expected, actualResult);
		
	}
	
	@Test
	public void CalculateSumUsingDataServive_empty() {
		
		BusinessImpl business = new BusinessImpl();
		
		business.setDataService(new DataServiceStub_empty()); 
		int actualResult = business.calculateSumUsingDataService();
		
		int expected = 0;
		assertEquals(expected, actualResult);
		
	}
	
	@Test
	public void CalculateSumUsingDataServive_oneValue() {
		
		BusinessImpl business = new BusinessImpl();
		business.setDataService(new DataServiceStub_oneValue()); 
		int actualResult = business.calculateSumUsingDataService();
		int expected = 5;
		assertEquals(expected, actualResult);
		
	}

}
