package com.hanul.middle;

import org.springframework.stereotype.Component;

// 그냥 쓰면 null, 메모리에 올리는 방법이 있다 => Spring annotation)

@Component(value="bean")
public class TestBean {
	public TestBean() {
		System.out.println("Autowired가 되었다. 나는 null이 아니다.");
	}
}
