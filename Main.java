package com.homework.siteavailability;

import java.io.File;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		InetAdressCheck ad = new InetAdressCheck();
		File file = new File ("c:\\Users\\white\\eclipse-workspace\\prog.kiev.ua\\src\\com\\homework\\siteavailability\\list.txt");
		ad.load(file);
		Map<String,String> result = ad.getResult();
		Set<String> adress = result.keySet();
		for (String url : adress) {
			System.out.println(url + " " + result.get(url));
		}
	}
}
