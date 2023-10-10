package com.accelex.sample.exercise.contoller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public abstract class BaseTest {

    private static final String DOMAIN = "http://localhost:";

    @LocalServerPort
    protected int port;
    protected final TestRestTemplate restTemplate = new TestRestTemplate();
    protected final HttpHeaders headers = new HttpHeaders();
    protected final ObjectMapper objectMapper = new ObjectMapper();

    protected String createURLWithPort(String uri) {
        return DOMAIN + port + uri;
    }

    protected  <T> ResponseEntity<T> sendRequest(String api, HttpMethod method,Object body, Class<T> responseType){
        HttpEntity<Object> entity = new HttpEntity<>(body,headers);
        return restTemplate.exchange(
                createURLWithPort(api),
                method, entity, responseType);
    }

}
