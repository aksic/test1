package net.emisia.svn2git.service;

import java.util.List;

import net.emisia.svn2git.model.SynchronizationEntity;

public interface SynchronizationService {

    List<SynchronizationEntity> deleteEntry(String name);

    SynchronizationEntity findByName(String name);

    boolean entityExistsInXml(SynchronizationEntity synchronizationEntity);

    List<SynchronizationEntity> listAllEntries();

    List<SynchronizationEntity> saveEntry(SynchronizationEntity synchronizationEntity);

    List<SynchronizationEntity> updateEntry(SynchronizationEntity synchronizationEntity);

}
