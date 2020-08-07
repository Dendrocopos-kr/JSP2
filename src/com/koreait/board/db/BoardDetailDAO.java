package com.koreait.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.koreait.board.vo.BoardVO;


public class BoardDetailDAO {
	
	public static BoardVO selBoard(final BoardVO param) {
		String sql = " SELECT "
				
				+ " id_board "
				+ ", title "
				+ ", ctnt"
				+ ", r_dt "
				+ ", id_student "
				
				+ " FROM "
				+ " t_board "
				
				+ " WHERE "
				+ " id_board=?";
		
		return insert_data(param,sql);
	}
	
	private static BoardVO insert_data(final BoardVO param,String sql) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO vo = null;
		
		try {
			conn = DBConnection.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt( 1, param.getId_board() );
			System.out.println("completed SQL");
			
			rs = ps.executeQuery();
			System.out.println("Succeded SelectQuery");
			
			while(rs.next()) {
				vo = new BoardVO();
				vo.setId_board( rs.getInt("id_board") );
				vo.setTitle( rs.getNString("title") );
				vo.setCtnt( rs.getNString("ctnt") );
				vo.setR_dt( rs.getNString("r_dt") );
				vo.setId_student( rs.getInt("id_student") );
				
			}
			System.out.println("completed Board data");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, ps, rs);
		}
		return vo;
	}
}