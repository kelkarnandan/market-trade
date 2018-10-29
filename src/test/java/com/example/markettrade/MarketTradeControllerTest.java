package com.example.markettrade;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.markettrade.controller.MarketTradeController;
import com.example.markettrade.model.MarketTradeModel;
import com.example.markettrade.service.MarketTradeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = MarketTradeController.class)
@ContextConfiguration(classes = { TestConfiguration.class })
@TestPropertySource(properties = { "spring.activemq.broker-url = tcp://localhost:61616" })
public class MarketTradeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Mock
    private MarketTradeService mtService;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ObjectMapper mapper;

    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testMarketTradetransfer() throws Exception {

        String json = mapper.writeValueAsString(createRequestBody());

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/marketTrade/transfer")
                .content(json).accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "";

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    private MarketTradeModel createRequestBody() {
        MarketTradeModel mtModel = new MarketTradeModel();
        mtModel.setUserId("1234");
        mtModel.setCurrencyFrom("EUR");
        mtModel.setCurrencyTo("GBP");
        mtModel.setAmountSell(new BigDecimal("1000"));
        mtModel.setAmountBuy(new BigDecimal("741.7"));
        mtModel.setRate(new BigDecimal("0.7417"));
        mtModel.setProcessedTime(System.currentTimeMillis());
        mtModel.setOriginatingCountry("FR");
        return mtModel;
    }

}
