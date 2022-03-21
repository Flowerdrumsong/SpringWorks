package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		// 1.Spring 컨테이너를 구동한다.
		AbstractApplicationContext container=
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2.Spring 컨테이너로부터 BoardServieImpl 객체를 lookup한다.
		// xml 파일에 빈(객체)을 가져옴
		BoardService boardService=(BoardService) container.getBean("boardService");
		
		// 3. 글 등록 기능 테스트
		// 객체 가지고 와서, 셋팅하고 메서드에 담아보냄
		BoardVO vo=new BoardVO();
		vo.setSeq(1);
		vo.setTitle("타...");
		vo.setWriter("작...");
		vo.setContent("컨...");
		boardService.insertBoard(vo);
		
		// 4. 글 목록 검색 기능 테스트
		List<BoardVO> boardList=boardService.getBoardList(vo);
		for(BoardVO board:boardList) {
			System.out.println("---> "+board.toString());
		}
		
		// 글 수정작업하기 update board set title=?, content=? where seq=?"
		// 컬럼 내용이 append 되므로,, 쿼리문 <=> set메서드가 매칭되지 않으면 앞서 셋팅한 값들이 들어갈 수 있음.
		// 그래서 BoardVO vo1=new BoardVO(); 다시 객체 생성을 하든지
		// 있는 컬럼들을 전부 다 셋팅해주기
		vo.setTitle("수정타이틀");
		vo.setContent("수정 내용");
		vo.setSeq(3);
		boardService.updateBoard(vo);
		
		// 글 삭제 작업하기 delete from board where seq=?
		vo.setSeq(4);
		boardService.deleteBoard(vo);
		
		// 글 하나만 선택해서 조회하기 select * from board where seq=?
		vo.setSeq(2);
		System.out.println("2번 글: "+boardService.getBoard(vo));
		
		
		// 업데이트 했으니, 새롭게 받아서 출력해야 함
		boardList=boardService.getBoardList(vo);
		for(BoardVO board:boardList) {
			System.out.println("---> "+board.toString());
		}
		
		// 5. Spring 컨테이너 종료
		container.close();
	}

}
