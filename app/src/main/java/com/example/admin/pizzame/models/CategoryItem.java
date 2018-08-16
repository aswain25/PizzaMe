package com.example.admin.pizzame.models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class CategoryItem{

	@SerializedName("id")
	private String id;

	@SerializedName("content")
	private String content;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return content;
	}

	@Override
 	public String toString(){
		return 
			"CategoryItem{" + 
			"id = '" + id + '\'' + 
			",content = '" + content + '\'' + 
			"}";
		}
}