package com.osf.web.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;


public interface AddrDAO {
	public List<Map<String,String>> selectAddrList();
	

}
