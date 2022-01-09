package xyz.itwill10.dao;

import xyz.itwill10.dto.PointUser;

// mapper(�������̽�) �� DAO �޼ҵ尡 ���� ��찡 ����
public interface PointUserDAO {
	int insertPointUser(PointUser user);
	int updatePlusPointUser(String id);
	int updateMinusPointUser(String id);
	PointUser selectPointUser(String id);
}
