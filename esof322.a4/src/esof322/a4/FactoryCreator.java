package esof322.a4;

public class FactoryCreator {
	private int type; 
	
	public FactoryCreator(int type) {
		this.type = type; 
	}
	
	public CaveFactory createFactory() {
		if (type == 0) {
			return new Level0Factory(); 
		}
		else {
			return new Level1Factory(); 
		}
	}
}
