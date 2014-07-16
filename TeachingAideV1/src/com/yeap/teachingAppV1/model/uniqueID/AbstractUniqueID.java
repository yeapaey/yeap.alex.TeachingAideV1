package com.yeap.teachingAppV1.model.uniqueID;

import java.util.UUID;

abstract public class AbstractUniqueID {

	private UUID id;
	private String prefix;
	
	public AbstractUniqueID()
	{
		id = UUID.randomUUID();
	}
	
	public AbstractUniqueID(String prefix)
	{
		id = UUID.randomUUID();
		this.prefix = prefix; 
	}

	
	public String toString()
	{
		return prefix + id.toString();
	}
	
	
	public boolean equals(AbstractUniqueID otherID)
	{
		
		return this.toString().equals(otherID.toString());
	}
	
}
