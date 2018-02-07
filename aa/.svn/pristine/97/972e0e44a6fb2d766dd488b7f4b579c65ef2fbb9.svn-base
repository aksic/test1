package net.emisia.svn2git.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SynchronizationEntity")
public class SynchronizationEntityList {

    private List<SynchronizationEntity> _list = new ArrayList<>();

    public SynchronizationEntityList() {
    }

    public SynchronizationEntityList(List<SynchronizationEntity> list) {
	_list = list;
    }

    public List<SynchronizationEntity> getList() {
	return _list;
    }

    @XmlElement(name = "SynchronizationEntity")
    public void setList(List<SynchronizationEntity> list) {
	_list = list;
    }

    @Override
    public String toString() {
	return "SynchronizationEntity [list=" + _list + "]";
    }

}
