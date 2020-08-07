package com.koreait.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.koreait.board.vo.BoardVO;

public class BoardRegmodDAO {
	public static boolean insert_Mod(BoardVO vo) {
		String sql = " insert into" + " t_board (id_board,title,ctnt,id_student)"
				+ " select nvl(max(id_board),0)+1,?,?,?" + " from t_board";
		return insert_SQL(vo, sql);
	}
	
	private static boolean insert_SQL(BoardVO vo, String sql) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;

		try {
			conn = DBConnection.getConn();
			ps = conn.prepareStatement(sql);
			// (?순서 , value)
			ps.setNString(1, vo.getTitle());
			ps.setNString(2, vo.getCtnt());
			int iName = -1;
			iName = vo.getId_student();
			ps.setInt(3, iName);
			System.out.println("completed SQL");
			// ps.setString(1 , String) // (?순서, String)
			rs = ps.executeUpdate();
			System.out.println("Succeded '"+rs+"' InsertQuery");
			// select => executeQuery();
			// 그 외는 다른거
			// board.setId_board(rs.getInt("ID_BOARD"));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBConnection.close(conn, ps);
		}
	}
	

	public static boolean update_Mod(BoardVO vo) {
		String sql = " update"
				+ " t_board"
				+ " set"
				+ " title = ?"
				+ ", ctnt = ?"
				+ ", id_student = ?"
				+ " where"
				+ " id_board = ? ";
		return update_SQL(vo,sql);
	}
	
	private static boolean update_SQL(BoardVO vo, String sql) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;

		try {
			conn = DBConnection.getConn();
			ps = conn.prepareStatement(sql);
			// (?순서 , value)
			ps.setNString(1, vo.getTitle());
			ps.setNString(2, vo.getCtnt());
			int iName = -1;
			iName = vo.getId_student();
			ps.setInt(3, iName);
			ps.setInt(4, vo.getId_board());
			System.out.println("completed SQL");
			// ps.setString(1 , String) // (?순서, String)
			rs = ps.executeUpdate();
			System.out.println("Succeded '"+rs+"' UpdateQuery");
			// select => executeQuery();
			// 그 외는 다른거
			// board.setId_board(rs.getInt("ID_BOARD"));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBConnection.close(conn, ps);
		}
	}

}
