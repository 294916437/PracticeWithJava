package goods;

import java.util.ArrayList;
import java.util.Iterator;
public class Shoppingcart {
	private ArrayList<Shoppingitem> items=new ArrayList<>();
	
public boolean additem(Shoppingitem item) {
	items.add(item);
return true;
}
    public void show() {
	if(items.isEmpty()) {System.out.println("你的购物车是空的，不妨去添加商品");}
	for(int i=0;i<items.size();i++) 
	{
		items.get(i).show();
	System.out.println("---------------------------------------------");
	}
}
public boolean isempty() {
	if(items.isEmpty())
		return true;
	else return false;}
	public void printcartdesc() {
		double totalprice=0;
		for(int i=0;i<items.size();i++) {
			items.get(i).show();
			totalprice+=items.get(i).payprice();		
		}
		System.out.println("总计:"+totalprice+"元");
		}
	public double getpayprice() {
		double totalprice=0;
		for(int i=0;i<items.size();i++)
			totalprice+=items.get(i).payprice();
		return totalprice;
	}
	public void updatecart() {
		for(Shoppingitem each:items) {
			Goods goods=each.getGoods();
			goods.setAccount(goods.getamount()-each.getAmount());
		}
		items.clear();
	}
	public boolean ifcanpay() {
		boolean res=true;
		for(Shoppingitem each:items ) {
			Goods goods=each.getGoods();
			if(goods.getamount()<each.getAmount()){
				res=false;
				break;
			}
		}
		return res;
	}
	public void getvalidcart() {
		Iterator<Shoppingitem> iter=items.iterator();
		while(iter.hasNext()) {
			Shoppingitem item=iter.next();
			if(item.getAmount()>item.getGoods().getamount())
				iter.remove();
		}
	}
	}

