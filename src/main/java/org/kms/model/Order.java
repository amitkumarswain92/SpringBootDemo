package org.kms.model;

public class Order {
	
	private int ets_ord_no;
	private String order_status_code;
	private String order_type;
	private double order_amout;
	private int ets_pymt_no;
	public int getEts_ord_no() {
		return ets_ord_no;
	}
	public Order(int ets_ord_no, String order_status_code, String order_type, double order_amout,
			int ets_pymt_no) {
		this.ets_ord_no = ets_ord_no;
		this.order_status_code = order_status_code;
		this.order_type = order_type;
		this.order_amout = order_amout;
		this.ets_pymt_no = ets_pymt_no;
	}
	
	public Order(String order_status_code, String order_type, double order_amout
			) {
		this.order_status_code = order_status_code;
		this.order_type = order_type;
		this.order_amout = order_amout;
	}
	public void setEts_ord_no(int ets_ord_no) {
		this.ets_ord_no = ets_ord_no;
	}
	public String getOrder_status_code() {
		return order_status_code;
	}
	public void setOrder_status_code(String order_status_code) {
		this.order_status_code = order_status_code;
	}
	public String getOrder_type() {
		return order_type;
	}
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
	public double getOrder_amout() {
		return order_amout;
	}
	public void setOrder_amout(double order_amout) {
		this.order_amout = order_amout;
	}
	public int getEts_pymt_no() {
		return ets_pymt_no;
	}
	public void setEts_pymt_no(int ets_pymt_no) {
		this.ets_pymt_no = ets_pymt_no;
	}
	public Order() {
		super();
	}
}
