package xyz.itwill10.service;

import java.util.List;

import xyz.itwill10.dto.PointUser;
import xyz.itwill10.dto.PointBoard;

public interface PointBoardService {
	PointUser addPointBoard(PointBoard board);
	PointUser erasePointBoard(int num);
	List<PointBoard> getPointBoardList();
}
