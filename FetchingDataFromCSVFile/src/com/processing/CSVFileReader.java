package com.processing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CSVFileReader 
{
	
	static String reqcolumns,filepath,criteria;
	static String value,finaldata[],alldata[],rowarray[],conditions[],hdr,headerdata[];
	static Map<String,Integer> header=new HashMap<String, Integer>();
    static Map<Integer,String> rowdata=new TreeMap<>();
	
	
	public CSVFileReader(String reqcolumns,String filepath,String criteria)
	{
		this.reqcolumns=reqcolumns;
		this.filepath=filepath;
		this.criteria=criteria;
		System.out.println(this.filepath);
		try
		{
		fetchAllData();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		getheadernames();
		displayheadernames();
        getrowdata();
        displayrowdata();
        setcolumndata();
		
	}
	
	public static void fetchAllData() throws FileNotFoundException,IOException
	{
		FileReader file=new FileReader("d:\\"+filepath);
		BufferedReader br=new BufferedReader(file);
		List<String> data=new ArrayList<String>();
		
		while((value=br.readLine())!=null)
		{
			data.add(value);
		}
		String [] dataarray=data.toArray(new String[0]);
		
		finaldata=Arrays.copyOf(dataarray, dataarray.length-1);
		System.out.println("no. of elements : "+finaldata.length);
        for(String p:finaldata)
            {
            System.out.println(p);
            }
		
	}
	
	public static Map<String,Integer> getheadernames()
    {
        
            hdr=finaldata[0];
        headerdata=hdr.split(",");
        
        for(int i=0;i<headerdata.length;i++)
        {
            header.put(headerdata[i], i);
        }
        return header;
    }
	
	public static void displayheadernames()
    {
        System.out.println(header);
    }
    
     public static Map<Integer,String> getrowdata()
    {
        rowarray=Arrays.copyOfRange(finaldata, 1, finaldata.length);
        for(int i=0;i<rowarray.length;i++)
        {
            rowdata.put(i+1,rowarray[i]);
        }
        return rowdata;
    }
     
     public static void displayrowdata()
     {
     
         System.out.println(rowdata);
         
     }
     
     public static void setcolumndata()
     {
    	    
         int position;
         conditions=reqcolumns.split(",");
         System.out.println(conditions.length);
        
         
         Set entrySet = header.entrySet();
 
    Iterator it = entrySet.iterator();
 
    System.out.println("HashMap Key-Value Pairs : ");
    while(it.hasNext())
    {
        for(int i=0;i<conditions.length;i++)
        {
           Map.Entry me = (Map.Entry)it.next();
          
          String value=(String) me.getKey();
        if(value.contains(conditions[i]))
        {
            position=(int) me.getValue();
            
            for(int s=0;s<rowarray.length;s++)
            {
                String[] temp=rowarray[s].split(",");
                System.out.println(temp[position]);
                
            }
            
        }
        
       }
	
	
	/*String line;
	public void readCSV(String filename) throws FileNotFoundException,IOException
	{
		BufferedReader br=null;
		try
		{
			br=new BufferedReader(new FileReader(filename));
			while((line=br.readLine())!=null)
			{
				String dataline[]=line.split(",");
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	
	}
*/
    }
     }
     }
