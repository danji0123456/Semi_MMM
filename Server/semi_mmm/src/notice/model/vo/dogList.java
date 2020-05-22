package notice.model.vo;

import java.util.ArrayList;

import dog.model.vo.Dog;

public class dogList {

	private ArrayList<Dog> dogList;

	public dogList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public dogList(ArrayList<Dog> dogList) {
		super();
		this.dogList = dogList;
	}

	public ArrayList<Dog> getDogList() {
		return dogList;
	}

	public void setDogList(ArrayList<Dog> dogList) {
		this.dogList = dogList;
	}


	
}
