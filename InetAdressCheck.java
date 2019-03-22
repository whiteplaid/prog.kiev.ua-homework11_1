package com.homework.siteavailability;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class InetAdressCheck {
	private Map<String,String> result = new HashMap<>();
	
	public InetAdressCheck() {
		super();
	}
	
	public void load (File file) {
		try (BufferedReader r = new BufferedReader(new FileReader(file))) {
			String urlAdress = "";
			for(;(urlAdress=r.readLine()) != null;) {
				if (!result.containsKey(urlAdress)) {
					result.put(urlAdress, checkURL(urlAdress));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Map<String,String> getResult () {
		return this.result;
	}
	public String checkURL (String urladress) {
		try {
			URL url = new URL(urladress);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.getHeaderFields();
			int response = con.getResponseCode();
			if ((response >= 200) && (response < 300)) {
				return "YES Site is available";
			} else {
				return "NO " + con.getResponseMessage();
			}
		} catch (IOException e) {
			return "Not registered";
		}
	}
}
