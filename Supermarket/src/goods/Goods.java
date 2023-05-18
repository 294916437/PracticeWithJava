package goods;

import util.OutOfDateException;

public class Goods {

	private String name;
	private double price;
	private int account;
	private String desc;
	public Goods(String name,double price,int account){
		this.name=name;
		this.price=price;
		this.account=account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public int getamount() {
		return account;
	}
	public String getname() {
		return name;
	}
	public double getprice() {
		return price;
	}
	public String getdesc() {
		return desc;
	}
	public void setdesc(String desc) {
		this.desc=desc;
	}
	public String toString(){
		return this.name+"\t"+this.price+"\t"+this.account;
	}
	public void detail() throws OutOfDateException {
		System.out.println("商品名称："+this.name);
		System.out.println("商品价格："+this.price);
		System.out.println("商品库存："+this.account);
		System.out.println("商品描述："+this.desc);
	}
	public double pay(int account) {
		return this.price*account;
	}

}
