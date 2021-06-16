package com.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwtuserauthentication.JwtauthenticationserverApplication;
import com.jwtuserauthentication.repository.UserRepository;
import com.jwtuserauthentication.entity.User;
import com.jwtuserauthentication.helper.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {JwtauthenticationserverApplication.class})
class JwtauthenticationserverApplicationTests {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;
	ObjectMapper om= new ObjectMapper();

	@MockBean
	private UserRepository repository;

	@BeforeEach
	private void setUp(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void saveuserTest() throws Exception {
		User user = new User();
		user.setEmail("email");
		user.setUserName("Ajay");
		user.setFirstName("Kumar");
		user.setLastName("ajay123");
		user.setPassword("passs");
		user.setCouponIdList(new ArrayList<>());
		user.setDealsList(new ArrayList<>());
		user.setEnabled(true);
		user.setRol("aaa");
		user.setPoints(12);
		user.setDealIdList(new ArrayList<>());
		user.setCouponsList(new ArrayList<>());
		String jsonRequest=om.writeValueAsString(user);
		MvcResult result = mockMvc.perform(post("/adduser").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Response response = om.readValue(resultContent,Response.class);
		Assert.isTrue(response.isStatus(), String.valueOf(Boolean.TRUE));
	}
	@Test
	public void generateTokenTest() throws Exception {
		User user = new User();
		user.setEmail("email");
		user.setUserName("Ajay");
		user.setFirstName("Kumar");
		user.setLastName("ajay123");
		user.setPassword("passs");
		user.setCouponIdList(new ArrayList<>());
		user.setDealsList(new ArrayList<>());
		user.setEnabled(true);
		user.setRol("aaa");
		user.setPoints(12);
		user.setDealIdList(new ArrayList<>());
		user.setCouponsList(new ArrayList<>());
		String jsonRequest=om.writeValueAsString(user);
		MvcResult result = mockMvc.perform(post("/token").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
	}

}
