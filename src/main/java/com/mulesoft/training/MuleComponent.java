package com.mulesoft.training;

import java.util.List;
import java.util.Map;

import org.mule.api.annotations.param.InboundHeaders;
import org.mule.api.annotations.param.Payload;

import java.util.HashMap;

public class MuleComponent {

	int count;
	
	public MuleComponent() {
		count =1;
	}
	
  public Map<String,String> processMap(Map<String, String> input) {
    
	  input.put("executed_by", "MuleComponent -> processMap");
	  return input;
  }

  public Map<String,String> processArray(List<String> input ) {
	  Map<String, String> map = new HashMap<>();
	  map.put( "message", input.get( 0 ));
	  map.put("executed_by", "MuleComponent -> processArray");
	  return map;
  }

  public Map<String,String> processString(String input ) {
    
	  Map<String, String> map = new HashMap<>();
	  map.put( "message", input);
	  map.put("executed_by", "MuleComponent -> processString");
	  return map;
	  
  }

  public Map<String,String> processAll(@Payload Object input,@InboundHeaders("http.method") String httpMethod ) {
	 
	  Map<String, String> map = new HashMap<>();
	  map.put( "message", input.toString() );
	  map.put("executed_by", "MuleComponent -> processAll");  
	  map.put("count",String.valueOf(count));
	  
	  count++;
	  
	  return map;
  }

} 
