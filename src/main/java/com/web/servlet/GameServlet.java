package com.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dto.GameDTO;
import com.web.service.GameService;

@WebServlet(urlPatterns = "/game/*")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GameService gameService = new GameService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/") + 1;
		String cmd = uri.substring(idx);
		if ("game-list".equals(cmd)) {
			List<GameDTO> games = gameService.selectGames();
			System.out.println(games);
			request.setAttribute("games", games);
		} else if ("game-view".equals(cmd)) {
			
		}
		RequestDispatcher rd =request.getRequestDispatcher("/WEB-INF/views" + uri + ".jsp"); // /game/game-list
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/") + 1;
		String cmd = uri.substring(idx);
		if("insert".equals(cmd)) {
			
		}else if("update".equals(cmd)) {
			
		}else if("delete".equals(cmd)) {
			
		}
	}

}
