package goods;

import util.OutOfDateException;

public class Notebook extends Goods{
	private int pages;
   public Notebook(String name, double price, int account,int pages) {
		super(name,price,account);
		this.pages=pages;
	}
   public void detail() throws OutOfDateException{
		super.detail();
		System.out.println("页数："+pages);
	}
}
