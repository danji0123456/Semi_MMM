package dog.model.vo;

public class Dog {
	private String dogId;
	private String dogMemberId;
	private String variety;
	private int age;
	private String dogGender;
	private String dogImg;
	private int dogBool;
	private String dogName;
	
	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Dog(String dogId, String dogMemberId, String variety, int age, String dogGender, String dogImg, int dogBool,
			String dogName) {
		super();
		this.dogId = dogId;
		this.dogMemberId = dogMemberId;
		this.variety = variety;
		this.age = age;
		this.dogGender = dogGender;
		this.dogImg = dogImg;
		this.dogBool = dogBool;
		this.dogName = dogName;
	}

	public String getDogId() {
		return dogId;
	}
	public void setDogId(String dogId) {
		this.dogId = dogId;
	}
	public String getDogMemberId() {
		return dogMemberId;
	}
	public void setDogMemberId(String dogMemberId) {
		this.dogMemberId = dogMemberId;
	}
	public String getDogName() {
		return dogName;
	}
	public void setDogName(String dogName) {
		this.dogName = dogName;
	}
	public String getVariety() {
		return variety;
	}
	public void setVariety(String variety) {
		this.variety = variety;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDogGender() {
		return dogGender;
	}
	public void setDogGender(String dogGender) {
		this.dogGender = dogGender;
	}
	public String getDogImg() {
		return dogImg;
	}
	public void setDogImg(String dogImg) {
		this.dogImg = dogImg;
	}
	public int getDogBool() {
		return dogBool;
	}
	public void setDogBool(int dogBool) {
		this.dogBool = dogBool;
	}
	
}
