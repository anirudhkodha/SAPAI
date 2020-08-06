package com.MyTests;

import java.util.HashSet;

import org.testng.annotations.Test;

public class Set {
	
	@Test
	public void Hashset()
	{
		HashSet<String> hs = new HashSet<String>();
		hs.add("INDIA");
		hs.add("UK");
		hs.add("India");
		System.out.println(hs);
		
		
	}

}
