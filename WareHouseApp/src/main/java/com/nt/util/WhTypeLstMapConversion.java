package com.nt.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface WhTypeLstMapConversion {
	
	public static Map<Integer,String> convertToMap(List<Object[]> lst){
		Map<Integer,String> maps=new HashMap();
		for(Object[] ob:lst) {
			maps.put(Integer.valueOf(ob[0].toString()), ob[1].toString());
		}
		return maps;
		
	}

}
