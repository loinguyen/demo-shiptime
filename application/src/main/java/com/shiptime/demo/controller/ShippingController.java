package com.shiptime.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shiptime.demo.dto.*;
import com.shiptime.demo.manager.ShippingManager;
import com.shiptime.demo.dto.ErrorMessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.io.IOException;
import java.util.Arrays;

@RestController
public class ShippingController {

    Logger logger = LoggerFactory.getLogger(ShippingController.class);
    @Autowired
    ShippingManager shippingManager;

    @Autowired
    ObjectMapper objectMapper;

    @PostMapping("/rate")
    @ResponseBody
    public ResponseEntity<RateResponseDTO> getRate(@RequestBody RateRequestDTO requestData) {
        logger.info(requestData.toString());
        RateResponseDTO result = shippingManager.getShippingRates(requestData);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/ship")
    @ResponseBody
    public ResponseEntity<CreateShipmentResponseDTO> postShipment(@RequestBody CreateShipmentRequestDTO requestDTO) {
        CreateShipmentResponseDTO result = shippingManager.createShippingPackage(requestDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/label", produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public ResponseEntity<byte[]> postShipmentLabel(@RequestBody CreateLabelRequestDTO requestDTO) {
        byte[] result = shippingManager.getPrintingLabel(requestDTO);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=downloaded.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(result);
    }

    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<ErrorMessageDTO> handleWebClientException(WebClientResponseException ex) throws JsonProcessingException {
        logger.info(ex.getStatusText());
        if(HttpStatus.BAD_REQUEST.equals(ex.getStatusCode())) {
            String errorMessages = ex.getResponseBodyAsString();
            ErrorMessageDTO messageDTO = objectMapper.readValue(errorMessages, ErrorMessageDTO.class);
            return ResponseEntity.badRequest().body(messageDTO);
        }
        if (HttpStatus.UNAUTHORIZED.equals(ex.getStatusCode())) {
            ErrorMessageDTO errorMessage = new ErrorMessageDTO();
            errorMessage.setMessages(Arrays.asList(ex.getMessage()));
            errorMessage.setSuccess(false);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage);
        }
        if (HttpStatus.NOT_FOUND.equals(ex.getStatusCode())) {
            ErrorMessageDTO errorMessage = new ErrorMessageDTO();
            errorMessage.setMessages(Arrays.asList(ex.getMessage()));
            errorMessage.setSuccess(false);
            return ResponseEntity.badRequest().body(errorMessage);
        } else {
            ErrorMessageDTO errorMessage = new ErrorMessageDTO();
            errorMessage.setMessages(Arrays.asList("An unexpected error has occurred, please try again"));
            errorMessage.setSuccess(false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
}
