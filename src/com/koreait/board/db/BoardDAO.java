package com.koreait.board.db;

import java.sql.*;
import java.util.*;

import com.koreait.board.vo.BoardVO;

public class BoardDAO {
	private static List <BoardVO> list = null;
	
	public static List<BoardVO> selBoardList(){
		 
		String sql = " select id_board, title, r_dt, id_student from t_board order by id_board DESC";
		sql = " select id_board,title,r_dt,nm from VIEW_BOARD_LIKE order by id_board DESC ";
		return insert_data(sql);
	}
	
	private static List<BoardVO> insert_data(String sql) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		list = new ArrayList<BoardVO>();
		
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
				//vo.setId_student( rs.getInt("id_student") );
				vo.setId_name(rs.getNString("nm"));
				
				list.add( vo );
			}
			System.out.println("completed list");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, ps, rs);
		}
		
		return list;
	}
}
