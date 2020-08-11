package com.koreait.board.db;

import java.sql.*;
import java.util.*;

import com.koreait.board.vo.BoardVO;

public class BoardDAO {
	private static List<BoardVO> list = null;

	public static List<BoardVO> selBoardList() {

		String sql = " select id_board, title, r_dt, id_student from t_board order by id_board DESC";
		sql = " select id_board,title,r_dt,nm from VIEW_BOARD_LIKE order by id_board DESC ";
		return sel_BoardList_SQL(sql);
	}
	private static List<BoardVO> sel_BoardList_SQL(String sql) {

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

			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setId_board(rs.getInt("id_board"));
				vo.setTitle(rs.getNString("title"));
				// vo.setCtnt( rs.getNString("ctnt") );
				vo.setR_dt(rs.getNString("r_dt"));
				// vo.setId_student( rs.getInt("id_student") );
				vo.setId_name(rs.getNString("nm"));

				list.add(vo);
			}
			System.out.println("completed list");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, ps, rs);
		}

		return list;
	}

	public static BoardVO selBoard(final BoardVO param) {
		String sql = " SELECT "

				+ " id_board " + ", title " + ", ctnt" + ", r_dt " + ", id_student " + ", nm"

				+ " FROM " + " VIEW_BOARD_LIKE "

				+ " WHERE " + " id_board=?";

		return sel_Board_SQL(param, sql);
	}
	private static BoardVO sel_Board_SQL(final BoardVO param, String sql) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO vo = null;

		try {
			conn = DBConnection.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, param.getId_board());
			System.out.println("completed SQL");

			rs = ps.executeQuery();
			System.out.println("Succeded SelectQuery");

			while (rs.next()) {
				vo = new BoardVO();
				vo.setId_board(rs.getInt("id_board"));
				vo.setTitle(rs.getNString("title"));
				vo.setCtnt(rs.getNString("ctnt"));
				vo.setR_dt(rs.getNString("r_dt"));
				vo.setId_student(rs.getInt("id_student"));
				vo.setId_name(rs.getNString("nm"));

			}
			System.out.println("completed Board data");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, ps, rs);
		}
		return vo;
	}

	public static int insert_Mod(BoardVO param) {
		String sql = " insert into" + " t_board (id_board,title,ctnt,id_student)" + " VALUES"
				+ " (seq_board.nextval,?,?,?) ";
		return insert_SQL(param, sql);
	}
	private static int insert_SQL(BoardVO param, String sql) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = -1;

		try {
			conn = DBConnection.getConn();
			ps = conn.prepareStatement(sql);
			// (?순서 , value)
			ps.setNString(1, param.getTitle());
			ps.setNString(2, param.getCtnt());
			int iName = -1;
			iName = param.getId_student();
			ps.setInt(3, iName);
			System.out.println("completed SQL");
			// ps.setString(1 , String) // (?순서, String)
//			if(ps.execute()) {
//				rs = ps.executeUpdate();	
//				//두번실행
//			}
			rs = ps.executeUpdate();
			System.out.println("Succeded '" + rs + "' InsertQuery");
			// select => executeQuery();
			// 그 외는 다른거
			// board.setId_board(rs.getInt("ID_BOARD"));
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return rs;
		} finally {
			DBConnection.close(conn, ps);
		}
	}

	public static int update_Mod(BoardVO param) {
		String sql = " update" + " t_board" + " set" + " title = ?, ctnt = ?, id_student = ?" + " where"
				+ " id_board = ? ";
		return update_SQL(param, sql);
	}
	private static int update_SQL(BoardVO param, String sql) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = -1;

		try {
			conn = DBConnection.getConn();
			ps = conn.prepareStatement(sql);
			// (?순서 , value)
			ps.setNString(1, param.getTitle());
			ps.setNString(2, param.getCtnt());
			int iName = -1;
			iName = param.getId_student();
			ps.setInt(3, iName);
			ps.setInt(4, param.getId_board());
			System.out.println("completed SQL");
			// ps.setString(1 , String) // (?순서, String)
			rs = ps.executeUpdate();
			System.out.println("Succeded '" + rs + "' UpdateQuery");
			// select => executeQuery();
			// 그 외는 다른거
			// board.setId_board(rs.getInt("ID_BOARD"));
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return rs;
		} finally {
			DBConnection.close(conn, ps);
		}
	}

	public static int delete_Board(BoardVO param) {
		String sql = "delete" + " from" + " t_board" + " where" + " id_board =? ";
		return delete_Board_SQL(param, sql);
	}
	private static int delete_Board_SQL(BoardVO param, String sql) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = -1;
		try {
			conn = DBConnection.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, param.getId_board());
			System.out.println("completed SQL");
			rs = ps.executeUpdate();
			System.out.println("Succeded '" + rs + "' DeleteQuery");
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return rs;
		} finally {
			DBConnection.close(conn, ps);
		}
	}
}
