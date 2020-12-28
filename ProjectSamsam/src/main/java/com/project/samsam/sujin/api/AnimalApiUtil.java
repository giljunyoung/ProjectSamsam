package com.project.samsam.sujin.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class AnimalApiUtil implements AnimalApi {

	@Override
	public StringBuilder getSido() throws Exception {
		StringBuilder urlBuilder = new StringBuilder(baseUrl + "sido"); 
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + serviceKey);
        
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        
        
		return sb;
	}

	@Override
	public StringBuilder getSiGunGu(Integer upr_cd) throws Exception {
		StringBuilder urlBuilder = new StringBuilder(baseUrl + "sido"); 
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + serviceKey);
        
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        
        
		return sb;
	}

	@Override
	public StringBuilder getShelter(Integer upr_cd, Integer org_cd) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StringBuilder getAnimalKind(Integer up_kind_cd) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
