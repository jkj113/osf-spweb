package com.osf.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Exam {
//	private final static Logger logger = LoggerFactory.getLogger(Exam.class);
	public String name;
/*
 * Log4j level 순서
 * 1. TRACE --> 되게 상세한 정보
 * 2. DEBUG --> 개발할 때 필요한 정보
 * 3. INFO --> 말 그대로 정보
 * 4. WARN --> 워닝(WARNING) 동작은 하지만 위험하다. !
 * 5. ERROR --> 실제 에러
 * 6. FETAL --> 
 * 보통 개발할 때는 DEBUG, 서버에 올릴 때는 INFO
 * DEBUG에 두고 하면 TRACE는 안 나오고 밑에는 나온다.
 * 맨 위에 ALL, 맨 밑에 OFF가 있지만 다 나오는거고 안 나오는 거고
 * 
 */
	public static void main(String[] args) {
		String name = null;
//		Exam e1 = new Exam();
//		Exam e2 = new Exam();
//		System.out.println(e);
//		logger.info(e); 객체가 들어가지 않는다. 아예 막아버렸어. 찍고 싶으면은 e가 뭔지 설명해줘야해
//	log.info("e1=>{},e2=>{}",e1,e2);	  // '=>'이건 그냥 선생님의 표기법 e의 정보가 {}이 안에 
		if (name.equals("홍길동")) {
			log.info("이름은 홍길동이 맞습니다.");
		}else {
			log.info("이름은 홍길동이 아닙니다.");
		}
		log.warn("프로그램 비정상 종료, 그치만 문제는 없음");
	}
}
