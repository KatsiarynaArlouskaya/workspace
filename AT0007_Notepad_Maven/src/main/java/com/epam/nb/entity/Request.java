package com.epam.nb.entity;

import java.util.HashMap;
import java.util.Map;

public class Request {
	private Map<RequestParam, Object> parametrs =new HashMap<>();
	
	public void setParam(RequestParam paramKey, Object value){
		parametrs.put(paramKey, value);
	}
	
	public Object getParam(RequestParam paramKey) {
		return parametrs.get(paramKey);
	}
}
