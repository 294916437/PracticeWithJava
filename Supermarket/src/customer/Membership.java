package customer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.management.RuntimeErrorException;

import util.Setting;

public class Membership extends Information {
	private int memberpoint;
	public int getMemberpoint() {
		return memberpoint;
	}
	public Membership(String name, String pwd,int memberpoint) {
		super(name, pwd);
		this.memberpoint=0;
	}
	public Membership(String name, String salt,String pwd,int memberpoint) {
		super(name, salt,pwd);
		this.memberpoint=memberpoint;
	}
	public void addmemberpoint(double price) {
			if(price>=30) {
			this.memberpoint=this.memberpoint+(int)price;
			}
		}
	public void usememberpoint(int point) {
		this.memberpoint=this.memberpoint-point;
	}
	public String getdumpcontent() {
		String res=super.getdumpcontent();
		return res+" "+this.memberpoint;
	}
	
	}
	

