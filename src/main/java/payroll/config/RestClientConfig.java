package payroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import payroll.client.RequestInterseptor.RequestResponseLoggingInterceptor;

import java.util.Collections;


@Configuration
public class RestClientConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
        return restTemplate;
    }
}