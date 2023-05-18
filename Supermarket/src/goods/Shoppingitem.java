package goods;

public class Shoppingitem {
	private Goods goods;
	private int amount;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Goods getGoods() {
		return goods;
	}
	
	public Shoppingitem(Goods goods,int amount) {
		this.goods=goods;
		this.amount=amount;
	}
public void show() {
	String desc=goods.getname()+"\t单价:"+goods.getprice()+"\t数量:"+this.amount;
	System.out.println(desc);
}
public double payprice() {
	return goods.pay(this.amount);
}
}
