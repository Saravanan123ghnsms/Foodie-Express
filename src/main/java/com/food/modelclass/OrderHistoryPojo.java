package com.food.modelclass;

public class OrderHistoryPojo {
    int historyid;
    int user_id;
    int orderid;
    String dateandtime;
    float totalamount;
    String status;
	public OrderHistoryPojo() {
		super();
	}
	public OrderHistoryPojo(int historyid, int user_id, int orderid, String dateandtime, int totalamount,String status) {
		super();
		this.historyid = historyid;
		this.user_id = user_id;
		this.orderid = orderid;
		this.dateandtime = dateandtime;
		this.totalamount = totalamount;
		this.status=status;
	}
	public int getHistoryid() {
		return historyid;
	}
	public void setHistoryid(int historyid) {
		this.historyid = historyid;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getDateandtime() {
		return dateandtime;
	}
	public void setDateandtime(String dateandtime) {
		this.dateandtime = dateandtime;
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
	@Override
	public String toString() {
		return "OrderHistory Info [historyid=" + historyid + ", user_id=" + user_id + ", orderid=" + orderid
				+ ", dateandtime=" + dateandtime + ", totalamount=" + totalamount + ", status=" +status +"]";
	}
    
}
