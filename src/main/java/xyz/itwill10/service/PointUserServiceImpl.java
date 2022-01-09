package xyz.itwill10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.itwill10.dao.PointUserDAO;
import xyz.itwill10.dto.PointUser;

@Service
public class PointUserServiceImpl implements PointUserService {
	@Autowired
	private PointUserDAO pointUserDAO;
	
	
	// 사용자 정보를 전달받아 pointuser 테이블에 삽입하고 저장하고 저장된 정보를 검색하여 반환하는 메소드
	@Override
	public PointUser addPointUser(PointUser user) {
		// 전달받은 사용자 정보가 중복될 경우 예외 발생 >> 아이디 중복 검사
		//  => 예외가 발생된 경우 하단에 작성된 명령 미 실행 >> 예외 발생 시 스레드 종료
		if(pointUserDAO.selectPointUser(user.getId())!=null) {
			throw new RuntimeException("이미 사용 중인 아이디");
		}
		pointUserDAO.insertPointUser(user); // 정보 추가
		return pointUserDAO.selectPointUser(user.getId()); // 정보 검색
	}
	
}
