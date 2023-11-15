package com.shiptime.demo.dto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RateResponseDTO {
    List<RateDTO> listRates;

    public List<RateDTO> getListRates() {
        return listRates;
    }

    public void setListRates(List<RateDTO> listRates) {
        this.listRates = listRates;
        Collections.sort(this.listRates, Comparator.comparing(RateDTO::getTotalPrice));
    }
}
