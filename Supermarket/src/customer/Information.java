package customer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
public class Information {
	private String name;
	private String pwd;
	private String salt;
	private char[] hex= {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	public String getname(){
		return name;
	}
	
	public String getsalt() {
		Random random=new Random();
		StringBuilder sb=new StringBuilder(16);
		for(int i=0;i<sb.capacity();i++) {
			sb.append(hex[random.nextInt(16)]);
		}
		return sb.toString();
	}
	private String getpwd0(String pwd,String salt) {
		String hashresult=pwd;
		MessageDigest md=null;
		try {
	     md=MessageDigest.getInstance("MD5");}
		catch (NoSuchAlgorithmException e ) {
			e.printStackTrace();
			return hashresult;
		}
		String inputwithtsalt=pwd+salt;
		hashresult=byte2Hexstr(md.digest(inputwithtsalt.getBytes()));
		return hashresult;
	}
	private String byte2Hexstr(byte[] bytes) {
		int len=bytes.length;
		StringBuffer result=new StringBuffer();
		for(int i=0;i<len;i++) {
			byte byte0=bytes[i];
			result.append(hex[byte0 & 0xf]);
			result.append(hex[byte0 & 0xf]);
		}
		return result.toString();
	}
	public Information(String name,String pwd) {
		this.name=name;
		this.salt=getsalt();
		this.pwd=getpwd0(pwd,this.salt);
	}
	public Information(String name,String salt,String pwd) {
		this.name=name;
		this.salt=salt;
		this.pwd=pwd;
	}
	public boolean loginvalidate(String name,String pwd) {
		boolean istrue=false;
		String userpwd=getpwd0(pwd, this.salt);
		if(this.name.equals(name)&&this.pwd.equals(userpwd))
			istrue=true;
		return istrue;
	}
	public String getdumpcontent() {
		StringBuilder builder=new StringBuilder();
		builder.append(this.name);
		builder.append(" ");
		builder.append(this.salt);
		builder.append(" ");
		builder.append(this.pwd);
		return builder.toString();
	}
}
