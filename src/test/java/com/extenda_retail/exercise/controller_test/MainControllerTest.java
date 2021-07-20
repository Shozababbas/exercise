package com.extenda_retail.exercise.controller_test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.extenda_retail.exercise.controller.MainController;
import com.extenda_retail.exercise.service.NumberService;

@WebMvcTest(MainController.class)
public class MainControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private NumberService numberService;

	@Test
	@DisplayName("/check/{number} API test")
	public void ifNumberIsPerfect() throws Exception {
		mvc.perform(get("/perfect-number/check/5")).andExpect(status().is2xxSuccessful())
				.andExpect(content().string("Number entered by you (5) is not a perfect number"));
	}
}
