package com.food.modelclass;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	 Map<Integer, CartItem> items = new HashMap<Integer, CartItem>();
	  
	 //adding the item to the cart
	 public void addItem(CartItem e)
	 {
		 //collecting itemid or menuid from the cartitem object
		 int itemid = e.getItemid();
		 if(items.containsKey(itemid))
		 {
			 //if it already exists in map gettng cartitem object from map using itemid
			 //modify it quantity by given object
			 CartItem existingItem = items.get(itemid);
			 existingItem.setQuantity(existingItem.getQuantity()+e.getQuantity());
		 }
		 else {
			 //else puting item id and cartitem object
			items.put(itemid,e);
		}
	 }
	 //updating the quantity of a menuitem
	 public void updateItem(int itemid,int quantity)
	 {
		 if(items.containsKey(itemid))
		 {
			 if(quantity<=0)
			 {
				 items.remove(itemid);
			 }
			 else {
				items.get(itemid).setQuantity(quantity);
				items.get(itemid).setSubtotal(quantity* items.get(itemid).getPrice());
			}
		 }
		 
	 }
	 //Remove an item from the cart
	 public void removeItem(int itemid)
	 {
		 items.remove(itemid);
	 }
	 //To retrieve list of menuitems 
	 public Map<Integer,CartItem> getItems() 
	 {
		 return items;
	 }
	 //To clear the cart
	 public void clearCart()
	 {
		 items.clear();
	 }
}
