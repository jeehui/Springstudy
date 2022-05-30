package com.goodee.history;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.goodee.history.config.DBConfig;
import com.goodee.history.mapper.HistoryMapper;

@RunWith(SpringJUnit4ClassRunner.class)
//DBConfig를 봐야 Mapping이 어딨는지 알 수 있을거야 DBConfig엔 MappingScan이 있으니까!
@ContextConfiguration(classes = {DBConfig.class})
public class HistoryTestCase {
	
	@Autowired
	private HistoryMapper historyMapper;
	
	@Test
	public void 목록테스트() {
		// 5 : 5개이길 바란다. (검사 통과를 위해서)
		//historyMapper.selectHistories() 결과가 5개면 통과!
		assertEquals(5, historyMapper.selectHistories().size()); 
	}
}
