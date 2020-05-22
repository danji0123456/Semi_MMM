package admin.model.vo;

import java.util.ArrayList;

import dog.model.vo.Dog;
import member.model.vo.Member;

public class AdminMemberData {

	Member member;
	ArrayList<Dog> dogs;

	public AdminMemberData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminMemberData(Member member, ArrayList<Dog> dogs) {
		super();
		this.member = member;
		this.dogs = dogs;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public ArrayList<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(ArrayList<Dog> dogs) {
		this.dogs = dogs;
	}

}
