package service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import service.repositories.LoanRepository;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private LoanRepository loanRepository;

	@Before
	public void deleteAllBeforeTests() throws Exception {
        loanRepository.deleteAll();
	}

	@Test
	public void shouldReturnRepositoryIndex() throws Exception {
		mockMvc.perform(get("/")).andDo(print())
                .andExpect(status().isOk()).andExpect(
				jsonPath("$._links.loans").exists());
	}

	@Test
	public void shouldCreateLoan() throws Exception {
		mockMvc.perform(post("/loans")
				.content("{\"ssn\": \"123456-00000\", \"term\":5, \"amount\": 100}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", containsString("loans/")));
	}

	@Test
	public void shouldRetrieveLoan() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/loans")
                .content("{\"ssn\": \"123456-00000\", \"term\":5, \"amount\": 100}"))
                .andExpect(status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(get(location)).andExpect(status().isOk())
                .andExpect(jsonPath("$.ssn").value("123456-00000"))
                .andExpect(jsonPath("$.term").value("5"))
                .andExpect(jsonPath("$.amount").value("100.0"));
	}

}