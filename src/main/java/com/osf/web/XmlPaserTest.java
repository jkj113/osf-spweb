package com.osf.web;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.dbcp.BasicDataSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// class ConTest{
//	private static ConTest ct;
//	
//	private ConTest() {}
//
//
//public static ConTest newInstance() {
//	if(ct!=null) {
//		ct = new ConTest();
//	}
//	return ct;
//	}
//}

public class XmlPaserTest {
	public static void main(String[] args) {
		String path = "D:\\study\\works\\osf-spweb\\src\\main\\resources\\spring\\application-config.xml";
		File f = new File(path);
		DocumentBuilderFactory dBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dBuilderFactory.newDocumentBuilder();
			Document document = dBuilder.parse(f);
			Element root = document.getDocumentElement();
			System.out.println(root.getAttribute("xsi:schemaLocation"));
			NodeList nodes = root.getElementsByTagName("bean");
			for(int i =0; i<nodes.getLength();i++) { //데이터 타입으 노드리스트니까 그걸 for문으로 돌린다. 나온지 오래돼서 예전 방식을 고수한다. XmlPaser 검색
				Element bean = (Element) nodes.item(i);
				String id = bean.getAttribute("id");
				String className = bean.getAttribute("class");
				System.out.println(bean.getAttribute("id"));
				System.out.println(bean.getAttribute("class"));
				if("ds".equals(id)) {
					Class<?> clazz = Class.forName(className); //bean에 있는 클래스를 가져와 무슨 클래스인지 모르니까 ? (무한으로 받을 수 있다)
					Method[] methods = clazz.getDeclaredMethods();   //이 class에서만 선언된 methods (위에서 가져온 애들은 빼고)
					Object obj = clazz.newInstance();
					NodeList props = bean.getElementsByTagName("property");
					for(int j =0;j<props.getLength();j++) { //총 4개의 노드를 가져온다.(2개는 주석처리했으니까)
						Element prop = (Element)props.item(i);
						String methodName = prop.getAttribute("name"); //->DriverClassName
						String value = prop.getAttribute("value");
						String fStr = methodName.substring(0,1);
						methodName = "set" + fStr.toUpperCase() + methodName.substring(1); //해당 D를 대문자로 그리고 나머지 붙이기 ==> setDriverClassName
						for(Method method : methods) {
							if(methodName.equals(method.getName())) {
								method.invoke(obj, value); //invoke --> 값을 넣어서 실행하라
							}
						}
					}
					BasicDataSource bds =(BasicDataSource)obj;
					Connection con = bds.getConnection();
					System.out.println(con);
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
