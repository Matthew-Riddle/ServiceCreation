package com.cooksys.ServiceCreation;

import java.io.Serializable;

public interface BaseEntity<Id extends Serializable> {

	public Id getId();

	public void setId(Id id);

}
