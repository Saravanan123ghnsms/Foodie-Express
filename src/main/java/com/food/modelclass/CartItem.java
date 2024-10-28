package com.food.modelclass;

public class CartItem {
    int itemid;
    int restaurantid;
    String name;
    int quantity;
    float price;
    float subtotal;
    String itemimage;
    
	public String getItemimage() {
		return itemimage;
	}
	public void setItemimage(String itemimage) {
		this.itemimage = itemimage;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getRestaurantid() {
		return restaurantid;
	}
	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	public CartItem(int itemid, int restaurantid, String name, int quantity, float price, float subtotal) {
		super();
		this.itemid = itemid;
		this.restaurantid = restaurantid;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.subtotal = subtotal;
	}
	
	public CartItem(int itemid, int restaurantid, String name, int quantity, float price, float subtotal,
			String itemimage) {
		super();
		this.itemid = itemid;
		this.restaurantid = restaurantid;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.subtotal = subtotal;
		this.itemimage = itemimage;
	}
	public CartItem() {
		super();
	}
	@Override
	public String toString() {
		return "CartItem [itemid=" + itemid + ", restaurantid=" + restaurantid + ", name=" + name + ", quantity="
				+ quantity + ", price=" + price + ", subtotal=" + subtotal + ", itemimage=" + itemimage + "]";
	}
	
    
}
