package com.accelex.sample.exercise.contoller;

import com.accelex.sample.exercise.domain.RentalStatus;
import com.accelex.sample.exercise.dto.RentalDto;
import com.accelex.sample.exercise.dto.RentalRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static com.accelex.sample.exercise.dummy.CustomerDummy.createDummyInvalidCustomerDto;
import static com.accelex.sample.exercise.dummy.RentalDummy.createDummyRentalRequestDto;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RentalControllerTest extends BaseTest{

    private static final String API_CREATE_RENTAL_REQUEST = "/api/rental/request";
    private static final String API_APPROVE_RENTAL_REQUEST = "/api/rental/approve/request/";


    @Test()
    public void createRentalRequest(){
        ResponseEntity<RentalDto> response = sendRequest(API_CREATE_RENTAL_REQUEST, HttpMethod.POST,createDummyRentalRequestDto(), RentalDto.class);
        assertEquals(Objects.requireNonNull(response.getBody()).getStatus(), RentalStatus.PENDING);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    @Test()
    public void approveRentalRequest() throws JsonProcessingException, JSONException {
        ResponseEntity<?> response = sendRequest(API_APPROVE_RENTAL_REQUEST + 1, HttpMethod.PUT,null, Object.class);
        String json = """
                {
                    "message": "Approved rental request"
                }""";
        JSONAssert.assertEquals(json, objectMapper.writeValueAsString(response.getBody()),false);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

}
