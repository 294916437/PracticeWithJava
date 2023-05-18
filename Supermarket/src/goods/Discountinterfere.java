package goods;
public interface Discountinterfere {
double getdiscountprice(int account ,double discount) ;
	default void printdiscountmessage(double discount) {
	    String discountmessage;
	  if(discount==1) {
		discountmessage="不打折";
	   }else {discountmessage=discount*10+"折";
	   }
	     System.out.println("商品折扣率："+discountmessage);
	    } 

	}


