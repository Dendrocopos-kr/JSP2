package com.koreait.board.db;

import java.sql.*;
import java.util.*;

import com.koreait.board.vo.BoardVO;

public class BoardDAO {
	public static List<BoardVO> selBoardList(){
		List <BoardVO> list = new ArrayList<BoardVO>();
		
		insert_data_All(list);

		return list;
	}
	
	private static void insert_data_All(List <BoardVO> list) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select id_board, title, r_dt, id_student from t_board order by id_board DESC";
		
		try {
			conn = DBConnection.getConn();
			ps = conn.prepareStatement(sql);
			System.out.println("completed SQL");
			
			rs = ps.executeQuery();
			System.out.println("Succeded SelectQuery");
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setId_board( rs.getInt("id_board") );
				vo.setTitle( rs.getNString("title") );
				//vo.setCtnt( rs.getNString("ctnt") );
				vo.setR_dt( rs.getNString("r_dt") );
				vo.setId_student( rs.getInt("id_student") );
				
				list.add( vo );
			}
			System.out.println("completed list");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, ps, rs);
		}
	}
}
