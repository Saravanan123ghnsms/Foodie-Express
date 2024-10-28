package com.food.modelclass;

public class MenuPojo {
     int menuid;
     int restaurant_id;
     String itemname;
     String description;
     float price;
     boolean isActive;
     String imagepath;
     
	public MenuPojo() {
		super();
	}
	public MenuPojo( int restaurant_id, String itemname, String description, float price, boolean isActive,
			String imagepath) {
		super();
		
		this.restaurant_id = restaurant_id;
		this.itemname = itemname;
		this.description = description;
		this.price = price;
		this.isActive = isActive;
		this.imagepath = imagepath;
	}
	
	
	public MenuPojo(int menuid, int restaurant_id, String itemname, String description, float price, boolean isActive,
			String imagepath) {
		super();
		this.menuid = menuid;
		this.restaurant_id = restaurant_id;
		this.itemname = itemname;
		this.description = description;
		this.price = price;
		this.isActive = isActive;
		this.imagepath = imagepath;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	@Override
	public String toString() {
		return "MenuPojo [menuid=" + menuid + ", restaurant_id=" + restaurant_id + ", itemname=" + itemname
				+ ", description=" + description + ", price=" + price + ", isActive=" + isActive + ", imagepath="
				+ imagepath + "]";
	}

     
   
}
