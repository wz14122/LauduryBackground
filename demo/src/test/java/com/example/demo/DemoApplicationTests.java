package com.example.demo;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		User user = new User("wz", "123");
		HashMap<String, User> map = new HashMap<>();
		map.put("1", user);
		System.out.println(map);
	}

}
