package inv;

import java.util.ArrayList;
import java.util.List;

public class PersistentStore extends Store{
	
	private List<Product> products = new ArrayList<Product>();
	
	@Override
	public void storeProduct(Product product) {
		products.add(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return super.loadProducts();
	}

	@Override
	public void storeCDProduct(String name, int price, int tracks) {	
			super.store(new CDProduct(name, price, tracks));
	}

	@Override
	public void storeBookProduct(String name, int price, int size) {
		super.store(new BookProduct(name, price, size));
	}

}
