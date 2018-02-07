package net.emisia.svn2git.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import net.emisia.svn2git.idAdapter.IdAdapter;
import net.emisia.svn2git.model.SynchronizationEntity;
import net.emisia.svn2git.model.SynchronizationEntityList;
import net.emisia.svn2git.service.SynchronizationService;
import net.emisia.svn2git.util.EncodingUtils;

@Service
public class SynchronizationServiceImpl implements SynchronizationService {

    private static final String FILE_LOCATION = System.getProperty("user.dir");

    private File _file = new File(FILE_LOCATION.concat("/Data.xml"));

    @Override
    public List<SynchronizationEntity> deleteEntry(String name) {
	List<SynchronizationEntity> entities = readFromXml();
	entities.stream().filter(entity -> entity.getName().equals(name)).findFirst().ifPresent(item -> {
	    entities.remove(item);
	});
	writeToXml(entities);
	return entities;
    }

    @Override
    public boolean entityExistsInXml(SynchronizationEntity synchronizationEntity) {
	List<SynchronizationEntity> entities = readFromXml();
	boolean foundEntity = false;
	Stream<SynchronizationEntity> entitiesStream = entities.stream();
	if (synchronizationEntity.getId() != null) {
	    foundEntity = entitiesStream.anyMatch(entity -> entity.getName().equals(synchronizationEntity.getName())
		    && !entity.getId().equals(synchronizationEntity.getId()));
	} else {
	    foundEntity = entitiesStream.anyMatch(entity -> entity.getName().equals(synchronizationEntity.getName()));
	}
	return foundEntity;
    }

    @Override
    public SynchronizationEntity findByName(String name) {
	List<SynchronizationEntity> entities = readFromXml();
	return entities.stream().filter(a -> a.getName().equals(name)).findFirst().get();
    }

    @Override
    public List<SynchronizationEntity> listAllEntries() {
	return readFromXml();
    }

    @Override
    public List<SynchronizationEntity> saveEntry(SynchronizationEntity synchronizationEntity) {
	List<SynchronizationEntity> entities = readFromXml();
	synchronizationEntity.setGitPassword(EncodingUtils.encryptPassword(synchronizationEntity.getGitPassword()));
	synchronizationEntity.setSvnPassword(EncodingUtils.encryptPassword(synchronizationEntity.getSvnPassword()));
	entities.add(synchronizationEntity);
	writeToXml(entities);
	return entities;
    }

    @Override
    public List<SynchronizationEntity> updateEntry(SynchronizationEntity synchronizationEntity) {
	List<SynchronizationEntity> entities = readFromXml();
	entities.stream().filter(entity -> entity.getId().equals(synchronizationEntity.getId())).findFirst()
		.ifPresent(item -> {
		    item.setName(synchronizationEntity.getName());

		    if (!synchronizationEntity.getSvnPassword().isEmpty()) {
			item.setSvnPassword(EncodingUtils.encryptPassword(synchronizationEntity.getSvnPassword()));
		    }
		    if (!synchronizationEntity.getGitPassword().isEmpty()) {
			item.setGitPassword(EncodingUtils.encryptPassword(synchronizationEntity.getGitPassword()));
		    }
		    item.setSvnLocation(synchronizationEntity.getSvnLocation());
		    item.setSvnUserName(synchronizationEntity.getSvnUserName());
		    item.setGitLocation(synchronizationEntity.getGitLocation());
		    item.setGitUserName(synchronizationEntity.getGitUserName());
		});
	writeToXml(entities);
	return entities;
    }

    private File getFile() {
	return _file;
    }

    private List<SynchronizationEntity> readFromXml() {
	List<SynchronizationEntity> entities = new ArrayList<>();
	if (getFile().exists()) {
	    try {
		JAXBContext jaxbContext = JAXBContext.newInstance(SynchronizationEntityList.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		SynchronizationEntityList ml = (SynchronizationEntityList) jaxbUnmarshaller.unmarshal(getFile());
		entities = ml.getList();
	    } catch (Exception e) {

		throw new RuntimeException(Messages.getString("SynchronizationServiceImpl.unableToRead"), e);
	    }
	} else {
	    writeToXml(entities);
	}
	return entities;
    }

    private void writeToXml(List<SynchronizationEntity> list) {
	try {
	    SynchronizationEntityList ml = new SynchronizationEntityList(list);
	    JAXBContext jaxbContext = JAXBContext.newInstance(SynchronizationEntityList.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.valueOf(true));
	    jaxbMarshaller.setAdapter(new IdAdapter());
	    jaxbMarshaller.marshal(ml, getFile());
	} catch (Exception e) {

	    throw new RuntimeException(Messages.getString("SynchronizationServiceImpl.unableToWrite"), e);
	}
    }

}
