package com.project.samsam.sujin.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class AnimalApiUtil implements AnimalApi {

	@Override
	public ArrayList<Sido> getSido() throws Exception {
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
        
        
        // sidoCode, sidoNm 추출
        String sido = sb.toString();
        String[] str1 = sido.split("<items>");
		String result = str1[1];
		String[] str2 = result.split("</items>");
		result = str2[0];
		String[] str3 = result.split("(<\\w+>)|(</\\w+>)");
		

		ArrayList<Integer> sidoCode = new ArrayList<Integer>();
		ArrayList<String> sidoNm = new ArrayList<String>();
		ArrayList<Sido> sidoList = new ArrayList<Sido>();
				
		for (int i = 0; i < str3.length; i++) {
			if( !str3[i].equals("") ) {
				// 숫자코드 인지 확인
				if( str3[i].matches("[+-]?\\d*(\\.\\d+)?") ) {
					sidoCode.add( Integer.parseInt(str3[i]) );
					System.out.println("코드 : " + str3[i]);
				}
				else {
					sidoNm.add( str3[i] );
					System.out.println("이름 : " + str3[i]);
				}
			}
		}
		
		for (int i = 0; i < sidoCode.size(); i++) {
			sidoList.add( new Sido(sidoCode.get(i), sidoNm.get(i) ) );
		}
		return sidoList;
	}

	@Override
	public StringBuilder getSiGunGu(Integer upr_cd) throws Exception {
		StringBuilder urlBuilder = new StringBuilder(baseUrl + "sigungu"); 
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
		StringBuilder urlBuilder = new StringBuilder(baseUrl + "sigungu"); 
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
	public StringBuilder getAnimalKind(Integer up_kind_cd) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
