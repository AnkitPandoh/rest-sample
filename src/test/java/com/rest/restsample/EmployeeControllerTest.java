package com.rest.restsample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.rest.restsample.controller.EmployeeController;
import com.rest.restsample.model.Address;
import com.rest.restsample.model.EmployeeModel;
import com.rest.restsample.service.IEmployeeService;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class, secure = false)
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IEmployeeService employeeService;
	
	@Test
	public void testForValidEmployeeId() throws Exception {
		Mockito.when(employeeService.getEmployeeById(Mockito.anyLong())).thenReturn(getMockEmployee());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/1").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{\"id\":1,\"firstName\":\"Ankit\",\"lastName\":\"Pandoh\",\"address\":{\"city\":\"Delhi\",\"country\":\"India\",\"zipCode\":\"110053\"},\"contactNumber\":\"987654353\"}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void testForInvalidEmployeeId() throws Exception{
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/a").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(jsonPath("$.errorCode").value(400)).andDo(print());
	}
	
	private EmployeeModel getMockEmployee(){
		EmployeeModel employee = new EmployeeModel();
		employee.setFirstName("Ankit");
		employee.setLastName("Pandoh");
		employee.setContactNumber("987654353");
		employee.setId(1L);
		Address address = new Address("Delhi","India","110053");
		employee.setAddress(address);
		return employee;
	}

}
