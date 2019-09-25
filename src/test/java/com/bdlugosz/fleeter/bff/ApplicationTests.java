package com.bdlugosz.fleeter.bff;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Test
	public void test123() {
		List<String> list =  new LinkedList<String>(Arrays.asList("1","2","3"));

		List<String> collect = list.stream()
				.map((String e) -> processElement(e, list))
				.collect(Collectors.toList());

	}

	private String processElement(String e, List<String> list) {
		list.remove(e);
		return null;
	}
}

