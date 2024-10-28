package com.food.modelclass;

public class RestaurantPojo {
    int restaurantid;
	String restaurantname, cuisinetype;
	int deliverytime;
	boolean isActive;
	int rating;
	String imagepath;

	public RestaurantPojo(int restaurantid,String restaurantname, String cuisinetype, int deliverytime, boolean isActive, int rating,
			String imagepath) {
		super();
        this.restaurantid=restaurantid;
		this.restaurantname = restaurantname;
		this.cuisinetype = cuisinetype;
		this.deliverytime = deliverytime;
		this.isActive = isActive;
		this.rating = rating;
		this.imagepath = imagepath;
	}

	public RestaurantPojo() {
		super();
	}

	public String getRestaurantname() {
		return restaurantname;
	}

	public void setRestaurantname(String restaurantname) {
		this.restaurantname = restaurantname;
	}

	public String getCuisinetype() {
		return cuisinetype;
	}

	public void setCuisinetype(String cuisinetype) {
		this.cuisinetype = cuisinetype;
	}

	public int getDeliverytime() {
		return deliverytime;
	}

	public void setDeliverytime(int deliverytime) {
		this.deliverytime = deliverytime;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	

	public int getRestaurantid() {
		return restaurantid;
	}

	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}

	@Override
	public String toString() {
		return "RestaurantPojo Information [restaurantid=" + restaurantid + ", restaurantname=" + restaurantname + ", cuisinetype="
				+ cuisinetype + ", deliverytime=" + deliverytime + ", isActive=" + isActive + ", rating=" + rating
				+ ", imagepath=" + imagepath + "]";
	}

	


}
