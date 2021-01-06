package com.example.tvshows.controller;

import com.example.tvshows.model.Tvshow;
import com.example.tvshows.service.TvshowService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class TvshowControllerTest extends TvshowControllerTests {
    private MockMvc mvc;

    @Mock
    private TvshowController tvshowController;

    @InjectMocks
    private TvshowService tvshowService;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(tvshowController)
                .build();
    }

    public void testgetAllShows() throws Exception{
        String uri = "/api/allTvshows";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Tvshow[] productlist = super.mapFromJson(content, Tvshow[].class);
        assertTrue(productlist.length > 0);
    }



}
