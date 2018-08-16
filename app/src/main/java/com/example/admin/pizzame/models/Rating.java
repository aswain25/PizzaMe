package com.example.admin.pizzame.models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Rating{

	@SerializedName("TotalRatings")
	private String totalRatings;

	@SerializedName("AverageRating")
	private String averageRating;

	@SerializedName("TotalReviews")
	private String totalReviews;

	@SerializedName("LastReviewIntro")
	private String lastReviewIntro;

	@SerializedName("LastReviewDate")
	private String lastReviewDate;

	public void setTotalRatings(String totalRatings){
		this.totalRatings = totalRatings;
	}

	public String getTotalRatings(){
		return totalRatings;
	}

	public void setAverageRating(String averageRating){
		this.averageRating = averageRating;
	}

	public String getAverageRating(){
		return averageRating;
	}

	public void setTotalReviews(String totalReviews){
		this.totalReviews = totalReviews;
	}

	public String getTotalReviews(){
		return totalReviews;
	}

	public void setLastReviewIntro(String lastReviewIntro){
		this.lastReviewIntro = lastReviewIntro;
	}

	public String getLastReviewIntro(){
		return lastReviewIntro;
	}

	public void setLastReviewDate(String lastReviewDate){
		this.lastReviewDate = lastReviewDate;
	}

	public String getLastReviewDate(){
		return lastReviewDate;
	}

	@Override
 	public String toString(){
		return 
			"Rating{" + 
			"totalRatings = '" + totalRatings + '\'' + 
			",averageRating = '" + averageRating + '\'' + 
			",totalReviews = '" + totalReviews + '\'' + 
			",lastReviewIntro = '" + lastReviewIntro + '\'' + 
			",lastReviewDate = '" + lastReviewDate + '\'' + 
			"}";
		}
}