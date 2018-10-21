package de.mschneid.unittesting.business;

import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String str = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws Exception {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, str, true);
    }

    @Test
    public void jsonAssert_StrictFalse() throws Exception {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";
        JSONAssert.assertEquals(expectedResponse, str, false);
    }

    // escaping is only necessary if you have a space in your value
    @Test
    public void jsonAssert_WithoutEscapeCharacters() throws Exception {
        String expectedResponse = "{id:1, name:Ball, price:10}";
        JSONAssert.assertEquals(expectedResponse, str, false);
    }
}
