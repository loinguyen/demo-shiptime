package com.shiptime.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shiptime.demo.controller.ShippingController;
import com.shiptime.demo.dto.*;
import com.shiptime.demo.dto.model.RateRequest;
import com.shiptime.demo.dto.model.RateResponse;
import com.shiptime.demo.dto.model.ShipRequest;
import com.shiptime.demo.dto.model.ShipResponse;
import com.shiptime.demo.manager.ShippingManager;
import com.shiptime.demo.services.ShippingServices;
import com.shiptime.demo.util.GenerateTestDataUtil;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@WebMvcTest(ShippingController.class)
public class ShippingControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ShippingManager shippingManager;

    @Test
    public void testGetRate_Success() throws Exception {
        RateRequestDTO requestDTO = GenerateTestDataUtil.createMockRateRequestDTO();
        String requestJson = objectMapper.writeValueAsString(requestDTO);
        RateResponseDTO response = GenerateTestDataUtil.createMockRateResponseDTO();
        when(shippingManager.getShippingRates(any(RateRequestDTO.class))).thenReturn(response);
        mvc.perform(post("/rate", requestDTO)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(result -> assertNotNull(result))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testPostShipment_Success() throws Exception {
        CreateShipmentRequestDTO requestDTO = GenerateTestDataUtil.createMockCreateShipmentRequestDTO();
        String requestJson = objectMapper.writeValueAsString(requestDTO);
        CreateShipmentResponseDTO response = GenerateTestDataUtil.createMockCreateShipmentResponseDTO();
        when(shippingManager.createShippingPackage(any(CreateShipmentRequestDTO.class))).thenReturn(response);
        mvc.perform(post("/ship", requestDTO)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(result -> assertNotNull(result))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));


    }

    @Test
    public void testPostShipmentLabel_Success() throws Exception {
        CreateLabelRequestDTO requestDTO = new CreateLabelRequestDTO();
        requestDTO.setLabelUrl("https://abc");
        String requestJson = objectMapper.writeValueAsString(requestDTO);
        byte[] data = GenerateTestDataUtil.createMockPDFFileData();
        when(shippingManager.getPrintingLabel(any(CreateLabelRequestDTO.class))).thenReturn(data);
        mvc.perform(post("/label", requestDTO)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(result -> assertNotNull(result))
                .andExpect(content().contentType(MediaType.APPLICATION_PDF));
    }

    @Test
    public void testGetRate_BadRequest() throws Exception {
        CreateShipmentRequestDTO requestDTO = GenerateTestDataUtil.createMockCreateShipmentRequestDTO();
        String requestJson = objectMapper.writeValueAsString(requestDTO);
        ErrorMessageDTO mockMessage = new ErrorMessageDTO();
        mockMessage.setMessages(Arrays.asList("Error Data1", "Error Data2"));
        mockMessage.setSuccess(false);
        String errorJson = objectMapper.writeValueAsString(mockMessage);
        byte[] messageData = errorJson.getBytes(StandardCharsets.UTF_8);
        WebClientResponseException mockException = new WebClientResponseException(
                HttpStatus.BAD_REQUEST.value(), "Bad Request", null, messageData, null
        );
        when(shippingManager.getShippingRates(any(RateRequestDTO.class))).thenThrow(mockException);
        mvc.perform(post("/rate", requestDTO)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetRate_Unauthorized() throws Exception {
        CreateShipmentRequestDTO requestDTO = GenerateTestDataUtil.createMockCreateShipmentRequestDTO();
        String requestJson = objectMapper.writeValueAsString(requestDTO);
        ErrorMessageDTO mockMessage = new ErrorMessageDTO();
        mockMessage.setMessages(Arrays.asList("Error Data1", "Error Data2"));
        mockMessage.setSuccess(false);
        String errorJson = objectMapper.writeValueAsString(mockMessage);
        byte[] messageData = errorJson.getBytes(StandardCharsets.UTF_8);
        WebClientResponseException mockException = new WebClientResponseException(
                HttpStatus.UNAUTHORIZED.value(), "Unauthorized Request", null, messageData, null
        );
        when(shippingManager.getShippingRates(any(RateRequestDTO.class))).thenThrow(mockException);
        mvc.perform(post("/rate", requestDTO)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testGetRate_NotFound() throws Exception {
        CreateShipmentRequestDTO requestDTO = GenerateTestDataUtil.createMockCreateShipmentRequestDTO();
        String requestJson = objectMapper.writeValueAsString(requestDTO);

        WebClientResponseException mockException = new WebClientResponseException(
                HttpStatus.NOT_FOUND.value(), "404 Not Found", null, null, null
        );
        when(shippingManager.getShippingRates(any(RateRequestDTO.class))).thenThrow(mockException);
        mvc.perform(post("/rate", requestDTO)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetRate_ServerError() throws Exception {
        CreateShipmentRequestDTO requestDTO = GenerateTestDataUtil.createMockCreateShipmentRequestDTO();
        String requestJson = objectMapper.writeValueAsString(requestDTO);

        WebClientResponseException mockException = new WebClientResponseException(
                HttpStatus.INTERNAL_SERVER_ERROR.value(), "500 Server Error", null, null, null
        );
        when(shippingManager.getShippingRates(any(RateRequestDTO.class))).thenThrow(mockException);
        mvc.perform(post("/rate", requestDTO)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isInternalServerError());
    }
}
