package com.example.admin.pizzame.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Results{

	@SerializedName("Result")
	private List<ResultItem> result;

	public void setResult(List<ResultItem> result){
		this.result = result;
	}

	public List<ResultItem> getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"Results{" + 
			"result = '" + result + '\'' + 
			"}";
		}
}