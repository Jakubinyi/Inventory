package inv;

public class Main {

	public static void main(String[] args) {
		StoreManager storemanager = new StoreManager();
		StoreCapable store = new PersistentStore();
		storemanager.addStorage(store);
		storemanager.addCDProduct("Prodigy", 5, 12);
		storemanager.addBookProduct("Clean Code", 50, 464);
		
		System.out.println(storemanager.listProducts());
		System.out.println("Total price: " + storemanager.getTotalProductPrice());

	}

}
