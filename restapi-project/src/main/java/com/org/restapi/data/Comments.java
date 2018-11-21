package com.org.restapi.data;

public class Comments {

	
  String name;
   String title;
   String body;
   String email;
   String id;
	
   
   public Comments(String name, String title, String body, String email, String id)
   {
	  this.name=name; 
	  this.title=title; 
	  this.body=body;
	  this.email=email; 
	  this.id=id;
   }


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public String getBody() {
	return body;
}


public void setBody(String body) {
	this.body = body;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}
   
	
}
