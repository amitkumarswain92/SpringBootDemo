package org.kms.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.kms.model.Order;
import org.springframework.stereotype.Service;
@Service
public class OrdersService {
	
	private static int orderNo=1;
	private static int paymentNo=2999;
	private List <Order> orderList= new ArrayList<Order>(Arrays.asList(
			new Order(orderNo, "OR", "T", 245.50, paymentNo)));
	
		
	public List <Order> getOrderList(){
			
			return orderList;
	}
	
	public Order addOrder(Order order){
		
		if(!checkOrderAlreadyExists(order))
			{
			if(order.getEts_ord_no()==0)
			{
				order.setEts_ord_no(orderList.size()+1);
			}
			if(order.getEts_pymt_no()==0)
			{
				order.setEts_pymt_no(orderList.size()+3000);
			}
			
				orderList.add(order);
				return order;
			}else{
				return null;
			}
	}
	
	public Order updateOrder(Order order, int id){
		int index=0;
		for (Order orderElement : orderList) {
			
			if(orderElement.getEts_ord_no()==id){
				if(null!=order.getOrder_type())orderList.get(index).setOrder_type(order.getOrder_type());
				if(null!=order.getOrder_status_code())orderList.get(index).setOrder_status_code(order.getOrder_status_code());
				if(0!=order.getOrder_amout())orderList.get(index).setOrder_amout(order.getOrder_amout());
				return orderList.get(index);
			}
			index++;
		} 
		return null;
	}
	public boolean checkOrderAlreadyExists(Order order){
		for(Order ord:orderList){
			if(ord.getEts_ord_no()==order.getEts_ord_no()|| ord.getEts_pymt_no()==order.getEts_pymt_no()){
				return true;
			}
		}
		return false;
		
	}
	
	public Order getOrder(int id){
		for(Order ord:orderList){
			if(ord.getEts_ord_no()==id){
				return ord;
			}
		}
		
		return null;
	}
	
	public int deleteOrder(int id){
		int index=0;
		for (Order orderElement : orderList) {
			
			if(orderElement.getEts_ord_no()==id){
				orderList.remove(index);
				return id;
			}
			index++;
		} 
		
		return 0;
	}


}
