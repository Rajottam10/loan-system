package com.fl.fbs.services;

import com.fl.fbs.dtos.LoanRequest;
import com.fl.fbs.dtos.LoanResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class LoanRequestService {

    private final RestClient restClient;

    public LoanRequestService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("http://localhost:8083").build();
    }

    public LoanResponse forwardRequestToCentral(LoanRequest request) {
        return restClient.post()
                .uri("/loan-decisions")
                .body(request)
                .retrieve()
                .body(LoanResponse.class);
    }
}
