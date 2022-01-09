package xyz.itwill.controller;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import xyz.itwill10.dto.PointBoard;
import xyz.itwill10.dto.PointUser;
import xyz.itwill10.service.PointBoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
//@FixMethodOrder : �׽�Ʈ �޼ҵ��� ȣ������� �����ϴ� ������̼�
//value �Ӽ� : MethodSorters �ڷ���(Enum)�� ��� �� �ϳ��� �Ӽ������� ����
// => MethodSorters.DEFAULT : �׽�Ʈ �޼ҵ��� �ؽ��ڵ�(�޸� �ּ�)�� �̿��Ͽ� ȣ����� ���� - ȣ����� ��Ȯ��
// => MethodSorters.JVM : �׽�Ʈ �޼ҵ带 JVM�� �ҷ��� ������� ȣ����� ���� - ȣ����� ��Ȯ��
// => MethodSorters.NAME_ASCENDING : �׽�Ʈ �޼ҵ��� �̸����� ȣ����� ���� - ȣ����� Ȯ��
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class PointBoardServiceTest {
	private static final Logger logger=LoggerFactory.getLogger(PointBoardServiceTest.class);
	
	@Autowired
	private PointBoardService pointBoardService;
	
	@Test
	public void testAddPointBoard() {
		PointBoard board=new PointBoard();
		board.setWriter("xxx");
		// �Խñ� �ۼ��ڰ� ���� ��� ���� �߻�
		//  => ����) ���� �߻����� ����� �Խñ� ���� ���� SQL ���� ��� ����
		//  => �ذ���) ���ܰ� �߻��Ǳ� ���� ����� SQL ����� ���(ROLLBACK) ó�� >> TransactionManager �̿�
		board.setSubject("�׽�Ʈ");
		
		PointUser user=pointBoardService.addPointBoard(board);
		logger.info("���̵� = "+user.getId()+", �̸� = "+user.getName()+", ����Ʈ = "+user.getPoint());
	}
	
	@Test
	public void testGetPointBoardList() {
		List<PointBoard> boardList=pointBoardService.getPointBoardList();
		
		if(boardList.isEmpty()) {
			logger.info("����� �Խñ��� �ϳ��� �����ϴ�.");
		} else {
			for(PointBoard board:boardList) {
				logger.info("�۹�ȣ = "+board.getNum()+", �ۼ��� =  "+board.getWriter()
						+", ���� = "+board.getSubject());
			}
		}
	}
	
	/*
	@Test
	public void testErasePointBoard() {
		PointUser user=pointBoardService.erasePointBoard(1);
		logger.info("���̵� = "+user.getId()+", �̸� = "+user.getName()+", ����Ʈ = "+user.getPoint());
	}
	*/
}












