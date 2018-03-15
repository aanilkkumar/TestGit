package com.globallogic.report.billing;
import com.globallogic.report.billing.domain.PredictionResponse;
import com.globallogic.report.billing.rest.BillingController;
import com.globallogic.report.billing.service.PredictionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by sunny on 15/03/18.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = BillingControllerTest.class, secure = false)
public class BillingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BillingController billingController;

    @Test
    public void getPredictedBill() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(this.billingController).build();
        mockMvc.perform(get("/app/bill").param("date", "11-Aug-2017"))
                            .andExpect(status().isOk());
    }

    @Test
    public void getWrongPath() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(this.billingController).build();
        mockMvc.perform(get("/app/bil").param("date", "11-Aug-2017"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getWrongParam() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(this.billingController).build();
        mockMvc.perform(get("/app/bill").param("name", "11-Aug-2017"))
                .andExpect(status().isBadRequest());
    }

}