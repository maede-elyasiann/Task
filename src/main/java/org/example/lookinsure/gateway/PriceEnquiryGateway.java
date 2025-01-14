package org.example.lookinsure.gateway;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class PriceEnquiryGateway {

    private static final Double MIN_PRICE = 1000d;
    private static final Double MAX_PRICE = 5000d;

    public Map<Long, Double> getPrice(List<Long> productIds){
        Random random = new Random();
        return productIds.stream()
                .collect(Collectors.toMap(
                        id -> id,
                        id -> MIN_PRICE + (MAX_PRICE * random.nextDouble())
                ));
    }
}
