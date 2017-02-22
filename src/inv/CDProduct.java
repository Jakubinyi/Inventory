package inv;

public class CDProduct extends Product{
	
	private int numOfTracks;

	public CDProduct(String name, Integer Price, int numOfTracks) {
		super(name, Price);
		this.setNumOfTracks(numOfTracks);
	}

	public int getNumOfTracks() {
		return numOfTracks;
	}

	public void setNumOfTracks(int numOfTracks) {
		this.numOfTracks = numOfTracks;
	}

}
