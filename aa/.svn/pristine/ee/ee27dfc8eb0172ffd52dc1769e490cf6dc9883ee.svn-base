package net.emisia.svn2git.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import net.emisia.svn2git.service.SynchronizationService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Svn2GitControllerTests {

    private MockMvc _mockMvc;

    @MockBean
    private SynchronizationService _synchronizationServiceMock;

    @Autowired
    private WebApplicationContext _webApplicationContext;

    @Before
    public void setUp() {
	_mockMvc = MockMvcBuilders.webAppContextSetup(getWebApplicationContext()).build();
    }

    @Test
    public void testAdd() throws Exception {
	getMockMvc()
		.perform(post("/index/add").param("name", "name").param("svnLocation", "svnLocation")
			.param("svnUserName", "svnUserName").param("svnPassword", "svnPassword")
			.param("gitLocation", "gitLocation").param("gitUserName", "gitUserName")
			.param("gitPassword", "gitPassword"))
		.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/index"));
    }

    @Test
    public void testDeleteEntry() throws Exception {
	getMockMvc().perform(post("/index/delete").param("name", "name")).andExpect(status().is3xxRedirection())
		.andExpect(redirectedUrl("/index"));
	Mockito.verify(getSynchronizationServiceMock(), Mockito.times(1)).deleteEntry("name");
    }

    @Test
    public void testEditEntry() throws Exception {
	getMockMvc().perform(post("/index/edit").param("name", "name")).andExpect(status().isOk())
		.andExpect(view().name("edit")).andExpect(MockMvcResultMatchers.view().name("edit"));
	Mockito.verify(getSynchronizationServiceMock(), Mockito.times(1)).findByName("name");
    }

    @Test
    public void testIndex() throws Exception {
	assertThat(getSynchronizationServiceMock()).isNotNull();
	getMockMvc().perform(MockMvcRequestBuilders.get("/index")).andExpect(status().isOk())
		.andExpect(view().name("index")).andExpect(MockMvcResultMatchers.view().name("index"));
	Mockito.verify(getSynchronizationServiceMock(), Mockito.times(1)).listAllEntries();
    }

    @Test
    public void testUpdate() throws Exception {
	getMockMvc()
		.perform(post("/index/update").param("id", "1").param("name", "name")
			.param("svnLocation", "svnLocation").param("svnUserName", "svnUserName")
			.param("svnPassword", "svnPassword").param("gitLocation", "gitLocation")
			.param("gitUserName", "gitUserName").param("gitPassword", "gitPassword"))
		.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/index"));

    }

    private MockMvc getMockMvc() {
	return _mockMvc;
    }

    private SynchronizationService getSynchronizationServiceMock() {
	return _synchronizationServiceMock;
    }

    private WebApplicationContext getWebApplicationContext() {
	return _webApplicationContext;
    }
}
