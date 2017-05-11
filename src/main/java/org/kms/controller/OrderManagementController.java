package org.kms.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.kms.model.Order;
import org.kms.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class OrderManagementController {
	@Autowired
	OrdersService service;
	@ApiOperation(value = "ETS sanityTest", nickname = "sanityTest")
	@ApiResponses(
			@ApiResponse(code = 200, message = "Success", response = String.class)		
				)
	@RequestMapping("/OrderModuleSanityTest")
	public String OrdersModuleTest(){
		return "Orders module is working fine";
	}
	@ApiOperation(value = "getOrdersList()", nickname = "ordersList")
	@ApiResponses(
			@ApiResponse(code = 200, message = "Success", response = Order.class)		
				)
	@RequestMapping("/OrdersList")
	public List<Order> getOrdersList(){
		
	return service.getOrderList();
	
	}
	@ApiOperation(value = "addNewOrder()", nickname = "createOrder")
	@ApiResponses(
			@ApiResponse(code = 200, message = "Success", response = Integer.class)		
				)
	@RequestMapping(method=RequestMethod.POST, value="/OrdersList")
	public Object addNewOrder(@RequestBody Order order){
		Order ord=service.addOrder(order);
		if(null!=ord){
			return Response.ok(new Integer(ord.getEts_ord_no()),MediaType.APPLICATION_JSON).build().getEntity();
		}else{
			return Response.notModified("Order creation Failed").build();
		}
		
	}
	@ApiOperation(value = "updateOrder()", nickname = "modifyOrder")
	@ApiResponses(
			@ApiResponse(code = 200, message = "Success", response = Object.class)	
				)
	@RequestMapping(method=RequestMethod.PUT, value="/OrdersList/{id}")
	public Object updateOrder(@RequestBody Order order, @PathVariable int id){
		Order od=service.updateOrder(order, id);
		if(null!=od){
			return Response.ok(od,MediaType.APPLICATION_JSON_TYPE).build().getEntity();
		}
		else{
			return Response.notModified("Order updation Failed").build();
		}
	}
	@ApiOperation(value = "getOrderDetails()", nickname = "getOrderWithID")
	@ApiResponses(
			@ApiResponse(code = 200, message = "Success", response = Object.class)	
				)
	@RequestMapping(method=RequestMethod.GET, value="/OrdersList/{id}")
	public Object getOrderDetails(@PathVariable int id){
		Order order= service.getOrder(id);
		if(null!=order){
			return Response.ok(order,MediaType.APPLICATION_JSON_TYPE).build().getEntity();
		}else{
			return Response.noContent().build().getEntity();
		}
	}
	@ApiOperation(value = "deleteOrder()", nickname = "deleteOrder")
	@ApiResponses(
			@ApiResponse(code = 200, message = "Success", response = Object.class)	
				)
	@RequestMapping(method=RequestMethod.DELETE, value="/OrdersList/{id}")
	public Object deleteOrder(@PathVariable int id){
		int deleteStatus=service.deleteOrder(id);
		if(deleteStatus!=0){
			return Response.ok(new String("Order Deleted Successfully. Order No Deleted::")+deleteStatus).build().getEntity();
		}else{
			return Response.noContent().build().getEntity();
		}
	}

}
