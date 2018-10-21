package de.mschneid.unittesting.controller;

import de.mschneid.unittesting.model.Item;
import de.mschneid.unittesting.service.ItemBusinessService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessServiceMock;

    @Test
    public void dummyItem_basic() throws Exception {
        RequestBuilder request =
                MockMvcRequestBuilders
                        .get("/dummy-item")
                        .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();

        //JSONAssert.assertEquals();

        // verify Hello World is duplicated
        //assertEquals("Hello World", result.getResponse().getContentAsString());
    }

    @Test
    public void itemFromBusinessService() throws Exception {
        Item item = Item.builder().id(1).name("Ball").price(10).build();
        when(businessServiceMock.retrieveHardcodedItem()).thenReturn(item);
        RequestBuilder request =
                MockMvcRequestBuilders
                        .get("/item-from-business-service")
                        .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:1, name:Ball, price:10}"));

    }

}