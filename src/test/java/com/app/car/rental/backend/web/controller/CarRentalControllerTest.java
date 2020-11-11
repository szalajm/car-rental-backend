package com.app.car.rental.backend.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import static com.app.car.rental.backend.web.controller.ControllerConstants.LOCATION_SEARCH_URI;
import static com.app.car.rental.backend.web.controller.ControllerConstants.LOCATION_SEARCH_VIEW;
import static com.app.car.rental.backend.web.controller.ControllerConstants.MAIN_URI;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CarRentalControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void given_whenLocationSearchView_thenReturnHtml() throws Exception {
        // given
        // mockMvc ...
        // when
        MvcResult mvcResult = mockMvc.perform(get(MAIN_URI + LOCATION_SEARCH_URI))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        ModelAndView modelAndView = mvcResult.getModelAndView();

        String viewName = null;
        if (modelAndView != null) viewName = modelAndView.getViewName();
        final String viewNameFinal = viewName;
        // then
        assertAll(
                () -> {
                    assertEquals(LOCATION_SEARCH_VIEW, viewNameFinal, "Returned view is incorrect.");
                }
        );
    }
}