package com.fastcampus.banking.adpater.in.web;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegisterBankAccountControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	public void testRegisterMembership() throws Exception {
		RegisterBankAccountRequest request = new RegisterBankAccountRequest("1", "woori bank", "1234567789", true);
		mockMvc.perform(
			post("/banking/account/register")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(request))
		)
			.andExpect(status().isOk());
		// .andExpect(MockMvcResultMatchers.content().string(mapper.writeValueAsString(expect)));

	}

}