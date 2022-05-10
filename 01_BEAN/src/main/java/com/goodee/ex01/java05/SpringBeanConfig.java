package com.goodee.ex01.java05;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
public class SpringBeanConfig {
	@Bean
	public Gun Gun2() {
		Gun gun = new Gun();
		gun.setModel("AK-47");
		gun.setBullet(20);
		
		return gun;
	}
	
	@Bean
	public Soldier soldier2() {
		Soldier soldier = new Soldier();
		soldier.setName("박중사");
		soldier.setGun(Gun2());
		Map<String, String> army = new HashMap<String, String>();
		army.put("name", "이기자");
		army.put("location", "화천");
		soldier.setArmy(army);
		
		return soldier;
		
	}
}
