package admin.model.vo;

import fna.model.vo.Fna;

public class AdminFnaData {

	Fna fna;
	int rnum;

	public AdminFnaData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminFnaData(Fna fna, int rnum) {
		super();
		this.fna = fna;
		this.rnum = rnum;
	}

	public Fna getFna() {
		return fna;
	}

	public void setFna(Fna fna) {
		this.fna = fna;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

}
