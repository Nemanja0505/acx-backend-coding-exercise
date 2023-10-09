package com.accelex.sample.exercise.contoller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.accelex.sample.exercise.dummy.VehicleDummy.createDummyInvalidVehicleDto;
import static com.accelex.sample.exercise.dummy.VehicleDummy.createDummyValidVehicleDto;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VehicleControllerTest extends BaseTest{

    private static final String API_CREATE_VEHICLE = "/api/vehicle/create";

    @Test
    public void createInvalidVehicle() throws JSONException, JsonProcessingException {
        ResponseEntity<?> response = sendRequest(API_CREATE_VEHICLE,HttpMethod.POST,createDummyInvalidVehicleDto(),Object.class);
        String json = """
                {
                     "colour": "Can't be empty",
                     "year": "Year must be greater then 1900",
                     "registration": "Can't be empty",
                     "model": "Can't be empty",
                     "brand": "Can't be empty"
                 }""";
        JSONAssert.assertEquals(json, objectMapper.writeValueAsString(response.getBody()),false);
        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void createValidVehicle() throws JSONException, JsonProcessingException {
        ResponseEntity<?> response = sendRequest(API_CREATE_VEHICLE,HttpMethod.POST,createDummyValidVehicleDto(),Object.class);
        String json = """
                {
                      "id": 6,
                      "brand": "Dummy brand",
                      "model": "Dummy model",
                      "year": 1999,
                      "colour": "Dummy colour",
                      "registration": "Dummy registration"
                  }""";
        JSONAssert.assertEquals(json, objectMapper.writeValueAsString(response.getBody()),false);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }


}
