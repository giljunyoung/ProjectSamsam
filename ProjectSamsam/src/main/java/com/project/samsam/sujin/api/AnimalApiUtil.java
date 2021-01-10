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
        
        // 응답코드 200~300 이면,  404 등 에러인지 확인
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
        System.out.println(sido);
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
	public ArrayList<Sigungu> getSiGunGu(Integer upr_cd) throws Exception {
		ArrayList<String> paramNm = new ArrayList<String>();
		ArrayList<String> paramVal = new ArrayList<String>();
		
		// 실제 변수로 변경할 것
		paramNm.add("upr_cd");
		paramVal.add(upr_cd.toString());
		
		StringBuilder sb = getReponse("sigungu", 2, paramNm, paramVal);
		 // orgCd, orgdownNm 추출
        String siGunGu = sb.toString();
        String[] str1 = siGunGu.split("<items>");
		String result = str1[1];
		String[] str2 = result.split("</items>");
		result = str2[0];
		String[] str3 = result.split("(<\\w+>)|(</\\w+>)");
		
		ArrayList<Integer> orgCode = new ArrayList<Integer>();
		ArrayList<String> orgDownNm = new ArrayList<String>();
		ArrayList<Sigungu> siGunGuList = new ArrayList<Sigungu>();
		
		int cnt = 0;
		for (int i = 0; i < str3.length; i++) {
			if( !str3[i].equals("") ) {
				cnt++;
				if( cnt == 3 ) {
					cnt = 0;
					continue;
				}
				
				// 숫자코드 인지 확인
				if( str3[i].matches("[+-]?\\d*(\\.\\d+)?") ) {
					orgCode.add( Integer.parseInt(str3[i]) );
					System.out.println("코드 : " + str3[i]);
				}
				else {
					orgDownNm.add(str3[i]);
					System.out.println("이름 : " + str3[i]);
				}
			}
		}
		
		for (int i = 0; i < orgCode.size(); i++) {
			siGunGuList.add( new Sigungu(orgCode.get(i), orgDownNm.get(i) ) );
		}
		return siGunGuList;
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
	// 개 : 417000 - 고양이 : 422400 - 기타 : 429900
	public ArrayList<AnimalKind> getAnimalKind(Integer up_kind_cd) throws Exception {
		ArrayList<String> paramNm = new ArrayList<String>();
		ArrayList<String> paramVal = new ArrayList<String>();
		
		// 실제 변수로 변경할 것
		paramNm.add("up_kind_cd");
		paramVal.add(up_kind_cd.toString());
		
		StringBuilder sb = getReponse("kind", 4, paramNm, paramVal);
		System.out.println("@getAnimalKind ");
		System.out.println(sb.toString());
		 // orgCd, orgdownNm 추출
        String animalKind = sb.toString();
        String[] str1 = animalKind.split("<items>");
		String result = str1[1];
		String[] str2 = result.split("</items>");
		result = str2[0];
		String[] str3 = result.split("(<\\w+>)|(</\\w+>)");
		
		ArrayList<String> KindCd = new ArrayList<String>();
		ArrayList<String> KindNm = new ArrayList<String>();
		ArrayList<AnimalKind> animalKindList = new ArrayList<AnimalKind>();
		
		for (int i = 0; i < str3.length; i++) {
			if( !str3[i].equals("") ) {
				
				// 숫자코드 인지 확인
				if( str3[i].matches("[+-]?\\d*(\\.\\d+)?") ) {
					KindCd.add( str3[i] );
					System.out.println("코드 : " + str3[i]);
				}
				else {
					KindNm.add(str3[i]);
					System.out.println("이름 : " + str3[i]);
				}
			}
		}
		
		for (int i = 0; i < KindCd.size(); i++) {
			animalKindList.add( new AnimalKind(KindCd.get(i), KindNm.get(i) ) );
		}
		return animalKindList;
    }

	@Override
	public ArrayList<AnimalInfo> getAnimalInfo(String bgnde, String endde, Integer upkind, String state,
			Integer pageNo, Integer numOfRows, String neuter_yn) throws Exception {
		
		ArrayList<String> paramNm = new ArrayList<String>();
		ArrayList<String> paramVal = new ArrayList<String>();
		
		// 실제 변수로 변경할 것
		paramNm.add("bgnde");
		paramNm.add("endde");
		paramNm.add("upkind");
		paramNm.add("state");
		paramNm.add("pageNo");
		paramNm.add("numOfRows");
		paramNm.add("neuter_yn");
		
		paramVal.add(bgnde);
		paramVal.add(endde);
		paramVal.add(upkind.toString());
		paramVal.add(state);
		paramVal.add(pageNo.toString());
		paramVal.add(numOfRows.toString());
		paramVal.add(neuter_yn);
		
		StringBuilder sb = getReponse("abandonmentPublic", 5, paramNm, paramVal);
		
		String animalInfo = sb.toString();
        System.out.println(animalInfo);
        String[] str1 = animalInfo.split("<items>");
		String result = str1[1];
		String[] str2 = result.split("</items>");
		result = str2[0];
		String[] str3 = result.split("(<\\w+>)|(</\\w+>)");
		
		System.out.println("###########################");
		int count = 0;
		AnimalInfo animal = null;
		ArrayList<AnimalInfo> animalList = new ArrayList<AnimalInfo>();
		
		for (int i = 0; i < str3.length; i++) {
			
			if( count == 0 ) {
				animal = new AnimalInfo();
			}
			
			if( count == 22 ) {
				animalList.add(animal);
				count = 0;
			}
			
			if( !str3[i].equals("") ) {
				
				count++;
				System.out.print(count + ". ");
				System.out.println(str3[i]);
				
				switch (count) {
				case 1:
					animal.setAge( str3[i] );
					break;
				case 2:
					animal.setCareAddr( str3[i] );
					break;
				case 3:
					animal.setCareNm(str3[i] );
					break;
				case 4:
					animal.setCareTel(str3[i] );
					break;
				case 5:
					animal.setChargeNm( str3[i] );
					break;
				case 6:
					animal.setColorCd(str3[i] );
					break;
				case 7:
					animal.setDesertionNo(str3[i] );
					break;
				case 8:
					animal.setFilename(str3[i] );
					break;
				case 9:
					animal.setHappenDt(str3[i] );
					break;
				case 10:
					animal.setHappenPlace(str3[i] );
					break;
				case 11:
					animal.setKindCd(str3[i] );
					break;
				case 12:
					animal.setNeuterYn(str3[i] );
					break;
				case 13:
					animal.setNoticeEdt(str3[i] );
					break;
				case 14:
					animal.setNoticeNo(str3[i] );
					break;
				case 15:
					animal.setNoticeSdt(str3[i] );
					break;
				case 16:
					animal.setOfficetel(str3[i] );
					break;
				case 17:
					animal.setOrgNm(str3[i] );
					break;
				case 18:
					animal.setPopfile(str3[i] );
					break;
				case 19:
					animal.setProcessState(str3[i] );
					break;
				case 20:
					animal.setSexCd(str3[i] );
					break;
				case 21:
					animal.setSpecialMark(str3[i] );
					break;
				case 22:
					animal.setWeight(str3[i] );
					break;
				default:
							break;
				}
				
			}
		}
		
		
		
		return animalList;
	}
	
	
	@Override
	public ArrayList<AnimalInfo> getAnimalInfo(String bgnde, String endde, Integer upr_cd, Integer org_cd, Integer upkind, Integer kind, String state,
			Integer pageNo, Integer numOfRows, String neuter_yn) throws Exception {
		
		ArrayList<String> paramNm = new ArrayList<String>();
		ArrayList<String> paramVal = new ArrayList<String>();
		
		// 실제 변수로 변경할 것
		paramNm.add("bgnde");
		paramNm.add("endde");
		paramNm.add("upr_cd");
		paramNm.add("org_cd");
		paramNm.add("upkind");
		paramNm.add("kindcd");
		paramNm.add("state");
		paramNm.add("pageNo");
		paramNm.add("numOfRows");
		paramNm.add("neuter_yn");
		
		paramVal.add(bgnde);
		paramVal.add(endde);
		paramVal.add(upr_cd.toString());
		paramVal.add(org_cd.toString());
		paramVal.add(upkind.toString());
		paramVal.add(kind.toString());
		paramVal.add(state);
		paramVal.add(pageNo.toString());
		paramVal.add(numOfRows.toString());
		paramVal.add(neuter_yn);
		
		StringBuilder sb = getReponse("abandonmentPublic", 5, paramNm, paramVal);
		
		String animalInfo = sb.toString();
        System.out.println(animalInfo);
        String[] str1 = animalInfo.split("<items>");
		String result = str1[1];
		String[] str2 = result.split("</items>");
		result = str2[0];
		String[] str3 = result.split("(<\\w+>)|(</\\w+>)");
		
		System.out.println("###########################");
		int count = 0;
		AnimalInfo animal = null;
		ArrayList<AnimalInfo> animalList = new ArrayList<AnimalInfo>();
		
		for (int i = 0; i < str3.length; i++) {
			
			if( count == 0 ) {
				animal = new AnimalInfo();
			}
			
			if( count == 22 ) {
				animalList.add(animal);
				count = 0;
			}
			
			if( !str3[i].equals("") ) {
				
				count++;
				System.out.print(count + ". ");
				System.out.println(str3[i]);
				
				switch (count) {
				case 1:
					animal.setAge( str3[i] );
					break;
				case 2:
					animal.setCareAddr( str3[i] );
					break;
				case 3:
					animal.setCareNm(str3[i] );
					break;
				case 4:
					animal.setCareTel(str3[i] );
					break;
				case 5:
					animal.setChargeNm( str3[i] );
					break;
				case 6:
					animal.setColorCd(str3[i] );
					break;
				case 7:
					animal.setDesertionNo(str3[i] );
					break;
				case 8:
					animal.setFilename(str3[i] );
					break;
				case 9:
					animal.setHappenDt(str3[i] );
					break;
				case 10:
					animal.setHappenPlace(str3[i] );
					break;
				case 11:
					animal.setKindCd(str3[i] );
					break;
				case 12:
					animal.setNeuterYn(str3[i] );
					break;
				case 13:
					animal.setNoticeEdt(str3[i] );
					break;
				case 14:
					animal.setNoticeNo(str3[i] );
					break;
				case 15:
					animal.setNoticeSdt(str3[i] );
					break;
				case 16:
					animal.setOfficetel(str3[i] );
					break;
				case 17:
					animal.setOrgNm(str3[i] );
					break;
				case 18:
					animal.setPopfile(str3[i] );
					break;
				case 19:
					animal.setProcessState(str3[i] );
					break;
				case 20:
					animal.setSexCd(str3[i] );
					break;
				case 21:
					animal.setSpecialMark(str3[i] );
					break;
				case 22:
					animal.setWeight(str3[i] );
					break;
				default:
							break;
				}
				
			}
		}
		
		
		
		return animalList;
	}
	
	
	// 요청이름에 맞는 응답 html 반환
	public StringBuilder getReponse(String requestName, int requestNo, ArrayList<String> paramNm, ArrayList<String> paramVal) throws Exception {
		
		StringBuilder urlBuilder = new StringBuilder(baseUrl + requestName); 
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + serviceKey);
        
        // 시군구 요청
        if( requestNo == 2 ) {
        	// &upr_cd=6110000
        	for (int i = 0; i < paramNm.size(); i++) {
        		urlBuilder.append("&" + URLEncoder.encode(paramNm.get(i), "UTF-8") + "=" + paramVal.get(i) ); 
        	}
        	
        }
        // 유기동물 품종 요청
        if ( requestNo == 4) {
        	for (int i = 0; i < paramNm.size(); i++) {
        		urlBuilder.append("&" + URLEncoder.encode(paramNm.get(i), "UTF-8")+ "=" + paramVal.get(i));
        	}
        }
        
        // 유기동물 정보 요청
        if( requestNo == 5 ) {
        	
        	for (int i = 0; i < paramNm.size(); i++) {
        		urlBuilder.append("&" + URLEncoder.encode(paramNm.get(i), "UTF-8") + "=" + paramVal.get(i) ); 
			}
        }
      
        System.out.println(urlBuilder.toString());
        
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        
        // 응답코드 200~300 이면,  404 등 에러인지 확인
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

}
