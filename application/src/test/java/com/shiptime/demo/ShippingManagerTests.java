package com.shiptime.demo;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shiptime.demo.dto.*;
import com.shiptime.demo.dto.model.RateRequest;
import com.shiptime.demo.dto.model.RateResponse;
import com.shiptime.demo.dto.model.ShipRequest;
import com.shiptime.demo.dto.model.ShipResponse;
import com.shiptime.demo.manager.ShippingManager;
import com.shiptime.demo.services.ShippingServices;
import com.shiptime.demo.util.GenerateTestDataUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.ClassPathResource;
import reactor.core.publisher.Mono;

import java.io.InputStream;

public class ShippingManagerTests {

    @Mock
    private ShippingServices shippingServices;
    @InjectMocks
    private ShippingManager shippingManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetShippingRate_Success() {
        RateRequestDTO requestDTO = GenerateTestDataUtil.createMockRateRequestDTO();
        Mono<RateResponse> response = GenerateTestDataUtil.createMockRateResponse();
        when(shippingServices.getShippingRates(any(RateRequest.class))).thenReturn(response);
        RateResponseDTO result = shippingManager.getShippingRates(requestDTO);
        assertNotNull(result);
        assertNotNull(result.getListRates());
        assertEquals(1, result.getListRates().size());
    }

    @Test
    public void testCreateShippingPackage_Success() {
        CreateShipmentRequestDTO requestDTO = GenerateTestDataUtil.createMockCreateShipmentRequestDTO();
        Mono<ShipResponse> response = GenerateTestDataUtil.createMockShipResponse();
        when(shippingServices.postShipments(any(ShipRequest.class))).thenReturn(response);
        CreateShipmentResponseDTO result = shippingManager.createShippingPackage(requestDTO);
        assertNotNull(result);
        assertNotNull(result.getShipId());
        assertNotNull(result.getTrackingNumber());
        assertNotNull(result.getPrintUrl());
        assertEquals(false, result.getShipId().isEmpty());
        assertEquals(false, result.getTrackingNumber().isEmpty());
        assertEquals(false, result.getPrintUrl().isEmpty());


    }

    @Test
    public void testGetPrintingLabel_Success() {
        CreateLabelRequestDTO requestDTO = new CreateLabelRequestDTO();
        requestDTO.setLabelUrl("https://abc");
        byte[] data = GenerateTestDataUtil.createMockPDFFileData();
        Mono<byte[]> response = Mono.just(data);
        when(shippingServices.getPrintedLabel(anyString())).thenReturn(response);
        byte[] result = shippingManager.getPrintingLabel(requestDTO);
        assertNotNull(result);
    }



}
