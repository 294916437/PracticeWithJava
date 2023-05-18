package allfunctions;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import customer.Information;
import customer.Membership;
import goods.*;
import util.OutOfDateException;
import util.Setting;
public class Main {
	static Customermanager usermanager=new Customermanager();
	static boolean islogin=false;
	static Scanner  input=new Scanner (System.in);
	static ArrayList<Goods> goodslist=new ArrayList<>();
	static Set<String> usernameSet=new HashSet<>();
	static HashMap<String, Shoppingcart> cartdate=new HashMap<>();
	static Shoppingcart cart;
	static Information curruser;
	public static void function1(){
		System.out.println("用户注册");
		System.out.println("请输入用户名:");
		String username = input.next();
		while(usernameSet.contains(username)) {
			System.out.println("该用户名已存在，请重新输入用户名:");
			username=input.next();
		}
		usernameSet.add(username);
		System.out.println("请输入密码:");
		String password=input.next();
		System.out.println("请再次输入以确认密码:");
		String secpassword=input.next();
		while(!secpassword.equals(password)) {
			System.out.println("两次密码不一致，请重新输入密码:");
			password=input.next();
			System.out.println("请再次输入以确认密码:");
			secpassword=input.next();
		}
			int checkedNumber=(int)(Math.random()*(10000-1000)+1000);
			System.out.println("请输入验证码:    "+checkedNumber+"\t");
			int checkedNum=input.nextInt();
			while(checkedNum!=checkedNumber) {
				System.out.println("验证码输入错误，请重新输入验证码:    ");
				checkedNum=input.nextInt();
			}
			Information user;
			Random random=new Random();
			int rdate=random.nextInt(2);
			if(rdate==0) {
				user=new Information(username, password);
			}else {
				user=new Membership(username, password, 0);
			}
			boolean res=usermanager.adduser(user);  
			if(res) {
				System.out.println(username+"注册成功");
			}else {
				System.out.println(username+"注册失败");
			}
	}
	public static void function2() {
			Scanner  input=new Scanner (System.in);
			for(int i=1;i<=3;i++) {
				System.out.println("请输入用户名:    ");
				String uname=input.next();
				System.out.println("请输入密码:     ");
				String upassword=input.next();
				if(usermanager.loginvalidate(uname,upassword)){
					System.out.println("登陆成功");
					curruser=usermanager.getuser(uname);
					islogin=true;
					break;
				}
			else {
				if(i<=2) {
					System.out.println("对不起，用户名或密码错误，您还有"+(3-i)+"次机会! ");
				continue;
				}
				else 
					{System.out.println("对不起，三次均输入错误!");
				break;
				}
				}
			}
			}
	 static{ 
		 usermanager.loads();
		 Date producedate=new Date();
		   Calendar c=Calendar.getInstance();
		   c.setTime(producedate);
		   c.add(Calendar.DAY_OF_MONTH, -5);
		   producedate=c.getTime();
	   Goods goods1=new Notebook("晨光笔记本",10,40,100);
	   goods1.setdesc("学无止境，本尚自然");
	   goodslist.add(goods1);
	   Goods goods2=new Beverage("可口可乐",3,45,producedate,180);
	   goods2.setdesc("新鲜，美味，满意，就是可口可乐！");
	   goodslist.add(goods2);
	    Goods goods3=new Clothes("卫衣", 55, 75);
	   goods3.setdesc("衣之缤慕，通往时尚");
	   goodslist.add(goods3);
	   Goods goods4=new DIscountclothes("休闲裤",60,55,0.6);
	   goods4.setdesc("我型我裤,有韵有格");
	   goodslist.add(goods4);
	    Goods goods5=new Bread("香软面包", 8, 75,producedate,15);
	   goods5.setdesc("味蕾上的巴黎风尚，唇齿间的美味沙龙");
	   goodslist.add(goods5);
	    Goods goods6=new Discountbread("甜甜圈", 5, 120,producedate,10,0.8);
	   goods6.setdesc("吃在口中香,甜在心里边");
	   goodslist.add(goods6);
	  
	   }
	public static void function3() throws OutOfDateException{	   	  
		   boolean trigger=true;
		 while(trigger==true) {
			 System.out.println("==========商品列表==========");
			 System.out.println("1. 晨光笔记本    2. 可口可乐    3. 卫衣    4. 休闲裤    5. 香软面包    6. 甜甜圈    7. 退出商品列表 ");
			 System.out.println("=========================");
			 System.out.println("输入商品序号来查看详情");
			 Scanner  input=new Scanner (System.in);
			 int choose=input.nextInt();		 
		 switch (choose) {
		 case 1:			 
				goodslist.get(0).detail();break;
		 case 2:
			 try{
					goodslist.get(1).detail();
				}catch(OutOfDateException e) {
					System.out.println(Setting.OUTOFDATE);
				}break;
		 case 3:
			 goodslist.get(2).detail();break;
		 case 4:
			 goodslist.get(3).detail();break;
		 case 5:
			 try {
			 goodslist.get(4).detail();
			}catch(OutOfDateException e) {
				System.out.println(Setting.OUTOFDATE);
			}break;
		 case 6:
			 try {
				 goodslist.get(5).detail();
				}catch(OutOfDateException e) {
					System.out.println(Setting.OUTOFDATE);
				}break;
		 case 7:trigger=false;
	}
		 }
		 }
			public static Shoppingitem getShoppingitem(Scanner input) {
			System.out.println("请选择你待购买的商品序号");
			int goodsnumber=input.nextInt();
			while(goodsnumber<1||goodsnumber>goodslist.size()) {
				System.out.println("请输入正确的商品序号");
				goodsnumber=input.nextInt();
			}
			Goods goods=goodslist.get(goodsnumber-1);
			try {
				goods.detail();
			} catch (OutOfDateException e) {
				System.out.println(Setting.OUTOFDATE);
				return null;
			}
			System.out.println("请输入你要购买该商品的数目");
			int goodsamount=input.nextInt();	
			while(goodsamount<1||goodsamount>goods.getamount()) {
				System.out.println("抱歉，该商品库存为："+goods.getamount()+"\t请重新输入商品数目");
				goodsamount=input.nextInt();
			}
			Shoppingitem item=new Shoppingitem(goods,goodsamount);
					return item;
	}
	public static void function4() {
		if(!islogin) {
			System.out.println("请先登陆");
		}else {
		Shoppingitem item=getShoppingitem(input);
		cart=cartdate.get(curruser.getname());
		if(cart==null) {
			cart=new Shoppingcart();
		}
		boolean res=cart.additem(item);
		cartdate.put(curruser.getname(), cart);
		if(item==null) {
			System.out.println("添加购物车失败");
		} 
		else if(res) {
			System.out.println("添加购物车成功");
		}else System.out.println("添加购物车失败");		
	}
		}
	public static void function5() {
		if(!islogin) {
			System.out.println("请先登陆");
		}else {
			cart=cartdate.get(curruser.getname());
			if(cart==null) {
				cart=new Shoppingcart();
			}
			cart.show();
		}
	};
	public static double getreduceprice(Scanner input,double totalprice) {
		int reduceprice=0;
		if(!(curruser instanceof Membership))
			return reduceprice;
		int memberpoint=((Membership)(curruser)).getMemberpoint();
		if(memberpoint<100)
			return reduceprice;
		else if(memberpoint>100)
			System.out.println("你现有"+memberpoint+"会员积分,每100积分可抵扣5元,是否使用?\t输入Y表示使用，输入N表示不使用");
		String confirm=input.next();
		while(!confirm.equals("Y")&&!confirm.equals("N")){
			System.out.println("输入错误，请重新确认并输入");
			confirm=input.next();
		}
		if(confirm.equals("N"))
			return reduceprice;
		int maxpoint=(int)totalprice*20;
		System.out.println("请输入要使用的积分数，应为100的整数倍，且不能超过你现有积分"+memberpoint+"或结算金额对应的最大积分数"+maxpoint);
		int point=input.nextInt();
		while(point<1||(point%100!=0)||point>memberpoint) {
			System.out.println("你输入积分数有误，请重新输入,要求应为100的整数倍，且不能超过你现有积分"+memberpoint+"和结算金额对应的最大积分数"+maxpoint);
			point=input.nextInt();
		}
		reduceprice=point/20;
		((Membership)curruser).usememberpoint(point);
		return reduceprice;
		
	}
	public static void pay(Shoppingcart cart,Scanner input) {
		System.out.println("你购买了以下商品:");
		if(!cart.ifcanpay()) {
			System.out.println("你的购物车部分商品库存不足，现为你下架库存不足的商品");
			cart.getvalidcart();
		}
		if(cart.isempty()) {
			System.out.println("你的购物车是空的，不妨去添加商品");
			return;
		}
		cart.printcartdesc();
		double totalprice=cart.getpayprice();
		double reduceprice=getreduceprice(input, totalprice);
		if(reduceprice>0) {
			System.out.println("你此次消费:"+totalprice+"元，经积分抵扣后需要支付:"+(totalprice-reduceprice)+"元");
			totalprice=totalprice-reduceprice;
		}else {
			System.out.println("你此次消费:"+totalprice+"元");
		}
		System.out.println("你确定支付吗?输入Y表示确定，输入N表示取消");
		String confirm=input.next();
		while(!confirm.equals("Y")&&!confirm.equals("N")) {
			System.out.println("你输入错误,请重新输入");
			confirm=input.next();
		}
		if(confirm.equals("Y")) {
		System.out.println("请输入支付金额:");
		double userpay=input.nextDouble();
		while(userpay<totalprice) {
			System.out.println("你支付金额不足，请重新输入");
			userpay=input.nextDouble();
		}
		System.out.println("恭喜你支付成功，找零："+(userpay-totalprice)+"元");
		cart.updatecart();
		if(curruser instanceof Membership) {
			((Membership)(curruser)).addmemberpoint(totalprice);
		}
		Analysis.add(new Date());
		}
		else System.out.println("你选择了暂时不支付");
	}
	public static void function6() {
		cart=cartdate.get(curruser.getname());
		if(!islogin) {
			System.out.println("请先登陆");
		}
		 if(cart==null) {
			cart=new Shoppingcart();
		}
		 if(cart.isempty()) {
			System.out.println("你当前购物车为空，请添加购物车后再来结算");
		}	
			pay(cart, input);
			cartdate.put(curruser.getname(), cart);
	}
	public static void function7() {
		Analysis.print();
	}
	public static void function8() {
		usermanager.dumps();
		System.out.println("你已经成功退出理工超市系统,欢迎下次光临");
		System.exit(0);
	}
	public static void main(String[] args) throws OutOfDateException {
while(true) {
	System.out.println("==========欢迎来到理工超市管理系统==========");
	System.out.println("1. 用户注册    2. 用户登陆    3. 浏览商品    4. 加入购物车    5. 查看购物车    6. 结算    7.查看经营情况    8. 退出");
	System.out.println("====================================");
	Scanner input=new Scanner (System.in);
	int choice=input.nextInt();
	switch(choice) {
	case 1:function1();
		break;
	case 2:function2();
		break;
	case 3:function3();
		break;
	case 4:function4();
		break;
	case 5:function5();
		break;
	case 6:function6();
		break;
	case 7:function7();
		break;
	case 8:function8();
	}
}
	}
}
