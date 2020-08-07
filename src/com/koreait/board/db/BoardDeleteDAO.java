package com.koreait.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.koreait.board.vo.BoardVO;

public class BoardDeleteDAO {
	public static int boardDelete(BoardVO param) {
		String sql = "delete"
				+ " from"
				+ " t_board"
				+ " where"
				+ " id_board =? ";
		return boardDelete(param,sql);
	}
	
	private static int boardDelete(BoardVO param, String sql) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = -1;
		try {
			conn = DBConnection.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt( 1, param.getId_board() );
			System.out.println("completed SQL");
			rs = ps.executeUpdate();
			System.out.println("Succeded "+rs+" DeleteQuery");	
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return rs;
		}finally {
			DBConnection.close(conn, ps);
		}
	}
}
