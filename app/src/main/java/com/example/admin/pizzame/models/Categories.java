package com.example.admin.pizzame.models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Categories{

	@SerializedName("Category")
	private List<CategoryItem> category;

	public void setCategory(List<CategoryItem> category){
		this.category = category;
	}

	public List<CategoryItem> getCategory(){
		return category;
	}

	@Override
 	public String toString(){
		return 
			"Categories{" + 
			"category = '" + category + '\'' + 
			"}";
		}
}