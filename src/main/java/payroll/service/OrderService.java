package payroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import payroll.client.OrderClient;
import payroll.dto.OrderDto;

import java.util.List;


@Service
public class OrderService {
    @Autowired
    OrderClient orderClient;

    @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 5000))
    public List<OrderDto> retrieveOrderList() {
//        OrderListResponse response = restTemplate.getForObject("http://localhost:8090/orders/all", OrderListResponse.class);
        return orderClient.retrieveOrderList();

    }

    @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 5000))
    public ResponseEntity<String> postOrder(OrderDto dto) {
        return orderClient.postOrder(dto);
    }
}
