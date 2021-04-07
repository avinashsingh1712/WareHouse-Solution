package com.warehouse;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.warehouse.controller.WarehouseController;
import com.warehouse.model.InventryVo;
import com.warehouse.model.ProductsVo;
import com.warehouse.service.ProductServiceImpl;
import com.warehouse.service.ProductUploadImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(WarehouseController.class)
public class WarehouseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductServiceImpl businessService;
    
    @MockBean
    private ProductUploadImpl prodUploadService;
    

    @Test
    public void AppStarterWelcomeTest() throws Exception{

        // call "/dummy-item"
        RequestBuilder request = MockMvcRequestBuilders
        		.get("/api/v1/welcome")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result2 = mockMvc.perform(request)
                .andExpect(status().is(200))
                .andExpect(content().string("Welcome to the Warehouse solution..."))
                .andReturn();
    }
    
    @Test
    public void inventryListTest() throws Exception{

        // call "/hello-world"
        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/v1/inventry")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andReturn();

        // verify "Hello World!"
//        MvcResult result2 = mockMvc.perform(request)
//                .andExpect(status().is(200))
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andReturn();

        //assertEquals("Hello World!", result.getResponse().getContentAsString());
    }

    @Test
    public void productListTest() throws Exception{

//        when(businessService.getAllArticle()).thenReturn(
//                new ArrayList<InventryVo>().add(new InventryVo("1", "Ball", 10);

        // call "/dummy-item"
        RequestBuilder request = MockMvcRequestBuilders
                .get("/products")
                .accept(MediaType.APPLICATION_JSON);
        List<ProductsVo> list = new ArrayList<ProductsVo>();
        // verify Item
//        MvcResult result = mockMvc.perform(request)
//                .andExpect(status().is(200))
//                .andExpect(list)
//                .andReturn();
    }

    @Test
    public void retrieveInventry() throws Exception{

//        when(businessService.getAllArticle()).thenReturn(
//                Arrays.asList(new InventryVo("1", "Item1", 10),
//                new InventryVo("1", "Item1", 10),
//               new InventryVo("1", "Item1", 10))
//        );

        // call "/dummy-item"
        RequestBuilder request = MockMvcRequestBuilders
                .get("/articles")
                .accept(MediaType.APPLICATION_JSON);

        // verify Item
//        MvcResult result = mockMvc.perform(request)
//                .andExpect(status().is(200))
//                .andExpect(content().json("[{id:1,name:Item1,price:10,quantity:120}," +
//                        "{id:2,name:Item2,price:10,quantity:120}," +
//                        "{id:3,name:Item3,price:10,quantity:120}]"))
//                .andReturn();
    }
    
    
}