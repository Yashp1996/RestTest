package com.apex.unittesting.unittestingmockito.spike;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
	
	@Test
	public void jsonAssert_StrictTrue_ExactMatchExceptSpace() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\" :\"Ball\",\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	}
	
	@Test
	public void jsonAssert_StrictFalse_DONOTNEEDExactMatchORSpace() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\" :\"Ball\"}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}

}
