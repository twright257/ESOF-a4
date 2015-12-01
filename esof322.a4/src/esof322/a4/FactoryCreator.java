package esof322.a4;

/**
 * Tyler Wright 
 * Nov. 30, 2015
 * FactoryCreator returns different level factories depending on input 
 */

public class FactoryCreator {
	private int type;
	
	public FactoryCreator(int type) {
		this.type = type; 
	}
	
	//create concrete factory and return 
	public CaveFactory createFactory() {
		if (type == 0) {
			return new Level0Factory(); 
		}
		else {
			return new Level1Factory(); 
		}
	}
}
