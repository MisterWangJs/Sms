package com.djg.sms.domain;

public class Student {
	private int sno;
	private String name;
	private String myclass;
	private double score;

	public Student() {
		super();
	}

	public Student(int sno, String name, String myclass, double score) {
		super();
		this.sno = sno;
		this.name = name;
		this.myclass = myclass;
		this.score = score;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMyclass() {
		return myclass;
	}

	public void setMyclass(String myclass) {
		this.myclass = myclass;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", name=" + name + ", myclass=" + myclass + ", score=" + score + "]";
	}

}
