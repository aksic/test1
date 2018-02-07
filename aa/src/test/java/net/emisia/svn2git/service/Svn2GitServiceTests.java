package net.emisia.svn2git.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.emisia.svn2git.model.SynchronizationEntity;
import net.emisia.svn2git.model.SynchronizationEntityList;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Svn2GitServiceTests {

    @Autowired
    private SynchronizationService _synchronizationService;

    @After
    public void after() {

	List<SynchronizationEntity> lista = new ArrayList<>();
	writeToXml(lista);
    }

    @Before
    public void before() {
	List<SynchronizationEntity> lista = new ArrayList<>();
	lista.add(new SynchronizationEntity(Integer.valueOf(1), "prvi", "svnLocation", "svnUserName", "svnPassword",
		"gitLocation", "gitUserName", "gitPassword"));
	lista.add(new SynchronizationEntity(Integer.valueOf(2), "drugi", "svnLocation", "svnUserName", "svnPassword",
		"gitLocation", "gitUserName", "gitPassword"));
	lista.add(new SynchronizationEntity(Integer.valueOf(3), "treci", "svnLocation", "svnUserName", "svnPassword",
		"gitLocation", "gitUserName", "gitPassword"));
	lista.add(new SynchronizationEntity(Integer.valueOf(4), "cetvrti", "svnLocation", "svnUserName", "svnPassword",
		"gitLocation", "gitUserName", "gitPassword"));
	writeToXml(lista);
    }

    @Test
    public void testDeleteETntry() {
	Integer actualListSize = Integer.valueOf(getSynchronizationService().listAllEntries().size());
	getSynchronizationService().deleteEntry("treci");
	assertEquals(actualListSize.intValue() - 1, getSynchronizationService().listAllEntries().size());
    }

    @Test
    public void testEntityExistsInXml() {
	assertTrue(getSynchronizationService().entityExistsInXml(new SynchronizationEntity("prvi", "svnLocation",
		"svnUserName", "svnPassword", "gitLocation", "gitUserName", "gitPassword")));
	assertFalse(getSynchronizationService().entityExistsInXml(new SynchronizationEntity(Integer.valueOf(1), "prvi",
		"svnLocation", "svnUserName", "svnPassword", "gitLocation", "gitUserName", "gitPassword")));
    }

    @Test
    public void testFindById() {
	assertEquals("drugi", getSynchronizationService().findByName("drugi").getName());
	assertEquals("treci", getSynchronizationService().findByName("treci").getName());
    }

    @Test
    public void testListAll() throws IOException {
	assertEquals(4, getSynchronizationService().listAllEntries().size());
    }

    @Test
    public void testSaveEntry() {
	SynchronizationEntity newModel = new SynchronizationEntity("peti", "svnLocation", "svnUserName", "svnPassword",
		"gitLocation", "gitUserName", "gitPassword");
	int actualListSize = getSynchronizationService().listAllEntries().size();
	List<SynchronizationEntity> savedList = getSynchronizationService().saveEntry(newModel);
	assertTrue(savedList.stream().anyMatch(model -> model.getName().equals("peti")));
	assertEquals(actualListSize + 1, getSynchronizationService().listAllEntries().size());
    }

    @Test
    public void testUpdateEntry() {
	SynchronizationEntity newModel = new SynchronizationEntity(Integer.valueOf(1), "prvi1", "svnLocation",
		"svnUserName", "svnPassword", "gitLocation", "gitUserName", "gitPassword");
	getSynchronizationService().updateEntry(newModel);
	List<SynchronizationEntity> updatedList = getSynchronizationService().listAllEntries();
	assertEquals("svnLocation", getSynchronizationService().findByName("prvi1").getSvnLocation());
	assertTrue(updatedList.stream().anyMatch(model -> model.getName().equals("prvi1")));
    }

    private SynchronizationService getSynchronizationService() {
	return _synchronizationService;
    }

    private void writeToXml(List<SynchronizationEntity> lista) {
	String _dir = System.getProperty("user.dir");
	try {
	    SynchronizationEntityList ml = new SynchronizationEntityList(lista);
	    JAXBContext jaxbContext = JAXBContext.newInstance(SynchronizationEntityList.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.valueOf(true));
	    jaxbMarshaller.marshal(ml, new File(_dir + "/Data.xml"));
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }
}
