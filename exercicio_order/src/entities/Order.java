package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;
	
	private Client cliente;
	private List<OrderItem> pedidos = new ArrayList<>();
	
	public Order() {
	}
	
	public Order(Date moment, OrderStatus status, Client cliente) {
		this.moment = moment;
		this.status = status;
		this.cliente = cliente;
	}
	
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}

	public List<OrderItem> getPedidos() {
		return pedidos;
	}

	public void addItem(OrderItem item) {
		pedidos.add(item);
	}
	
	public void removeItem(OrderItem item) {
		pedidos.remove(item);
	}
	
	/* Return the total value of the order ...
	* Use for-each loop to navigate through the arraylist 'pedidos' from type OrderItem ... */
	public Double total() {
		Double sum = 0.0;
		for (OrderItem item : pedidos) {
			sum += item.subTotal();
		}
		return sum;
	}
	
	
}
