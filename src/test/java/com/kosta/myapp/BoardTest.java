package com.kosta.myapp;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jayway.jsonpath.Option;
import com.kosta.myapp.repository.BoardRepository;
import com.kosta.myapp.vo.BoardVO;

@SpringBootTest
public class BoardTest {
	
	@Autowired //멤버변수로 사용
	BoardRepository boardRepo;
	
	@Test
	public void selectByGrater() {
		boardRepo.findByBnoGreaterThan(110L).forEach(b->{
			System.out.println(b);
		});
	}
	//@Test
	public void selectByContaining() {
		boardRepo.findByTitleContaining("제목").forEach(b->{
			System.out.println(b);
		});
	}
	
	//@Test
	public void selectByLike() {
		boardRepo.findByTitleLike("%제목%").forEach(b->{
			System.out.println(b);
		});
	}
	
	//@Test
	public void selectByTitleAndWriter() {
		boardRepo.findByTitleAndWriter("title update","KIM").forEach(b->{
			System.out.println(b);
		});
	}
	//@Test
	public void selectByWriter() {
		boardRepo.findByWriter("KIM").forEach(b->{
			System.out.println(b);
		});
	}
	//@Test
	public void selectByTitle() {
		boardRepo.findByTitle("title update").forEach(b->{
			System.out.println(b);
		});
	}
	
	//@Test
	public void countAndExists() {
		
		Long cnt = boardRepo.count();
		System.out.println("board table의 전체 건수 : " + cnt);
		
		boolean result = boardRepo.existsById(1L);
		System.out.println(result? "존재함" : "존재하지 않음");
	}
	
	//수정
	//@Test
	public void test6() {
		boardRepo.findById(2L).ifPresentOrElse(board->{
			board.setTitle("title update");
			board.setContent("content update");
			board.setWriter("KIM");
			boardRepo.save(board); //save는 수정과 입력을 같이함
		}, ()->{
			BoardVO board = BoardVO.builder()
					.title("제목new")
					.content("내용new")
					.writer("KIM")
					.build();
			boardRepo.save(board); //save는 수정과 입력을 같이함
		});
				
		
	}
	
	
	
	
	//1건조회
	//@Test
	public void test5() {
		Optional<BoardVO> board = boardRepo.findById(1L);
		if(board.isPresent()) {
			BoardVO b = board.get();
			System.out.println(b);
		} else {
			System.out.println("존재하지 않는 게시글입니다.");
		}
	}
	
	// @Test
	public void test4() {
		boardRepo.findById(1L).ifPresentOrElse(board->{
			System.out.println(board);
		}, ()->{
			System.out.println("존재하지 않는 게시글입니다.");
		});
	}
	//@Test
	public void test3() {
		boardRepo.findById(101L).ifPresent(board->{
			System.out.println(board);
			
		});
	}
	
	
	//셀렉트(findAll)
	//@Test
	public void test2() {
		List<BoardVO> boardList = (List<BoardVO>)boardRepo.findAll();
		boardList.forEach(board->{
			System.out.println(board);
		});
	}
	
	
	//테이블 생성
	//@Test
	public void test1() {
		
		IntStream.rangeClosed(1, 100).forEach(i->{
			
			BoardVO board = BoardVO.builder()
					.title("제목입력" + i)
					.content("내용" + i)
					.writer("Hong")
					.build();
			
			boardRepo.save(board); //insert into t_boards values()
		});
	}
	

}
