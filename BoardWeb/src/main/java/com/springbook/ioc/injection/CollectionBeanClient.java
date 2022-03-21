package com.springbook.ioc.injection;
//p92-94 list
//import java.util.List;
//p94-96 set
import java.util.Set;
//p96-97 map
//import java.util.Map;
//import java.util.Properties;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("collectionContext.xml");
		
		CollectionBean bean=(CollectionBean) factory.getBean("collectionBean");
//		List<String> addressList=bean.getAddressList();
		Set<String> addressList=bean.getAddressList();
//		Map<String, String> addressList=bean.getAddressList();
//		Properties addressList=bean.getAddressList();
		
//		List, Set 출력
		for(String address : addressList) {
			System.out.println("address: "+address.toString());
		}
		
//		Map 출력
//		for(String key : addressList.keySet()) {
//			String value=(String)addressList.get(key);
//			System.out.println(key+" : "+value);
//		}
		
//		Properties 출력
//		for(Object key : addressList.keySet()) {
//			String value=(String)addressList.get(key);
//			System.out.println(key+" : "+value);
//		}
		
		
		factory.close();
	}

}
