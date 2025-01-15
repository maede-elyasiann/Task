package org.example.lookinsure.gateway;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class PriceEnquiryGateway {

    private static final Integer MIN_PRICE = 10;
    private static final Integer MAX_PRICE = 100;

    public Map<Long, Integer> getPrice(List<Long> productIds){
        Random random = new Random();
        return productIds.stream()
                .collect(Collectors.toMap(
                        id -> id,
                        price -> MIN_PRICE + random.nextInt((MAX_PRICE - MIN_PRICE) + 1)
                ));
    }
}
