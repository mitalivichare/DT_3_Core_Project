package com.processing;

import java.io.FileNotFoundException;
import java.io.IOException;

public class QueryParameters 
{
	private String columnlist,filepath,criteria,groupcondition,sortcondition;
	
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
	
	
	public String getGroupcondition() {
		return groupcondition;
	}

	public void setGroupcondition(String groupcondition) {
		this.groupcondition = groupcondition;
	}

	public String getSortcondition() {
		return sortcondition;
	}

	public void setSortcondition(String sortcondition) {
		this.sortcondition = sortcondition;
	}

	public void processQuery() throws FileNotFoundException,IOException
	{
		CSVFileReader reader=new CSVFileReader(columnlist,filepath,criteria);
		reader.fetchAllData();
	}
	

}
