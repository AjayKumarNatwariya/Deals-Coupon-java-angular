package com.coupon;

import com.coupon.repository.CouponRepository;
import com.coupon.entity.Coupon;
import com.coupon.helper.Response;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CouponsServiceApplicationTests {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;
	ObjectMapper om= new ObjectMapper();

	@MockBean
	private CouponRepository repository;

	@BeforeEach
	private void setUp(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void saveCouponTest() throws Exception {
		Coupon c = new Coupon(15L,"https://www.google.com","Google card","15/01/2022","CPN001",15,1200,1600,25,new ArrayList<>(),new ArrayList<>());
		String jsonRequest=om.writeValueAsString(c);
		MvcResult result = mockMvc.perform(post("/coupon/addcoupon").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Response response = om.readValue(resultContent,Response.class);
		Assert.isTrue(response.isStatus(), String.valueOf(Boolean.TRUE));
	}

	@Test
	public void getAllCouponsTest() throws Exception {
		when(repository.findAll()).thenReturn(Stream.of(
				new Coupon(15L,"https://www.google.com","Google card","15/01/2022","CPN001",15,1200,1600,25,new ArrayList<>(),new ArrayList<>()),
				new Coupon(15L,"https://www.google.com","Google card","15/01/2022","CPN002",20,12000,800,15,new ArrayList<>(),new ArrayList<>())).collect(Collectors.toList()));
		MvcResult result = mockMvc.perform(get("/coupon/allcoupons")).andExpect(status().isOk()).andReturn();
		List<Coupon> actual = om.readValue(result.getResponse().getContentAsString(), new TypeReference<List<Coupon>>() {});
		assertEquals(2,actual.size());
	}
}
