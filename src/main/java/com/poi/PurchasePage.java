package com.poi;

import java.util.HashMap;
import java.util.Map.Entry;

public class PurchasePage {
	
	public static void main(String[] args) {
		
		String s =" mom  dad dad dad children mom";
		int max=0;
		String []a=s.split(" ");
		
		HashMap<String,Integer>hm=new HashMap<>();
		
		for(int i=0;i<a.length;i++)
		{
			String rev="";
			String main=a[i];
			
			for(int j=0;j<main.length();j++)
			{
				rev=main.charAt(j)+rev;
				
			}
			if(a[i].equals(rev))
			{
				System.out.println("the palidromes are :"+a[i]);
				
				if(!hm.containsKey(a[i]))
				{
					hm.put(a[i], 1);
				}
				else
				{
					int value=hm.get(a[i]);
					hm.put(a[i], value+1);
					
					if(value+1>max)
						max=value;
				}
			}
		}
		for(Entry<String,Integer> e:hm.entrySet())
	if(e.getValue()==max)
	{
		System.out.println(e.getKey());
	}
		
		}
	}

		