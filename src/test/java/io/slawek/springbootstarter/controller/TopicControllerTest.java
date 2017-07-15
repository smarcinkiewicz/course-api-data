package io.slawek.springbootstarter.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import io.slawek.springbootstarter.topic.Topic;
import io.slawek.springbootstarter.topic.TopicController;
import io.slawek.springbootstarter.topic.TopicService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class TopicControllerTest {

    @InjectMocks
    private TopicController topicController;

    @Mock
    private TopicService topicService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        InternalResourceViewResolver view = new InternalResourceViewResolver();
        view.setPrefix("/templates/");
        view.setSuffix(".html");
        mockMvc = MockMvcBuilders.standaloneSetup(topicController).setViewResolvers(view).build();
    }

    @Test
    public void testTopicListInit() throws Exception{
        List<Topic> topics = new ArrayList<>();
        topics.add(new Topic());
        topics.add(new Topic());

        Mockito.when(topicService.getAllTopics()).thenReturn(topics);

        mockMvc.perform(get("/topics"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("topicList", topics))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("topic_details"));
    }

    @Test
    public void testAddTopicInit() throws Exception{
        mockMvc.perform(post("/topics"))
                .andExpect(model().attributeExists("Topic"))
                .andExpect(status().isOk())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testAddTopicPostSuccess() throws Exception {
        mockMvc.perform(post("/topics")
                .param("id", "1")
                .param("name", "Java")
                .param("description", "This is Java Topic Description")
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testAddTopicPostFormHasErrors() throws Exception {
        mockMvc.perform(post("/topics")
                .param("id", "1")
                .param("name", "Java"))
                .andExpect(model().attributeHasFieldErrors("topic", "description"))
                .andExpect(model().attributeHasErrors("topic"))
                .andExpect(view().name("topic_details"));
    }
}