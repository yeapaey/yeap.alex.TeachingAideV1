package com.yeap.teachingAppV1.model;

import java.util.Iterator;
import java.util.TreeSet;

import com.yeap.teachingAppV1.model.uniqueID.UniqueID;

public class SearchableTreeSet<E> extends TreeSet<E> {

	public E getByID(UniqueID elemID)
	{
		Iterator<E> iter = this.iterator();
		E current;
		
		while (iter.hasNext())
		{
			current = iter.next();
			if (current.equals(elemID))
			{
				return current;
			}
		}
		
		return null;
	}
	
	
	public boolean removeByID(UniqueID elemID)
	{
		Iterator<E> iter = this.iterator();
		E current;
		
		while (iter.hasNext())
		{
			current = iter.next();
			if (current.equals(elemID))
			{
				iter.remove();
				return true;
			}
		}
		
		return false;
	}
	
	
//	private Iterator<E> getIteratorByID(UniqueID elemID)
//	{
//		Iterator<E> iter = this.iterator();
//		E current;
//		
//		while (iter.hasNext())
//		{
//			current = iter.next();
//			if (current.equals(elemID))
//			{
//				return iter;
//			}
//		}
//		
//		return null;
//	}
	
}
