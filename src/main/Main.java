package main;

import dao.*;
import services.*;
import java.sql.*;
import java.util.*;
import java.util.Map.Entry;

import org.json.*;

public class Main 
{
	ResultSet resultSet=null;
	TestDAO testDAO = new TestDAO();
	
	public List<JSONObject> getJsonObject()
	{
		resultSet = testDAO.getResultSet();
		List<JSONObject> resList = JsonServices.getFormattedResult(resultSet);
		return resList;
	}
	
	public JSONArray getJsonArray() throws Exception {
		resultSet = testDAO.getResultSet();
        JSONArray jsonArray = new JSONArray();
        
        while (resultSet.next()) {
            int total_rows = resultSet.getMetaData().getColumnCount();
            JSONObject obj = new JSONObject();
            for (int i = 0; i < total_rows; i++) {
                obj.put(resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase(), resultSet.getObject(i + 1));
            }
          jsonArray.put(obj);
        }
        return jsonArray;
    }

	
	
	public static String main(String args[]) throws Exception
	{
		Main m = new Main();
		List<JSONObject> jObj = m.getJsonObject();
		JSONArray jArr = m.getJsonArray();
		
		Map<String,JSONArray> map=new HashMap<>();

		 for(int i=0;i<jArr.length();i++)
		 {
       	  JSONObject object=(JSONObject)jArr.get(i);
       	  
       	  for(Iterator<String> it=object.keys();it.hasNext();)
       	  {
       	    String key=it.next();
       	    if(!map.containsKey(key))
       	    {//This initializes the array on first element
       	      map.put(key, new JSONArray());
       	    }
       	    //fetches the array corresponding to the member's name from the map
       	    JSONArray array=map.get(key);
       	    //put the member's value into the array
       	    array.put(object.get(key));
       	  }
       	}
		 
		 //Set<Entry<String,JSONArray>> entries = map.entrySet();
		 JSONArray jsonArray = new JSONArray();
		 
		 for (Map.Entry<String, JSONArray> entry : map.entrySet())
		 {
			 JSONObject name = new JSONObject();
			 //JSONObject data = new JSONObject();
	
			 name.put("data", entry.getValue());
			 name.put("name", entry.getKey());
			 
			 jsonArray.put(name);
			 //jsonArray.put(data);
		 }
		System.out.println(jsonArray.toString());
		return jsonArray.toString();
	}
}
