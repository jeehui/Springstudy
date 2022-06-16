package com.goodee.ex01.java05;

public class Gun {
	
	//constructor
	 public Gun() {  // default constructor는 setter injection에서 사용됨.
			
		}
	public Gun(String model, int bullet) {
		super();
		this.model = model;
		this.bullet = bullet;
	}
	//field
	private String model; //총기모델
	private int bullet; //총알수
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getBullet() {
		return bullet;
	}
	public void setBullet(int bullet) {
		this.bullet = bullet;
	}
	
	
	
}
