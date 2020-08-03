package com.apex.unittesting.unittestingmockito.bo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.internal.verification.AtLeast;

public class ListMock {
	
	List mock = mock(List.class);
	
	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	public void returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	
	@Test
	public void returnWithParam() {
		when(mock.get(0)).thenReturn("Yash");
		assertEquals("Yash", mock.get(0));
	}
	
	@Test
	public void returnWithGenericParam() {
		
		when(mock.get(anyInt())).thenReturn("Yash");
		assertEquals("Yash", mock.get(0));
		assertEquals("Yash", mock.get(10));
	}
	
	@Test
	public void verificationBasics() {
		//system under test
		String value1 = (String) mock.get(0);
		String value2 = (String) mock.get(1);
		//Verify that the 'mock' variable is called get with param 0 or not (above line)
		verify(mock).get(0);
		verify(mock,times(2)).get(anyInt());
		verify(mock,atLeastOnce()).get(anyInt());

		verify(mock,atMost(2)).get(anyInt());
		verify(mock, never()).get(2);
	}
	
	@Test
	public void argumentCapturing() {
		//SUT => System Under Test
		mock.add("SomeString");
		
		//Verify that mock.add() is add "SomeString" as a argument
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		
		assertEquals("SomeString", captor.getValue());
	}
	
	@Test
	public void multipleArgumentCapturing() {
		//SUT => System Under Test
		mock.add("SomeString1");
		mock.add("SomeString2");
		
		//Verify that mock.add() is add "SomeString" as a argument
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());
		
		List<String> captorValus = captor.getAllValues();
		
		assertEquals("SomeString1", captorValus.get(0));
		assertEquals("SomeString2", captorValus.get(1));
	}
	
	@Test
	public void mocking() {
		ArrayList arrayList = mock(ArrayList.class);
		
		System.out.println(arrayList.get(0));//null
		System.out.println(arrayList.size());//0
		
		arrayList.add("Test1");
		arrayList.add("Test2");
		
		System.out.println(arrayList.size());//0
		when(arrayList.size()).thenReturn(5);
		System.out.println(arrayList.size());//5
	}
	
	@Test
	public void skying() {
		ArrayList arraySpyList = spy(ArrayList.class);
		arraySpyList.add("Test0");
		System.out.println(arraySpyList.get(0));//Test0
		System.out.println(arraySpyList.size());//1
		
		arraySpyList.add("Test1");
		arraySpyList.add("Test2");
		
		System.out.println(arraySpyList.size());//3
		
		when(arraySpyList.size()).thenReturn(10); 
		System.out.println(arraySpyList.size());//10
		
		arraySpyList.add("Test3");
		System.out.println(arraySpyList.size());//10
		
		arraySpyList.add("Test4");
		System.out.println(arraySpyList.size());//10
		
	}
	

}
