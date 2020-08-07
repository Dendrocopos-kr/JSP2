package com.koreait.board.vo;

public class BoardVO {
	
	private int id_board;
	private String title;
	private String ctnt;
	private String r_dt;
	private int id_student;
	private String id_name;
	
	public int getId_board() {return id_board;}
	public void setId_board(int id_board) {this.id_board = id_board;}
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	public String getCtnt() {return ctnt;}
	public void setCtnt(String ctnt) {this.ctnt = ctnt;}
	public String getR_dt() {return r_dt;}
	public void setR_dt(String r_dt) {this.r_dt = r_dt;}
	public int getId_student() {return id_student;}
	public void setId_student(int id_student) {this.id_student = id_student;}
	public String getId_name() {return id_name;}
	public void setId_name(String id_name) {this.id_name = id_name;}
}
