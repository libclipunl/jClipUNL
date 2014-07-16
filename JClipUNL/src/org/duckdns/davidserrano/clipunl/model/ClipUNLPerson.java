package org.duckdns.davidserrano.clipunl.model;

import java.io.Serializable;
import java.util.List;

public interface ClipUNLPerson extends Serializable {

	public abstract String getRole();

	public abstract String getUrl();

	public abstract String getId();

	public abstract List<Integer> getYears();

}