package payroll.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import payroll.dto.OrderDto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Component
public class OrderClient {

    @Autowired
    RestTemplate restTemplate;


    public List<OrderDto> retrieveOrderList() {
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForEntity("http://localhost:8090/orders/all", OrderDto[].class).getBody()));

    }

    public ResponseEntity<String> postOrder(OrderDto dto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<OrderDto> entity = new HttpEntity<OrderDto>(dto, headers);
        return restTemplate.exchange("http://localhost:8090/orders", HttpMethod.POST, entity, String.class);


    }
}
