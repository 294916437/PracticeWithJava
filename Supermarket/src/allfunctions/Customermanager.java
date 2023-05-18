package allfunctions;
import java.io.BufferedWriter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

import customer.Information;
import customer.Membership;
import util.Setting;
public class Customermanager {
	private HashMap<String, Information>users=new  HashMap<>();
	public boolean adduser(Information user) {
		users.put(user.getname(), user);
		return true;
	}
public boolean loginvalidate(String username,String pwd) {
	boolean istrue=false;
	if(users.containsKey(username)) {
		istrue=users.get(username).loginvalidate(username, pwd);
	}
	return istrue; 		
}
public Information getuser(String name) {
	Information user=null;
	if(users.containsKey(name)) {
		user=users.get(name);
	}
	return user;
}

public void dumps() {
	FileOutputStream fos=null;
	OutputStreamWriter osw=null;
	BufferedWriter bw=null;
	try {
		fos=new FileOutputStream(Setting.ADDRESS);
		osw=new OutputStreamWriter(fos);
		bw=new BufferedWriter(osw);
		for(String key:users.keySet()) {
			bw.write(users.get(key).getdumpcontent());
			bw.newLine();
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace(); 
	}finally {
		try {
			if(null !=bw) {
				bw.close();
			}
			if(null !=osw) {
				osw.close();
			}
			if(null !=fos) {
				fos.close();
			}
		}catch (IOException e) {
			e.printStackTrace(); 
		}
	}
}
public void loads() {
	FileInputStream fis=null;
	InputStreamReader isr=null;
	BufferedReader reader=null;
	try {
		fis=new FileInputStream(Setting.ADDRESS);
		isr=new InputStreamReader(fis); 
		reader=new BufferedReader(isr);
		String line=null;
		while((line=reader.readLine())!=null) {
			String[] attrs=line.split(" ");
			Information user;
			if(attrs.length==3) {
				user=new Information(attrs[0],attrs[1],attrs[2]);		
			}else if(attrs.length==4) {
				user=new Membership(attrs[0], attrs[1],attrs[2],Integer.parseInt(attrs[3])); 
			}else {
				throw new RuntimeException("用户信息不合法");
			}
			users.put(attrs[0],user);
		}
		}catch (FileNotFoundException e) {
		e.printStackTrace();
		System.out.println("用户信息不存在");
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(null !=reader) {
					reader.close();
				}
				if(null !=isr) {
					isr.close();
				}
				if(null !=fis) {
					fis.close();
				}
	} catch (IOException e) {
		e.printStackTrace();
	}
		}
}
}
