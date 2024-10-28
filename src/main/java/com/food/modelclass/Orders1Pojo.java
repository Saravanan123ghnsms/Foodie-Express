package com.food.modelclass;

public class Orders1Pojo {
    int orderid;
    int userid;
    int restaurantid;
    float totalamount;
    String dateandtime;
    String status;
    String paymentoptions;
	public Orders1Pojo() {
		super();
	}
	public Orders1Pojo(int orderid, int userid, int restaurantid, float totalamount,String status,
			String dateandtime,String paymentoptions) {
		super();
		this.orderid = orderid;
		this.userid = userid;
		this.restaurantid = restaurantid;
		this.totalamount = totalamount;
		this.status = status;
		this.dateandtime=dateandtime;
		this.paymentoptions = paymentoptions;
	}
	public String getDateandtime() {
		return dateandtime;
	}
	public void setDateandtime(String dateandtime) {
		this.dateandtime = dateandtime;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getRestaurantid() {
		return restaurantid;
	}
	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}
	public float getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(float totalamount) {
		this.totalamount = totalamount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentoptions() {
		return paymentoptions;
	}
	public void setPaymentoptions(String paymentoptions) {
		this.paymentoptions = paymentoptions;
	}
	@Override
	public String toString() {
		return "Orders1 Info [orderid=" + orderid + ", userid=" + userid + ", restaurantid=" + restaurantid
				+ ", totalamount=" + totalamount + ", dateandtime=" + dateandtime + ", status=" + status
				+ ", paymentoptions=" + paymentoptions + "]";
	}
	
    
}
