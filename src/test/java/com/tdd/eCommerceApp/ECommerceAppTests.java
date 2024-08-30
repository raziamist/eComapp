package com.tdd.eCommerceApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ECommerceAppTests {

	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() throws Exception {
		/*mockMvc.perform(MockMvcRequestBuilders.get("/customerWishList"))
				.andExpect(MockMvcResultMatchers.status().isOk());*/
	}

}
