package goods;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import util.OutOfDateException;
public class Bread extends Goods{
	private  Date producedate;
	private Date validdate;
	private int exp;
	public Bread(String name, double price, int account,Date producedate,int exp) {
		super(name,price,account);
		this.producedate=producedate;
		this.exp=exp;
	}
	public void detail() throws OutOfDateException{
		Calendar c=Calendar.getInstance();
		   c.setTime(producedate);
		   c.add(Calendar.DAY_OF_MONTH, exp);
		   validdate=c.getTime();
		if(this.validdate.before(new Date())){
			throw new OutOfDateException();
		}
		super.detail();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("生产日期："+df.format(producedate));
		System.out.println("保质期："+exp+"天");
	}

}
