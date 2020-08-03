package com.apex.unittesting.unittestingmockito.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import ch.qos.logback.core.status.Status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HelloWorldController.class) //(HelloWorldController.class)
public class HelloWorldControllerTest {
	
	@Autowired
	MockMvc mockMvc; 
	
	@Test
	public void helloWorld_basic() throws Exception {
		//call =>GET "/hello-world" (it is a URI) accepting application in json format 
		
		RequestBuilder request = MockMvcRequestBuilders.get("/hello-world")
				                 .accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(request)
									.andExpect(status().isOk())
									.andExpect(content().string("Hello World"))
									.andReturn();
		
	
		//verify returning "Hello World"
		//assertEquals("Hello World", result.getResponse().getContentAsString());
		
	}

}
