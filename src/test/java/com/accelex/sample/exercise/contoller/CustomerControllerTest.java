package com.accelex.sample.exercise.contoller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;


import static com.accelex.sample.exercise.dummy.CustomerDummy.createDummyInvalidCustomerDto;
import static com.accelex.sample.exercise.dummy.CustomerDummy.createDummyValidCustomerDto;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest extends BaseTest {

    private static final String API_CREATE_CUSTOMER = "/api/customer/create";

    @Test
    public void createInvalidCustomer() throws JSONException, JsonProcessingException {
        ResponseEntity<?> response = sendRequest(API_CREATE_CUSTOMER,HttpMethod.POST,createDummyInvalidCustomerDto(),Object.class);
        String json = """
                {
                    "lastName": "Can't be empty",
                    "firstName": "Can't be empty",
                    "driverLicenseNumber": "Can't be empty"
                }""";
        JSONAssert.assertEquals(json, objectMapper.writeValueAsString(response.getBody()),false);
        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void createValidCustomer() throws JsonProcessingException, JSONException {
        ResponseEntity<?> response = sendRequest(API_CREATE_CUSTOMER,HttpMethod.POST,createDummyValidCustomerDto(),Object.class);
        String json = """
                {
                    "id": 6,
                    "firstName": "Dummy firstName",
                    "lastName": "Dummy lastName",
                    "birthDate": null,
                    "driverLicenseNumber": "Dummy license number"
                }""";
        JSONAssert.assertEquals(json,objectMapper.writeValueAsString(response.getBody()),false);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }



}
