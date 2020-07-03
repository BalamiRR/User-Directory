package com.fuatkara.thymeleaf.controller;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {
	
	// 200 is ok
	@Test
    public void getRequestShouldReturn_ok_200(@Autowired MockMvc mockMvc) throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/employees/list"))
		.andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	//200 is ok
	@Test
    public void getRequestShouldRetur_ok_200(@Autowired MockMvc mockMvc) throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/employees/showFormForAdd")
				.content("{\"name\": \"showFormForAdd\"}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
    }
	
	//POST 302 Error
	@Test
	public void postRequestShouldReturn_notallowed_302(@Autowired MockMvc mockMvc) throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.post("/employees/save")
				.content("{\"name\": \"save\"}"))
				.andExpect(MockMvcResultMatchers.status().is3xxRedirection());
	}
	
	//DELETE 405 Error
	@Test
    public void deleteRequestShouldReturn_notallowed_405(@Autowired MockMvc mockMvc) throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/employees/delete")
				.content("{\"name\": \"delete\"}"))
 				.andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
    } 
	
	// PUT 405 Error
	@Test
    public void putRequestShouldReturn_notallowed_405(@Autowired MockMvc mockMvc) throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.put("/employees/showFormForUpdate")
				.content("{\"name\": \"showFormForUpdate\"}"))
				.andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
    }
	
	@Test
    public void optionsRequestShouldReturn_notallowed_404(@Autowired MockMvc mockMvc) throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.options("/employees"))
				.andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
	
	
	
	
}