package com.goodee.test.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.goodee.test.domain.BoardDTO;

public class BoardRepository {
	
	private DataSource dataSource;
	
	public BoardRepository() {
	
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc:oracle");
		}catch(NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if(con!=null) con.close();
			if(ps!=null) ps.close();
			if(rs!=null) rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//BoardRepository의 메소드 이름
	
	public List<BoardDTO> selectBoards(){
		List<BoardDTO> boards = new ArrayList<>();
		try {
			con = dataSource.getConnection();
			sql = "SELECT NO, WRITER, TITLE, CONTENT, IP, HIT, CREATED, LASTMODIFIED FROM BOARD ORDER BY BOARD_NO";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardDTO board = new BoardDTO(
						rs.getLong(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getLong(6),
						rs.getString(7),
						rs.getString(8));
						boards.add(board);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return boards;
	}
	
	public BoardDTO selectBoardByNo(Long board_no) {
		BoardDTO board = null;
		try {
			con = dataSource.getConnection();
			sql = "SELECT NO, WRITER, TITLE, CONTENT, IP, HIT, CREATED, LASTMODIFIED FROM BOARD WHERE BOARD_NO =?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, board_no);
			rs = ps.executeQuery();
			if(rs.next()) {
				board = new BoardDTO(
						rs.getLong(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getLong(6),
						rs.getString(7),
						rs.getString(8));
						
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con,ps,rs);
		}
		return board;
	}
	
	public int insertBoard(BoardDTO board) {
		int res = 0;
		try {
			con = dataSource.getConnection();
			sql = "INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, IP, HIT, TO_CHAR(SYSDATE, 'YYYY-MM-DD'), TO_CHAR(SYSDATE, 'YYYY-MM-DD'))";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getWriter());
			ps.setString(2, board.getTitle());
			ps.setString(3, board.getContent());
			res = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return res;
	}
	
	public int updateBoard(BoardDTO board) {
		int res = 0;
		try {
			con = dataSource.getConnection();
			sql = "UPDATE BOARD SET TITLE =?, CONTENT=? WHERE NO =?";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getContent());
			ps.setLong(3, board.getNo());
			res = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return res;
	}
	
}	
