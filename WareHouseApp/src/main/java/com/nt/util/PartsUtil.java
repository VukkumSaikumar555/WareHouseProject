package com.nt.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PartsUtil {
	
	public static Map<Integer,String> convertToMap(List<Object[]> list){
		Map<Integer,String> map=new HashMap();
		for(Object[] ob:list) {
			         map.put(Integer.valueOf(ob[0].toString()),ob[1].toString());
		}
		return map;
		
	}

}
