package xyz.itwill10.dao;

import java.util.List;
import java.util.Map;

import xyz.itwill10.dto.RestBoard;

public interface RestBoardDAO {
	int insertRestBoard(RestBoard board);
	int updateRestBoard(RestBoard board);
	int deleteRestBoard(int num);
	int selectRestBoardCount(); // 전체행 갯수
	RestBoard selectRestBoard(int num); // 하나 검색
	List<RestBoard> selectRestBoardList(Map<String, Object> map);

}
