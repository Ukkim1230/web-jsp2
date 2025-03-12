package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.common.DBCon;
import com.web.dto.GameDTO;

public class GameDAO {
	public List<GameDTO> selectGames(GameDTO game){
		List<GameDTO> games = new ArrayList<>();
		String sql = "select GI_NUM, GI_NAME, GI_PRICE, GI_GENRE, GI_DESC from GAME_INFO";
		try(Connection con = DBCon.getCon();
				PreparedStatement ps = con.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				GameDTO g = new GameDTO();
				g.setGiNum(rs.getInt("GI_NUM"));
				g.setGiName(rs.getString("GI_NAME"));
				g.setGiPrice(rs.getInt("GI_PRICE"));
				g.setGiGenre(rs.getString("GI_GENRE"));
				g.setGiDesc(rs.getString("GI_DESC"));
				games.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return games;
	}
	public GameDTO selectGame(int giNum) {
		String sql = "select GI_NUM, GI_NAME, GI_PRICE, GI_GENRE, GI_DESC from GAME_INFO\r\n"
				+ "where GI_NUM=?";
		try(Connection con = DBCon.getCon();
				PreparedStatement ps = con.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				GameDTO g = new GameDTO();
				g.setGiNum(rs.getInt("GI_NUM"));
				g.setGiName(rs.getString("GI_NAME"));
				g.setGiPrice(rs.getInt("GI_PRICE"));
				g.setGiGenre(rs.getString("GI_GENRE"));
				g.setGiDesc(rs.getString("GI_DESC"));
				return g;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public int insertGame(GameDTO game) {
		String sql ="insert into GAME_INFO(GI_NAME, GI_PRICE, GI_GENRE, GI_DESC)\r\n"
				+ " values(?,?,?,?)";
		try(Connection con = DBCon.getCon();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, game.getGiName());
			ps.setInt(2, game.getGiPrice());
			ps.setString(3, game.getGiGenre());
			ps.setString(4, game.getGiDesc());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int updateGame(GameDTO game) {
		String sql ="update GAME_INFO\r\n"
				+ "set GI_NAME = ?,\r\n"
				+ "GI_PRICE = ?,\r\n"
				+ "GI_GENRE =?,\r\n"
				+ "GI_DESC = ?\r\n"
				+ "where GI_NUM=?";
		try(Connection con = DBCon.getCon();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, game.getGiName());
			ps.setInt(2, game.getGiPrice());
			ps.setString(3, game.getGiGenre());
			ps.setString(4, game.getGiDesc());
			ps.setInt(5, game.getGiNum());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int deleteGame(int giNum) {
		String sql = "DELETE FROM GAME_INFO WHERE GI_NUM=?";
		try(Connection con = DBCon.getCon();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, giNum);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static void main(String[] args) {
		GameDAO gameDAO = new GameDAO();
		GameDTO game = new GameDTO();
		game.setGiName("GTA");
		game.setGiPrice(400);
		game.setGiGenre("비디오");
		game.setGiDesc("자유도");
		game.setGiNum(1);
		int result = gameDAO.insertGame(game);
		System.out.println(result);
	}

}
