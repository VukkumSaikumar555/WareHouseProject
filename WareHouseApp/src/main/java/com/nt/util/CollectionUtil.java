package com.nt.util;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface CollectionUtil {
	
      public static Map<Integer,String> convertToMap(List<Object[]> list){
    	  Map<Integer,String> map=new LinkedHashMap();
    	  for(Object[] ob:list) {
    		  
    		  map.put(Integer.valueOf(ob[0].toString()), ob[1].toString());
    	  }
		return map;
    	  
      }
 
}
