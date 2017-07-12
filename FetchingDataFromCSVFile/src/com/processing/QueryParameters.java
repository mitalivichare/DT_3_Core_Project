package com.processing;

import java.io.FileNotFoundException;
import java.io.IOException;

public class QueryParameters 
{
	private String columnlist,filepath,criteria,groupcondition,sortcondition;
	Criteria criterialist=new Criteria();
	
	public QueryParameters(String columnlist,String filepath,String criteria)
	{
		this.columnlist=columnlist;
		this.filepath=filepath;
		this.criteria=criteria;
		
		this.groupcondition=groupcondition;
		this.sortcondition=sortcondition;

	}

	public String getColumnlist() {
		return columnlist;
	}

	public void setColumnlist(String columnlist) {
		this.columnlist = columnlist;
	}

	public String getFilename() {
		return filepath;
	}

	public void setFilename(String filepath) {
		this.filepath = filepath;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	
	public void processQuery() throws FileNotFoundException,IOException
	{
		
		
		CSVFileReader reader=new CSVFileReader(columnlist,filepath,criteria);
		reader.fetchAllData();
	}
	
	public void expressionProcessing(String criteria)
	{
		String operator[]={"<=",">=","==","!=","=","<",">"};
		for(String op:operator)
		{
			if(criteria.contains(op))
			{
				criterialist.setColumn(criteria.split(op)[0].trim());
				criterialist.setValue(criteria.split(op)[1].trim());
				criterialist.setOperator(op);
				break;
			}
		}
		System.out.println(criterialist.getColumn()+"\n"+criterialist.getOperator()+"\n"+criterialist.getValue());
	}
	

}
