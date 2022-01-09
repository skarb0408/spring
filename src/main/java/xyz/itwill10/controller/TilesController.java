package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Tiles : ���ø� �������� �̿��� ����Ʈ ������ �����ϴ� ���α׷�
// 1 . Tiles ���� ���̺귯���� ���� ó�� - pom.xml
// 2. ��û ó�� �޼ҵ忡�� ��ȯ�Ǵ� ViewName�� Tiles ���α׷����� ����ǵ��� ViewResolver ���� >> servlet-context.xml
// 3. Tiles Configuration File (Tiles.xml) �ۼ� >> ��û ó�� �޼ҵ忡�� ��ȯ�Ǵ� ViewName�� ���� ���� ���ø� ������ ����
@Controller
public class TilesController {
	@RequestMapping("/")
	public String tiles() {
		return "main";
	}
	
	@RequestMapping("/admin")
	public String admin( ) {
		return "admin";
	}
	
	@RequestMapping("/admin/member")
	public String tilesAdminMember() {
		return "admin/member_manager";
	}
}
