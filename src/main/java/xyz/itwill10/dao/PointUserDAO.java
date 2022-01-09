package xyz.itwill10.dao;

import xyz.itwill10.dto.PointUser;

// mapper(인터페이스) 와 DAO 메소드가 같은 경우가 많다
public interface PointUserDAO {
	int insertPointUser(PointUser user);
	int updatePlusPointUser(String id);
	int updateMinusPointUser(String id);
	PointUser selectPointUser(String id);
}
