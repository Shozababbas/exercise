package com.ER.exercise.controller_test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.ER.exercise.controller.MainController;
import com.ER.exercise.request.Range;
import com.ER.exercise.service.NumberService;
import com.fasterxml.jackson.databind.ObjectMapper;

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

	@Test
	@DisplayName("/check-all/{number} - {number} API test")
	public void ifNumberRangeIsPerfect() throws Exception {
		Range range = new Range(1l, 10l);
		mvc.perform(
				get("/perfect-number/check-all/").contentType(MediaType.APPLICATION_JSON).content(asJsonString(range)))
				.andExpect(status().isNoContent());
	}

	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
