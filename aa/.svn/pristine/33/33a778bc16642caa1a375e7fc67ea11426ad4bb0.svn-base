package net.emisia.svn2git.idAdapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class IdAdapter extends XmlAdapter<Integer, Integer> {
    private int counter = 1;

    @Override
    public Integer marshal(Integer v) throws Exception {
	return Integer.valueOf(counter++);
    }

    @Override
    public Integer unmarshal(Integer v) throws Exception {
	return v;
    }
}
