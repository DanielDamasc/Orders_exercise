package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		
		/* Client data ... */
		System.out.println("Enter cliente data: ");
		
		System.out.print("Name: ");
		String nomeCliente = sc.nextLine();
		System.out.print("Email: ");
		String emailCliente = sc.nextLine();
		System.out.print("Birth Date (DD/MM/YYYY): ");
		Date birthDateCliente = sdf1.parse(sc.nextLine());
		
		Client cliente = new Client(nomeCliente, emailCliente, birthDateCliente);
		
		/* Order data ... */
		System.out.println("Enter order data: ");
		
		System.out.print("Status: ");
		String status = sc.nextLine();
		
		Order order = new Order(new Date(), OrderStatus.valueOf(status), cliente);
		
		/* Number of items of the order ... */
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		sc.nextLine();
		
		/* Navigate each Order items ... */
		for (int i=1; i<=n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String nomeProduto = sc.nextLine();
			System.out.print("Product price: ");
			double precoProduto = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			sc.nextLine();
			
			OrderItem orderitem = new OrderItem(quantity, precoProduto, new Product(nomeProduto, precoProduto));
			/* Add an object of 'OrderItem' to the list of orders of a determinate order ... */
			order.addItem(orderitem);
		}
		
		/* Output ... */
		System.out.println();
		
		System.out.println("ORDER SUMMARY: ");
		System.out.println("Order moment: " + sdf1.format(order.getMoment()));
		System.out.println("Order status: " + order.getStatus());
		System.out.println("Client: " + cliente.getName() 
		+ " (" + sdf1.format(cliente.getBirthDate()) + ") " + "- " + cliente.getEmail());
		System.out.println("Order items:");
		
		/* for-each to navigate through the list getting the data ... */
		for (OrderItem item : order.getPedidos()) {
			System.out.println(item.getProduct().getName() + ", $" + item.getPrice() 
			+ ", Quantity: " + item.getQuantity() + ", Subtotal: $" 
					+ String.format("%.2f", item.subTotal()));
		}
		
		Double total = order.total();
		System.out.println("Total price: $" + String.format("%.2f", total));
		
		sc.close();

	}

}
