package com.apex.unittesting.unittestingmockito.bo;

import com.apex.unittesting.unittestingmockito.data.DataService;

public class BusinessImpl {
	
	private DataService dataService;
	
	
	public int calculateSum(int[] data) {
		int sum = 0;
		for (int value : data) {
			sum+=value;
		}
		return sum;
	}
	
	public int calculateSumUsingDataService() {
		int sum = 0;
		int[] data = dataService.retieveAllData();
		for (int value : data) {
			sum+=value;
		}
		
		//dataService.storeSum(sum) ==> in the test i want to know if the some other method is called
		//                              or not, like this! that is very verification come in mock
		//								verify()
		return sum;
	}

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	
	
}
