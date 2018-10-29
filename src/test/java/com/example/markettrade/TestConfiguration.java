package com.example.markettrade;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;

import com.example.markettrade.dao.MarketTradeRepository;
import com.example.markettrade.service.MarketTradeService;

@Profile("test")
@Configuration
public class TestConfiguration {

    @Bean
    @Primary
    public JmsTemplate jmsTemplate() {
        return Mockito.mock(JmsTemplate.class);
    }

    @Bean
    @Primary
    public MarketTradeService marketTradeService() {
        return Mockito.mock(MarketTradeService.class);
    }

    @Bean
    @Primary
    public MarketTradeRepository marketTradeRepository() {
        return Mockito.mock(MarketTradeRepository.class);
    }

}
