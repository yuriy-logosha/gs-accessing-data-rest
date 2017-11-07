package service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import service.repositories.ExtensionRepository;
import service.repositories.LoanRepository;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ModuleTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private LoanRepository loanRepository;

    @Autowired
    private ExtensionRepository extensionRepository;

	@Before
	public void deleteAllBeforeTests() throws Exception {
        loanRepository.deleteAll();
        extensionRepository.deleteAll();
	}

	@Test
    @WithMockUser("170483-18001")
	public void shouldCreateRetrieveLoanWithExtension() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/loans")
                .content("{\"term\":5, \"amount\": 200}"))
                .andExpect(status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");

        mockMvc.perform(post("/extensions")
                .content("{\"term\":5, \"interest\": 1.5, \"loan\": \"" + location + "\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", containsString("extensions/")));

        mockMvc.perform(get(location)).andExpect(status().isOk())
                .andExpect(jsonPath("$.term").value("5"))
                .andExpect(jsonPath("$.amount").value("200.0"));
	}


}