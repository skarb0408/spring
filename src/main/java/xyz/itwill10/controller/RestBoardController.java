package xyz.itwill10.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import xyz.itwill10.dto.RestBoard;
import xyz.itwill10.service.RestBoardService;
import xyz.itwill10.util.Pager;

// REST ����� �����ϴ� ��û ó�� �޼ҵ忡 ���� JSON ���� ����� Ȯ���ϱ� ���� 
// Advanced REST Client ũ�Ҿ��� ��ġ�Ͽ� REST �׽�Ʈ ��� Ȯ�� >> REST Ȯ��

// ��û ó�� �޼ҵ��� ��û ��� >> method �Ӽ���
//  => RequestMethod �ڷ���(Enum)�� ����� �̿��Ͽ� ǥ��
//  => GET(�˻�), POST(����), PUT(��ü ����), PATCH(�κ� ����), DELETE(����) ��

@Controller
// @RestController : ��� ��û ó�� �޼ҵ��� ��ȯ������ ����ǵ��� �����ϴ� ������̼�
//  => ��û ó�� �޼ҵ忡�� @ResponseBody ������̼��� ������� �ʾƵ� �޼ҵ� ��ȯ������ ���� ó��
//  => Rest ���񽺸� �����ϴ� ��Ʈ�ѷ� Ŭ������ �ۼ��� ��� ����Ѵ�.
public class RestBoardController {
	@Autowired
	private RestBoardService restBoardService;
		
	@RequestMapping("/board")
	public String restBoard() {
		return "rest/board";		
	}
	
	// REST_BOARD ���̺� ����� �Խñ� ����� �˻��Ͽ� JSON ������ �ؽ�Ʈ �����ͷ� �����ϴ� �޼ҵ�
	//  => �Խñ� ����� ����¡ ó���� �� �ִ� ������ �־���Ѵ�.				
	@RequestMapping(value = "/board_list", method = RequestMethod.GET)
	@ResponseBody											// �Ѱ� ���� ���� ������ 1�� ����             => ���� ���� ��� ���� ��
	public Map<String, Object> restBoardList(@RequestParam(defaultValue = "1") int pageNum) {
		//System.out.println("pageNum = "+ pageNum);
	
		// REST_BOARD ���̺� ����� ��� �Խñ��� ������ ��ȯ�޾� ����
		int totalBoard= restBoardService.getRestBoardCount();
		int pageSize= 5; // �� �������� ��µ� �Խñ��� ���� => �Է����� ���޹޾Ƶ��� >> �Խñ�
		int blockSize= 5; // �� ���� ��µ� �������� ���� ���� >> ������ ��ȣ(������ ��)
		
		// ����¡ ó�� ���� ���� �����ϴ� Pager ��ü�� �����Ͽ� ����
		Pager pager= new Pager(pageNum, totalBoard, pageSize, blockSize);
		
		// RestBoardService Ŭ������ �޼ҵ� ȣ���� ���� �Ű������� �����ϱ� ���� Map ��ü ����
		//  => ��û �������� ���� ���ȣ�� ���� ���ȣ�� Map ��ü�� ��Ʈ���� �����Ͽ� SQL ��� ~~
		Map<String, Object> pagerMap= new HashMap<String, Object>();
		pagerMap.put("startRow", pager.getStartRow());
		pagerMap.put("endRow", pager.getEndRow());
		
		// ��û ó�� �޼ҵ��� ��ȯ���� ����ϴ� Map ��ü ����
		//  => �Խñ� ��ϰ� ����¡ ó�� ���� ���� Map ��ü�� ��Ʈ���� �����Ͽ� ��ȯ�Ѵ�. >> JSON ��ȯ
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("restBoardList", restBoardService.getRestBoardList(pagerMap));
		returnMap.put("pager", pager);
		
		return returnMap;
	}
	
	// �Խñ��� ���޹޾� REST_BOARD ���̺� �����Ͽ� �����ϰ� �ؽ�Ʈ�� �����ϴ� ��û ó�� �޼ҵ�
	//  => @RequestBody ������̼��� �̿��Ͽ� ��� ���ް��� �Ű������� ����
	//  => �Ű������� �ڷ����� JavaBean�� ��� ���ް��� �̸��� ���� �̸��� �ʵ忡 ���ް� �ڵ� ����
	@RequestMapping(value = "/board_add", method = RequestMethod.POST)
	@ResponseBody
	public String restBoardAdd(@RequestBody RestBoard board) {
		// HtmlUtils.htmlEscape(String str) : �Ű������� ���޹��� ���ڿ����� HTML �±� ���� ���ڸ� Excape ���ڷ� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ� >> XSS ���ݿ� ���� ����
		board.setContent(HtmlUtils.htmlEscape(board.getContent()));
		restBoardService.addRestBoard(board);
		return "success";
	}
	/*
	// �۹�ȣ�� ���޹޾� REST_BOARD ���̺� ����� �ش� �۹�ȣ�� �Խñ��� �˻��Ͽ� JSON ������ �ؽ�Ʈ�� �����ϴ� ��û ó�� �޼ҵ�
	//  => Query String�� �̿��Ͽ� �۹�ȣ ����
	@RequestMapping(value = "/board_view", method = RequestMethod.GET)
	@ResponseBody
	public RestBoard restBoardView(@RequestParam int num) {
		return restBoardService.getRestBoard(num);
	}
	*/
	
	// �۹�ȣ�� ���޹޾� REST_BOARD ���̺� ����� �ش� �۹�ȣ�� �Խñ��� �˻��Ͽ� JSON ������ �ؽ�Ʈ�� �����ϴ� ��û ó�� �޼ҵ�
	//  => ��û URL �ּҸ� �̿��Ͽ� �۹�ȣ ����
	// @RequestMapping ������̼ǿ��� ���ε� ��û URL �ּҿ� {������(�̸�)} �������� ���� ǥ���Ͽ� ��û�Ѵ�.
	//  => @PathVariable ������̼��� ����Ͽ� URL �ּҸ� ������ �����޾� �Ű������� �����Ѵ�.
	//  => �ĺ��ڸ� ���޹޾� �˻��ϰų� ������ �� ���
	@RequestMapping(value = "/board_view/{num}", method = RequestMethod.GET)
	@ResponseBody
	// @PathVariable : ��û URL �ּҷ� ǥ���� ���� ���޹޾� �Ű������� �����ϴ� ������̼�
	//  => ��û URL �ּҿ� ǥ���� ������� �Ű������� �̸��� �����ؾ߸� ���� ���޹޾� ����
	//  => @PathVariable ������̼��� value �Ӽ������� ��û URL �ּҷ� ǥ���� ������ ���� ����
	public RestBoard restBoardView(@PathVariable int num) {
		return restBoardService.getRestBoard(num);
	}
	
	// �Խñ��� ���޹޾� REST_BOARD ���̺� ����� �Խñ��� �����ϰ� �ؽ�Ʈ�� �����ϴ� ��û ó�� �޼ҵ�
	//  => method �Ӽ����� �������� ��� method �Ӽ����� {} �ȿ� �����Ͽ� �ۼ�
	@RequestMapping(value = "/board_modify", method = {RequestMethod.PUT, RequestMethod.PATCH})
	@ResponseBody
	public String restBoardModify(@RequestBody RestBoard board) {
		restBoardService.modifyRestBoard(board);
		return "success";
	}
	
	// �۹�ȣ�� ���޹޾� REST_BOARD ���̺� ����� �ش� �۹�ȣ�� �Խñ��� �����ϰ� �ؽ�Ʈ�� �����ϴ� ��û ó�� �޼ҵ�
	//  => ��û URL �ּҸ� �̿��Ͽ� �۹�ȣ ����
	@RequestMapping(value = "/board_remove/{num}", method = RequestMethod.DELETE)
	@ResponseBody
	public String restBoardRemove(@PathVariable int num) {
		restBoardService.removeRestBoard(num);
		return "success";
	}
	
	

}
