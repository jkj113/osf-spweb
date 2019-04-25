package com.osf.web.dao;

import java.util.List;
import java.util.Map;

public interface CustomerInfoDAO {

	List<Map<String,String>> selectCustomerList();
	Map<String,String> selectCustomer(Integer ciNum);
	Map<String,String> selectCustomerById(String ciId);
	int insertCustomerInfo(Map<String,String> ci);
	int deleteCustomerInfo(Integer ciNum);
	int updateCustomerInfo(Map<String,String> ci);

	
}
