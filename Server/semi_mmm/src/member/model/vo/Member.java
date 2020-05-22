package member.model.vo;

import java.sql.Date;

public class Member {
	private String memberId;
	private String memberPw;
	private String memberNickname;
	private String memberName;
	private Date memberBirth;
	private String phone;
	private String addr;
	private Date enrollDate;
	private int memberLevel;
	private String profileImg;
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(String memberId, String memberPw, String memberNickname, String memberName, Date memberBirth,
			String phone, String addr, Date enrollDate, int memberLevel, String profileImg) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberNickname = memberNickname;
		this.memberName = memberName;
		this.memberBirth = memberBirth;
		this.phone = phone;
		this.addr = addr;
		this.enrollDate = enrollDate;
		this.memberLevel = memberLevel;
		this.profileImg = profileImg;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Date getMemberBirth() {
		return memberBirth;
	}
	public void setMemberBirth(Date memberBirth) {
		this.memberBirth = memberBirth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String getSpaceAddr() {
		return addr.replaceAll("/", " ");
	}
	
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public int getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(int memberLevel) {
		this.memberLevel = memberLevel;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	
}
