package com.example.AuthDemo;

import com.example.AuthDemo.mock.MockUserDB;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value=UserController.class, secure=false)
public class UserControllerTest {
    private static final String BATMAN = "{\"username\":\"Bruce Wayne\",\"bio\":\"Gotham's vigilant vigilante.\"}";

    @Before
    public void resetDB() {
        MockUserDB.reset();
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetUsers() {
        String url = "/users";
        String expected = "[{\"username\":\"Bruce Wayne\",\"bio\":\"Gotham's vigilant vigilante.\"},{\"username\":\"Clark Kent\",\"bio\":\"A hero from another world\"},{\"username\":\"Joe Schmoe\",\"bio\":\"True American hero.\"}]";
        assertUrlReturnsExpectedString(url, expected);
    }

    @Test
    public void testGetUser() {
        int id = 0;
        String url = "/users/" + id;
        String expected = BATMAN;
        assertUrlReturnsExpectedString(url, expected);
    }

    @Test
    public void testCreateDefaultUser() throws Exception {
        String url = "/users";
        String expected = "{\"username\":\"No Name\",\"bio\":\"\"}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(url);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    public void testEditUser() throws Exception {
        String url = "/users/0";

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put(url).contentType(MediaType.APPLICATION_JSON);
        requestBuilder.param("username", "Bruce Wayne");
        requestBuilder.param("password", "whatever");
        requestBuilder.param("bio", "new bio");

        String result = mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();
        assertTrue(result.contains("new bio"));
    }

    //@Test
    public void testCreateCustomUser() throws Exception {
        String url = "/users";

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(url);
        requestBuilder.contentType(MediaType.APPLICATION_JSON);
        requestBuilder.param("username", "moon");
        requestBuilder.param("password", "colony");
        requestBuilder.param("bio", "now");

        String result = mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();

        assertTrue(result.contains("moon"));
        assertTrue(result.contains("colony"));
        assertTrue(result.contains("now"));
    }


    public void assertUrlReturnsExpectedString(String url, String expected) {
        try {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).accept(MediaType.ALL);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();
            assertEquals(expected, result.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
            // intentionally fail the test.
            assertTrue(false);
        }
    }

}