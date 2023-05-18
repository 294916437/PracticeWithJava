package allfunctions;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Analysis {
	private static Map<Date, Integer> ordernumbytime=new TreeMap<Date,Integer>();
public static void add(Date date) {
	Calendar c=Calendar.getInstance();
	c.setTime(date);
	c.set(Calendar.SECOND,0);
	c.set(Calendar.MILLISECOND,0);
	Date key=c.getTime();
	int value=ordernumbytime.getOrDefault(key, 0)+1;
	ordernumbytime.put(key, value);
}
public static void print() {
	String format="yyyy-MM-dd HH:mm";
	SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
	System.out.println("支付时间\t\t支付订单数");
	for(Date key:ordernumbytime.keySet()) {
		System.out.println(simpleDateFormat.format(key)+"\t"+ordernumbytime.get(key));
		
	}
	
}
}
