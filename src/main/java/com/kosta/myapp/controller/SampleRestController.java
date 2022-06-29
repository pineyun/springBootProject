package com.kosta.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosta.myapp.vo.CarVO;

@RestController
public class SampleRestController {
	
	@GetMapping("/carlist.do")
	public List<CarVO> getCarList(){
		List<CarVO> carlist = new ArrayList<>();
		CarVO c1 = new CarVO(1L, "ABC", 1000, "BLACK");
		CarVO c2 = new CarVO(2L, "CCC", 1000, "RED");
		CarVO c3 = new CarVO(3L, "YNF", 1000, "BLUE");
		CarVO c4 = CarVO.builder()
				.model("TEV")
				.price(5300)
				.color("WHITE")
				.build();
		
		carlist.add(c1);
		carlist.add(c2);
		carlist.add(c3);
		carlist.add(c4);
		
		return carlist;
	}
	


}
