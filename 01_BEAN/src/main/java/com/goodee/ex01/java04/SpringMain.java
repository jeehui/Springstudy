package com.goodee.ex01.java04;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("java/book_context.xml");
		
		Book book1 = ctx.getBean("book1", Book.class);
		System.out.println("제목 : " + book1.getTitle());
		System.out.println("저자 : " + book1.getAuthor());
		System.out.println("출판사 : " + book1.getPublisher());
		
		
		Book book2 = ctx.getBean("book2", Book.class);
		System.out.println("제목 : " + book2.getTitle());
		System.out.println("저자 : " + book2.getAuthor());
		System.out.println("출판사 : " + book2.getPublisher());
		
		ctx.close();
		
		//xml파일과 java파일을 xml파일로 통일하기
		//<context:annotation-config /> xml에 이 방식으로 xml가져오기
		//<bean class="com.goodee.ex01.java04.SpringBeanConfig"/>
	}

}
