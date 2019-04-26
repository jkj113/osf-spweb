package com.osf.web.service;

import java.util.List;
import java.util.Map;

public interface CustomerInfoService {
	List<Map<String,String>> selectCustomerList();
	Map<String,String> selectCustomer(Integer ciNum);
	Map<String,String> selectCustomerById(String ciId);
	int insertCustomerInfo(Map<String,String> ci);
	int updateCustomerInfo(Map<String,String> ci);
	int deleteCustomerInfo(Integer ciNum);
	int deleteCustomerInfo(String ciId);
}
