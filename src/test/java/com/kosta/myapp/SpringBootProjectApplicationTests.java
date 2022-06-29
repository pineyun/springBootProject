package com.kosta.myapp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.kosta.myapp.vo.CarVO;

@SpringBootTest
class SpringBootProjectApplicationTests {

	@Test
	public void test1() {
		CarVO car1 = new CarVO();
		System.out.println(car1);
		
		CarVO car2 = new CarVO(1L, "GMODEL", 100, "BLACK");
		System.out.println(car2);
		
		System.out.println(car2.getModel());
		car2.setColor("blue");
		System.out.println(car2);
		
		CarVO car3 = CarVO.builder()
				.model("ABC모델")
				.price(5000)
				.color("red")
				.build();
		System.out.println(car3.toString());
		
		CarVO car4 = CarVO.builder()
				.model("ABC모델")
				.price(3000)
				.color("red")
				.build();
		
		//주소 비교 -> false
		//equalsandhashcode => true
		System.out.println(car3.equals(car4));
	}

}
