package net.emisia.svn2git.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import net.emisia.svn2git.idAdapter.IdAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SynchronizationEntity {

    private String _gitLocation;
    private String _gitPassword;
    private String _gitUserName;
    @XmlAttribute
    @XmlJavaTypeAdapter(IdAdapter.class)
    private Integer _id;
    private String _name;
    private String _svnLocation;
    private String _svnPassword;
    private String _svnUserName;

    public SynchronizationEntity() {
    }

    public SynchronizationEntity(Integer id, String name, String svnLocation, String svnUserName, String svnPassword,
	    String gitLocation, String gitUserName, String gitPassword) {
	super();
	_gitLocation = gitLocation;
	_gitPassword = gitPassword;
	_gitUserName = gitUserName;
	_id = id;
	_name = name;
	_svnLocation = svnLocation;
	_svnPassword = svnPassword;
	_svnUserName = svnUserName;
    }

    public SynchronizationEntity(String name, String svnLocation, String svnUserName, String svnPassword,
	    String gitLocation, String gitUserName, String gitPassword) {
	super();
	_name = name;
	_svnLocation = svnLocation;
	_svnUserName = svnUserName;
	_svnPassword = svnPassword;
	_gitLocation = gitLocation;
	_gitUserName = gitUserName;
	_gitPassword = gitPassword;
    }

    public String getGitLocation() {
	return _gitLocation;
    }

    public String getGitPassword() {
	return _gitPassword;
    }

    public String getGitUserName() {
	return _gitUserName;
    }

    public Integer getId() {
	return _id;
    }

    public String getName() {
	return _name;
    }

    public String getSvnLocation() {
	return _svnLocation;
    }

    public String getSvnPassword() {
	return _svnPassword;
    }

    public String getSvnUserName() {
	return _svnUserName;
    }

    public void setGitLocation(String gitLocation) {
	_gitLocation = gitLocation;
    }

    public void setGitPassword(String gitPassword) {
	_gitPassword = gitPassword;
    }

    public void setGitUserName(String gitUserName) {
	_gitUserName = gitUserName;
    }

    public void setId(Integer id) {
	_id = id;
    }

    public void setName(String name) {
	_name = name;
    }

    public void setSvnLocation(String svnLocation) {
	_svnLocation = svnLocation;
    }

    public void setSvnPassword(String svnPassword) {
	_svnPassword = svnPassword;
    }

    public void setSvnUserName(String svnUserName) {
	_svnUserName = svnUserName;
    }

    @Override
    public String toString() {
	return "SynchronizationEntity [_gitLocation=" + _gitLocation + ", _gitPassword=" + _gitPassword
		+ ", _gitUserName=" + _gitUserName + ", _id=" + _id + ", _name=" + _name + ", _svnLocation="
		+ _svnLocation + ", _svnPassword=" + _svnPassword + ", _svnUserName=" + _svnUserName + "]";
    }

}
