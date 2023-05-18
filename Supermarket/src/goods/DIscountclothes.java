package goods;

import util.OutOfDateException;

public class DIscountclothes extends Clothes implements Discountinterfere{
private double discount=1;
	public DIscountclothes(String name, double price, int account,double discount) {
		super(name, price, account);
		this.discount=discount;
	}
	public double getdiscountprice(int account, double discount) {
		double rawprice=super.pay(account);
		return rawprice*discount;
	}
	public void detail() throws OutOfDateException{
		super.detail();
 printdiscountmessage(this.discount);
	}
}
