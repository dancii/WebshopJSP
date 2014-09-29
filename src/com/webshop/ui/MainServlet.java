package com.webshop.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webshop.bo.UserHandler;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String checkFunc=request.getParameter("checkFunc");
		HttpSession session = request.getSession();
		
		if(checkFunc.equals("login")){
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			String legit = UserHandler.checkIfLegit(username, password);
			
			if(legit.equals("Error")){
				response.getOutputStream().print("NEEEEEEJ!!!!");
				session=null;
			}else{
				session.setAttribute("username", username);
				session.setMaxInactiveInterval(60*15);
				response.sendRedirect("index.jsp");
			}
		}else if(checkFunc.equals("register")){
			
		}
		
	}

}
