package com.app.car.rental.backend.web.controller;

import com.app.car.rental.backend.web.model.AvisModelSessionDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import static com.app.car.rental.backend.web.controller.ControllerConstants.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class CarRentalControllerTest {
    private static final String VEHICLE_ID_REQUEST_PARAM = "1234";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void givenGetRequest_whenLocationSearchView_thenReturnHtml() throws Exception {
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


    @Test
    void givenPostRequest_whenCarChooseView_thenReturnHtml() throws Exception {
        //given
        //mockMvc

        //when
        MvcResult mvcResult = mockMvc.perform(post(MAIN_URI + CAR_CHOOSE_URI))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        ModelAndView modelAndView = mvcResult.getModelAndView();

        String viewname = null;
        if(modelAndView != null) viewname = modelAndView.getViewName();
        final String viewNameFinal = viewname;

        //then
        assertAll(
                () -> assertEquals(CAR_CHOOSE_VIEW, viewNameFinal, "Returned view is incorrect")
        );

    }

//    @Test
//    void givenPostRequest_whenConfirmationData_thenReturnHtml() throws Exception {
//        //given
//
//        //when
//        MvcResult mvcResult = mockMvc.perform(post(MAIN_URI + RESERVATION_CONFIRMATION_URI))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn();
//        ModelAndView modelAndView = mvcResult.getModelAndView();
//
//        String viewName = null;
//        if(modelAndView != null) viewName = modelAndView.getViewName();
//        final String viewNameFinal = viewName;
//
//        //then
//        assertAll(
//                () -> assertEquals(RESERVATION_CONFIRMATION_VIEW, viewNameFinal, "Returned view is incorrect")
//        );
//    }


    @Test
    void givenPostRequest_whenPassengerDataView_thenReturnHtml() throws Exception{
        //given

        //when
        MvcResult mvcResult = mockMvc.perform(post(MAIN_URI + PASSENGER_DATA_URI))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        ModelAndView modelAndView = mvcResult.getModelAndView();

        String viewName = null;
        if(modelAndView != null) viewName = modelAndView.getViewName();
        final String viewNameFinal = viewName;

        //then
        assertAll(
                () -> assertEquals(PASSENGER_DATA_VIEW, viewNameFinal, "Returned view is incorrect")
        );
    }

    @Test
    void givenGetRequest_whenCarReservationsView_thenReturnHtml() throws Exception {
        //given

        //when
        MvcResult mvcResult = mockMvc.perform(get(MAIN_URI + RESERVATIONS_URI))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        ModelAndView modelAndView = mvcResult.getModelAndView();

        String viewName = null;
        if(modelAndView != null) viewName = modelAndView.getViewName();
        final String viewNameFinal = viewName;

        //then
        assertAll(
                () -> assertEquals(RESERVATIONS_VIEW, viewNameFinal, "Returned view is incorrect" )
        );
    }

    @Test
    void givenGetRequest_whenCarChoose_thenReturnDto() throws Exception {
        // given
        // mockMvc ...

        // when
        MvcResult mvcResult = mockMvc.perform(
                get(MAIN_URI + CAR_CHOOSE_URI).param("vehicleId", VEHICLE_ID_REQUEST_PARAM))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String responseContentAsString = mockHttpServletResponse.getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        AvisModelSessionDto avisModelSessionDto = objectMapper.readValue(responseContentAsString, AvisModelSessionDto.class);

        // then
        assertAll(
                () -> assertNotNull(avisModelSessionDto, "Response Dto is null.")
        );
    }
}