package goods;
import java.util.Date;

import util.OutOfDateException;
public class Discountbread extends Bread implements Discountinterfere{
	private double discount=1;
	public Discountbread(String name, double price, int account,Date producedate,int exp,double discount) {
		super(name,price,account,producedate,exp);
		this.discount=discount;
	}
	public double getdiscountprice(int account, double discount) {
		double rawprice=super.pay(account);
		return rawprice*discount;
	}
	public void detail() throws OutOfDateException {
		super.detail();
    printdiscountmessage(this.discount);
	}
	public double pay(int account) {
		return getdiscountprice( account, this.discount);
	}
}