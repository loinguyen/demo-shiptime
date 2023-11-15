package com.shiptime.demo.manager;

import com.shiptime.demo.dto.*;
import com.shiptime.demo.dto.model.*;
import com.shiptime.demo.services.ShippingServices;
import com.shiptime.demo.util.TransformDtoUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShippingManager {

    ShippingServices shippingServices;

    public ShippingManager(ShippingServices shippingServices) {

        this.shippingServices = shippingServices;
    }

    public RateResponseDTO getShippingRates(RateRequestDTO requestDTO) {
        RateRequest request = TransformDtoUtil.transformRateRequestDtoToModel(requestDTO);

        Mono<RateResponse> result = shippingServices.getShippingRates(request);
        RateResponse rateResponseModel = result.block();

        return TransformDtoUtil.transformRateResponseToDTO(rateResponseModel);
    }
    public CreateShipmentResponseDTO createShippingPackage(CreateShipmentRequestDTO requestDTO) {
        ShipRequest request = TransformDtoUtil.transformCreateShipmentRequestDtoToModel(requestDTO);

        Mono<ShipResponse> result = shippingServices.postShipments(request);
        ShipResponse response = result.block();


        return TransformDtoUtil.transformShipResponseToDTO(response);
    }

    public byte[] getPrintingLabel(CreateLabelRequestDTO requestDTO) {
        Mono<byte[]> result = shippingServices.getPrintedLabel(requestDTO.getLabelUrl());
        return result.block();
    }
}
