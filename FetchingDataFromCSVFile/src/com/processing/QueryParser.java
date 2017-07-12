package com.processing;

import java.util.ArrayList;
import java.util.List;

public class QueryParser 
{
	public String query,splitedquery[],reqcolumns,filepath,criteria,groupcondition,sortcondition;
	List<QueryParameters> paramslist=new ArrayList<QueryParameters>();
	
	//method to convert query to an array
	public void splitQuery(String query)
	{
		System.out.println("Inside split method..");
		splitedquery=query.split(" ");
	}
	
	public void extractQueryComponents()
	{
		System.out.println("reached extracting query components....");
		for(int i=0;i<splitedquery.length;i++)
		{
			if(splitedquery[i].contains(".csv"))
			{
				System.out.println("Getting the file name...");
				filepath=splitedquery[i];
			}
			if(splitedquery[i].contains("where"))
			{
				System.out.println("Getting the condition...");
				criteria=splitedquery[i+1];
			}
			if(splitedquery[i].contains("group"))
			{
				System.out.println("Getting the grouping condition...");
				groupcondition=splitedquery[i+2];
			}
			if(splitedquery[i].contains("order"))
			{
				System.out.println("Getting the sorting condition...");
				sortcondition=splitedquery[i+2];
			}
			
		}
		reqcolumns=splitedquery[1];
		
		System.out.println(reqcolumns+"\n"+filepath+"\n"+criteria+"\n"+groupcondition+"\n"+sortcondition);
			QueryParameters param=new QueryParameters(reqcolumns,filepath,criteria);
			try
			{
			param.processQuery();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
		
		
		
		
	}

}
