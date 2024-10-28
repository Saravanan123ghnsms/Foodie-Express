package com.food.modelclass;

public class OrdersItemsPojo {
    int orderitemid;
    int orderid;
    int menuid;
    int quantity;
    float subtotal;
	public OrdersItemsPojo() {
		super();
	}
	public OrdersItemsPojo(int orderitemid, int orderid, int menuid, int quantity, float subtotal) {
		super();
		this.orderitemid = orderitemid;
		this.orderid = orderid;
		this.menuid = menuid;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}
	public int getOrderitemid() {
		return orderitemid;
	}
	public void setOrderitemid(int orderitemid) {
		this.orderitemid = orderitemid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	@Override
	public String toString() {
		return "OrdersItems Info [orderitemid=" + orderitemid + ", orderid=" + orderid + ", menuid=" + menuid
				+ ", quantity=" + quantity + ", subtotal=" + subtotal + "]";
	}
    
}
