package com.example.admin.pizzame.models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class YahooResponse{

	@SerializedName("query")
	private Query query;

	public void setQuery(Query query){
		this.query = query;
	}

	public Query getQuery(){
		return query;
	}

	@Override
 	public String toString(){
		return 
			"YahooResponse{" + 
			"query = '" + query + '\'' + 
			"}";
		}
}