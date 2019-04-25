package com.osf.web.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osf.web.dao.AddrDAO;

@Repository
public class AddrDAOImpl implements AddrDAO {
	
	@Autowired
	private SqlSessionFactory ssf;
//	private DataSource ds;

	@Override
	public List<Map<String, String>> selectAddrList() {
		SqlSession ss = ssf.openSession();
		Map<String,String> param = new HashMap<String,String>();
		param.put("ad_num", "20");
		param.put("ad_sido", "부산광역시");
		return ss.selectList("addr.selectAddrList",param);
	}
	

//	@Override
//	public List<Map<String, String>> selectAddrList() {
//		try {
//			Connection con = ds.getConnection();
//			PreparedStatement ps = con.prepareStatement("select * from address where ad_num <= 100");
//			ResultSet rs = ps.executeQuery();
//			List<Map<String,String>> aList = new ArrayList<Map<String,String>>();
//			while(rs.next()) {
//				Map<String,String> aMap = new HashMap<String,String>();
//				aMap.put("ad_sido",rs.getString("ad_sido"));
//				aMap.put("ad_code",rs.getString("ad_code"));
//				aList.add(aMap);
//			}
//			return aList;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

}
