package esof322.a4;

public class Level0Factory extends CaveFactory{

	@Override
	public Room createRoomType1(String s) {
		// TODO Auto-generated method stub
		return new Level0Room(s);
	}

	@Override
	public Room createRoomType2(String s) {
		// TODO Auto-generated method stub
		return new Level0Room(s);
	}

}
