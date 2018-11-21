package com.org.restapi.testutils;

public class TestUtils {

	
	public static boolean verifyTitle(String _Response, String _Title){
		
   		if(_Response.contains(_Title)) {
   			return true;
   		}
		
		return false;
		
	}
	
	
public static boolean verifyName(String _Response, String _Name){
		
   		if(_Response.contains(_Name)) {
   			return true;
   		}
		
		return false;
		
	}
}
