package com.springbook.ioc.injection;
//p.92-94 List
//import java.util.List;
//p.94-96 Set
import java.util.Set;
//p.96-97 Map
import java.util.Map;
import java.util.Properties;

public class CollectionBean {
//	// p.92-94 List
//	private List<String> addressList;
//	
//	public void setAddressList(List<String> addressList) {
//		this.addressList=addressList;
//	}
//	
//	public List<String> getAddressList(){
//		return addressList;
//	}
	
//	// p.94-96 Set
	private Set<String> addressList;

	public Set<String> getAddressList() {
		return addressList;
	}

	public void setAddressList(Set<String> addressList) {
		this.addressList = addressList;
	}
	
//	// p.96-97 Map
//	private Map<String, String> addressList;
//
//	public Map<String, String> getAddressList() {
//		return addressList;
//	}
//
//	public void setAddressList(Map<String, String> addressList) {
//		this.addressList = addressList;
//	}
	
//	p.97-98 Properties
//	private Properties addressList;
//
//	public Properties getAddressList() {
//		return addressList;
//	}
//
//	public void setAddressList(Properties addressList) {
//		this.addressList = addressList;
//	}
	
}
