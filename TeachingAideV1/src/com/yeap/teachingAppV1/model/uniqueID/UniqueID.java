package com.yeap.teachingAppV1.model.uniqueID;

import java.util.UUID;

public class UniqueID {

	private UUID id;
	private String prefix;
	
	public UniqueID()
	{
		id = UUID.randomUUID();
		prefix = new String();
	}
	
	public UniqueID(String prefix)
	{
		id = UUID.randomUUID();
		this.prefix = prefix; 
	}
	
	public String toString()
	{
		return prefix + id.toString();
	}
	
	
	public boolean equals(UniqueID otherID)
	{		
		return this.toString().equals(otherID.toString());
	}
	
	public int compareTo(UniqueID otherID)
	{
		return this.toString().compareToIgnoreCase(otherID.toString());
	}
}
