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
		splitedquery=query.split(" ");
	}
	
	public void extractQueryComponents()
	{
		for(int i=0;i<splitedquery.length;i++)
		{
			if(splitedquery[i].contains(".csv"))
			{
				filepath=splitedquery[i];
			}
			if(splitedquery[i].contains("where"))
			{
				criteria=splitedquery[i+1];
			}
			if(splitedquery[i].contains("group"))
			{
				groupcondition=splitedquery[i+2];
			}
			if(splitedquery[i].contains("order"))
			{
				sortcondition=splitedquery[i+2];
			}
			
		}
		reqcolumns=splitedquery[1];
		
		System.out.println(reqcolumns+"\n"+filepath+"\n"+criteria+"\n"+groupcondition+"\n"+sortcondition);
			QueryParameters queryParameters=new QueryParameters(reqcolumns,filepath,criteria);
			queryParameters.expressionProcessing(criteria);
			/*try
			{
			param.processQuery();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}*/
		
		
		
		
		
	}

}
