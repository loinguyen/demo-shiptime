package com.shiptime.demo.util;

import com.shiptime.demo.dto.*;
import com.shiptime.demo.dto.model.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransformDtoUtil {
    
    public static AddressModel transformAddressDtoToModel (AddressDTO requestDTO) {
        AddressModel model = new AddressModel();
        model.setCompanyName(requestDTO.getAttention());
        model.setStreetAddress(requestDTO.getStreetAdd());
        model.setStreetAddress2(requestDTO.getStreetAdd2());
        model.setCity(requestDTO.getCity());
        model.setCountryCode(requestDTO.getCountryCode());
        model.setState(requestDTO.getState());
        model.setPostalCode(requestDTO.getPostalCode());
        model.setAttention(requestDTO.getAttention());
        model.setPhone(requestDTO.getPhone());
        model.setResidential(true);
        model.setNotify(false);
        model.setEmail(requestDTO.getEmail());
        return model;
    }
    
    public static LineItemModel transformPackageDetailDtoToModel (PackageDTO packageDTO) {
        LineItemModel item = new LineItemModel();
        item.setLength(packageDTO.getLength());
        item.setHeight(packageDTO.getHeight());
        item.setWidth(packageDTO.getWidth());
        item.setWeight(packageDTO.getWeight());
        return item;
    }
    
    public static RateRequest transformRateRequestDtoToModel(RateRequestDTO requestDTO) {
        RateRequest request = new RateRequest();
        AddressModel from = transformAddressDtoToModel(requestDTO.getFrom());
        AddressModel to = transformAddressDtoToModel(requestDTO.getTo());
        LineItemModel item1 = transformPackageDetailDtoToModel(requestDTO.getPackageDetail());

        request.setFrom(from);
        request.setTo(to);
        request.setPackageType(RateRequest.PackageTypeEnum.MY_ENVELOPE);
        request.setLineItems(Arrays.asList(item1));
        request.setUnitOfMeasurement(RateRequest.UnitOfMeasurementEnum.METRIC);
        request.setShipDate(requestDTO.getShipDate());
        request.setServiceOptions(Arrays.asList(RateRequest.ServiceOptionsEnum.SATURDAY_DELIVERY));
        request.setInsuranceType(RateRequest.InsuranceTypeEnum.CARRIER);

        return request;
    }

    public static PickupDetailModel transformShipmentDetailDtoToModel(ShipmentDetailDTO requestDTO) {
        PickupDetailModel request = new PickupDetailModel();
        request.setLocation(PickupDetailModel.LocationEnum.valueOf(requestDTO.getLocation()));
        request.setReadyTime(requestDTO.getFromTime());
        request.setCloseTime(requestDTO.getToTime());
        request.setPickupDate(requestDTO.getPickupDate());

        return request;
    }

    public static ShipRequest transformCreateShipmentRequestDtoToModel(CreateShipmentRequestDTO requestDTO) {
        ShipRequest request = new ShipRequest();
        RateRequest rateRequest = TransformDtoUtil.transformRateRequestDtoToModel(requestDTO.getRateRequest());
        PickupDetailModel pickupDetail = TransformDtoUtil.transformShipmentDetailDtoToModel(requestDTO.getShipmentDetail());

        request.setRateRequest(rateRequest);
        request.setPickupDetail(pickupDetail);
        request.setCarrierId(requestDTO.getCarrierId());
        request.setServiceId(requestDTO.getServiceId());

        return request;
    }

    public static RateResponseDTO transformRateResponseToDTO(RateResponse rateResponseModel) {
        RateResponseDTO responseDTO = new RateResponseDTO();
        List<RateDTO> rateList = rateResponseModel.getAvailableRates().stream().map(item -> {
            RateDTO rateDto = new RateDTO();
            rateDto.setCarrier(item.getCarrierName());
            rateDto.setService(item.getServiceName());
            rateDto.setEstimateDelivery(item.getTransitDays());
            rateDto.setCarrierId(item.getCarrierId());
            rateDto.setServicesId(item.getServiceId());
            rateDto.setTotalPrice(BigDecimal.valueOf(item.getTotalCharge().getAmount()/(double)100));
            rateDto.setTotalPriceBeforeTax(BigDecimal.valueOf(item.getTotalBeforeTaxes().getAmount()/(double)100));
            rateDto.setCurrency(item.getTotalCharge().getCurrency().toString());

            return rateDto;
        }).collect(Collectors.toList());
        responseDTO.setListRates(rateList);
        return responseDTO;
    }

    public static CreateShipmentResponseDTO transformShipResponseToDTO(ShipResponse response) {
        CreateShipmentResponseDTO responseDTO = new CreateShipmentResponseDTO();
        responseDTO.setShipId(String.valueOf(response.getShipId()));
        responseDTO.setTrackingNumber(String.valueOf(response.getTrackingNumbers()));
        responseDTO.setPrintUrl(response.getLabelUrl());
        return responseDTO;
    }
}
