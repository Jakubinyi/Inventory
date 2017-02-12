package inv;

import java.util.ArrayList;

public abstract class Store implements StoreCapable{

	private void saveToXml(Product product) 
	{
		
	}
	
	protected void storeProduct(Product product) 
	{
		
	}
	
	protected Product createProduct(String type, String name, int price, int size)
	{
		return null;
	}
	
	public ArrayList<Product> loadProducts()
	{
		
	}
	
	public void store(Product product)
	{
		saveToXml(product);
		storeProduct(product);	  
	}
	
	protected abstract void storeProduct();
	
}
