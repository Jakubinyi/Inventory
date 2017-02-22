package inv;

public class BookProduct extends Product{
	
	private int pageSize;

	public BookProduct(String name, Integer Price, int pageSize) {
		super(name, Price);
		this.setPageSize(pageSize);
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
