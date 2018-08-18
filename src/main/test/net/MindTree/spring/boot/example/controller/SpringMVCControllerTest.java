package net.MindTree.spring.boot.example.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import net.MindTree.spring.boot.example.Application;

/**
 * @author prasa
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = Application.class)
public class SpringMVCControllerTest {

	final String BASE_URL = "http://localhost:8080/v2";
	 @Autowired
	    private WebApplicationContext wac;

	    private MockMvc mockMvc;

	    @Before
	    public void setup() {
	        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	    }


	@Test
	public void transactionTest1() throws Exception {
		 this.mockMvc.perform(get("/transactions?orderBy=id&direction=ASC&from=-10&size=10")
                 .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                 .andExpect(status().isOk());
			}
	@Test
	public void transactionTest2() throws Exception {
		 this.mockMvc.perform(get("/transactions?orderBy=id&direction=DESC&from=0&size=-10")
                 .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                 .andExpect(status().isOk());
			}
	@Test
	public void transactionTest3() throws Exception {
		 this.mockMvc.perform(get("/transactions?orderBy=amount&direction=ASC&from=-10&size=10")
                 .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                 .andExpect(status().isOk());
			}
	@Test
	public void transactionTest4() throws Exception {
		 this.mockMvc.perform(get("/transactions?orderBy=amount&direction=DESC&from=-10&size=10")
                 .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                 .andExpect(status().isOk());
			}
	@Test
	public void transactionTest5() throws Exception {
		 this.mockMvc.perform(get("/transactions?orderBy=instructedAmount&direction=ASC&from=-10&size=10")
                 .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                 .andExpect(status().isOk());
			}
	@Test
	public void transactionTest6() throws Exception {
		 this.mockMvc.perform(get("/transactions?orderBy=instructedAmount&direction=DESC&from=-10&size=10")
                 .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                 .andExpect(status().isOk());
			}
	@Test
	public void transactionTest7() throws Exception {
		 this.mockMvc.perform(get("/transactions?orderBy=instructedAmount&direction=DESC&from=-10&size=10gdf")
                 .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                 .andExpect(status().is(400));
			}
}
