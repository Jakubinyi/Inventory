package inv;

import java.util.ArrayList;

public class StoreManager {
	
	private StoreCapable storage;
	
	public void addStorage(StoreCapable storage) {
		this.storage = storage;
	}
	
	public void addCDProduct(String name, int price, int tracks) {
		storage.storeCDProduct(name, price, tracks);
		
	}
	
	public void addBookProduct(String name, int price, int size) {
		storage.storeBookProduct(name, price, size);
	}
	
	public String listProducts() {
		ArrayList<Product> listToPrint = ((Store) storage).loadProducts();
		for(Product product : listToPrint) {
			System.out.println(product.getName() + " - " + product.getPrice());
		}
		return "\nProduct loaded \n";
	}
	
	public int getTotalProductPrice() {
		int totalPrice = 0;
		for(Product product : storage.getAllProduct()){
			totalPrice += product.getPrice();
		}
		return totalPrice;
	}
}
