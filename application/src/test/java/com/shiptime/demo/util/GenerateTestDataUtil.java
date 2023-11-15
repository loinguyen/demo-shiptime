package com.shiptime.demo.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shiptime.demo.dto.CreateShipmentRequestDTO;
import com.shiptime.demo.dto.CreateShipmentResponseDTO;
import com.shiptime.demo.dto.RateRequestDTO;
import com.shiptime.demo.dto.RateResponseDTO;
import com.shiptime.demo.dto.model.RateResponse;
import com.shiptime.demo.dto.model.ShipResponse;
import org.springframework.core.io.ClassPathResource;
import reactor.core.publisher.Mono;

import java.io.InputStream;

public class GenerateTestDataUtil {
    public static RateRequestDTO createMockRateRequestDTO() {
        String jsonData = "{\"from\":{\"company\":\"\",\"streetAdd\":\"181 King St E\",\"streetAdd2\":\"\",\"city\":\"Kitchener\",\"countryCode\":\"CA\",\"state\":\"ON\",\"postalCode\":\"N2G 2K8\",\"attention\":\"Loi\",\"email\":\"loi.nguyen.01835@gmail.com\",\"phone\":\"15197814386\"},\"to\":{\"company\":\"\",\"streetAdd\":\"492 Brentcliffe Drive\",\"streetAdd2\":\"\",\"city\":\"Waterloo\",\"countryCode\":\"CA\",\"state\":\"ON\",\"postalCode\":\"N2T2R8\",\"attention\":\"Quynh\",\"email\":\"quynhngo172@gmail.com\",\"phone\":\"6573356766\"},\"shipDate\":\"2023-11-14\",\"packageDetail\":{\"length\":\"5\",\"width\":\"5\",\"height\":\"5\",\"weight\":\"1\",\"value\":\"\",\"description\":\"\"}}";
        ObjectMapper mapper = new ObjectMapper();
        RateRequestDTO request;
        try {
            request = mapper.readValue(jsonData, RateRequestDTO.class);
        } catch (Exception ex) {
            request = new RateRequestDTO();
        }
        return request;
    }

    public static Mono<RateResponse> createMockRateResponse() {
        String jsonData = "{\"availableRates\":[{\"baseCharge\":{\"currency\":\"CAD\",\"amount\":1406},\"surcharges\":[{\"price\":{\"currency\":\"CAD\",\"amount\":2740},\"code\":\"FUEL\",\"name\":\"FUEL\"},{\"price\":{\"currency\":\"CAD\",\"amount\":3445},\"code\":\"SATURDAY_DELIVERY\",\"name\":\"SATURDAY_DELIVERY\"},{\"price\":{\"currency\":\"CAD\",\"amount\":187},\"code\":\"RESIDENTIAL\",\"name\":\"Home Delivery\"},{\"price\":{\"currency\":\"CAD\",\"amount\":65},\"code\":\"OTHER\",\"name\":\"PKS\"},{\"price\":{\"currency\":\"CAD\",\"amount\":67},\"code\":\"OTHER\",\"name\":\"CBN\"}],\"taxes\":[{\"price\":{\"currency\":\"CAD\",\"amount\":1028},\"code\":\"TAX\",\"name\":\"HST\"}],\"totalCharge\":{\"currency\":\"CAD\",\"amount\":8938},\"totalBeforeTaxes\":{\"currency\":\"CAD\",\"amount\":7910},\"exchangeRate\":0.0000,\"carrierId\":\"39\",\"carrierName\":\"Dicom\",\"serviceId\":\"GRD\",\"serviceName\":\"Ground\",\"transitDays\":1,\"cutoffTime\":\"16:00\",\"accessTimeInterval\":\"2:00\",\"quoteId\":\"5b8b9def0c32e1cbda39105e4ff671da\"}]}";
        ObjectMapper mapper = new ObjectMapper();
        RateResponse response;
        try {
            response = mapper.readValue(jsonData, RateResponse.class);
        } catch (Exception ex) {
            response = new RateResponse();
        }
        Mono<RateResponse> returnValue = Mono.just(response);
        return returnValue;
    }

    public static CreateShipmentRequestDTO createMockCreateShipmentRequestDTO() {
        String jsonData = "{\"carrierId\":\"39\",\"serviceId\":\"GRD\",\"rateRequest\":{\"from\":{\"company\":\"\",\"streetAdd\":\"181 King St E\",\"streetAdd2\":\"\",\"city\":\"Kitchener\",\"countryCode\":\"CA\",\"state\":\"ON\",\"postalCode\":\"N2G 2K8\",\"attention\":\"Loi\",\"email\":\"loi.nguyen.01835@gmail.com\",\"phone\":\"15197814386\"},\"to\":{\"company\":\"\",\"streetAdd\":\"492 Brentcliffe Drive\",\"streetAdd2\":\"\",\"city\":\"Waterloo\",\"countryCode\":\"CA\",\"state\":\"ON\",\"postalCode\":\"N2T2R8\",\"attention\":\"Quynh\",\"email\":\"quynhngo172@gmail.com\",\"phone\":\"6573356766\"},\"shipDate\":\"2023-11-14\",\"packageDetail\":{\"length\":\"5\",\"width\":\"5\",\"height\":\"5\",\"weight\":\"1\",\"value\":\"\",\"description\":\"\"}},\"shipmentDetail\":{\"pickupDate\":\"2023-11-14\",\"fromTime\":\"10:00\",\"toTime\":\"14:00\",\"location\":\"FRONTDOOR\"}}";
        ObjectMapper mapper = new ObjectMapper();
        CreateShipmentRequestDTO requestDTO;
        try {
            requestDTO = mapper.readValue(jsonData, CreateShipmentRequestDTO.class);
        } catch (Exception ex) {
            requestDTO = new CreateShipmentRequestDTO();
        }
        return requestDTO;
    }

    public static Mono<ShipResponse> createMockShipResponse() {
        String jsonData = "{\"shipId\":4826016,\"trackingNumbers\":[\"P00154350\"],\"labelUrl\":\"http://abc\",\"carrierTrackingUrl\":\"https://abcd\"}";
        ObjectMapper mapper = new ObjectMapper();
        ShipResponse response;
        try {
            response = mapper.readValue(jsonData, ShipResponse.class);
        } catch (Exception ex) {
            response = new ShipResponse();
        }

        return Mono.just(response);
    }

    public static CreateShipmentResponseDTO createMockCreateShipmentResponseDTO() {
        ShipResponse response = createMockShipResponse().block();
        return TransformDtoUtil.transformShipResponseToDTO(response);
    }

    public static RateResponseDTO createMockRateResponseDTO() {
        RateResponse response = createMockRateResponse().block();
        return TransformDtoUtil.transformRateResponseToDTO(response);
    }

    public static byte[] createMockPDFFileData () {
        try {
            ClassPathResource resource = new ClassPathResource("/test/shipping_label.pdf");
            try (InputStream inputStream = resource.getInputStream()) {
                return inputStream.readAllBytes();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
