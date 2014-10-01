package com.webshop.ui;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webshop.bo.CartItem;
import com.webshop.bo.ItemHandler;
import com.webshop.bo.ItemInfo;
import com.webshop.bo.ShoppingCart;
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
				session.setAttribute("loginFailed", "loginFailed");
				response.sendRedirect("login.jsp");
			}else{
				session.setAttribute("username", username);
				session.setMaxInactiveInterval(60*15);
				response.sendRedirect("index.jsp");
			}
		}else if(checkFunc.equals("searchItemByName")){
			
			String searchItemByName=request.getParameter("search");
			ArrayList<ItemInfo> items = ItemHandler.getItemByName(searchItemByName);
			if(items.isEmpty()){
				response.sendRedirect("search.jsp");
			}else{
				request.setAttribute("itemsList", items);
				RequestDispatcher rd=request.getRequestDispatcher("/search.jsp");
				rd.forward(request,response);
			}
			
		}else if(checkFunc.equals("buyItemById")){
			String buyItemId=request.getParameter("itemId");
			String buyItemName=request.getParameter("itemName");
			String buyItemPrice=request.getParameter("itemPrice");
			ShoppingCart.addItem(new CartItem(Integer.parseInt(buyItemId), buyItemName, Float.parseFloat(buyItemPrice)));
			
			session.setAttribute("shoppingCart", ShoppingCart.getCartList());
			session.setMaxInactiveInterval(60*5);
			response.sendRedirect("shoppingCart.jsp");
		}else if(checkFunc.equals("removeItemCart")){
			
			String removeCartItemId=request.getParameter("itemIdRemove");
			
			ShoppingCart.removeItem(Integer.parseInt(removeCartItemId));
			if(ShoppingCart.getCartList().isEmpty()){
				session.setAttribute("shoppingCart", null);
			}
			response.sendRedirect("shoppingCart.jsp");
		}else if(checkFunc.equals("findItemsByCategory")){
			
			String categoryName=request.getParameter("searchItemByCategory");
			ArrayList<ItemInfo> items=ItemHandler.getItemByCategory(categoryName);
			
			if(items.isEmpty()){
				response.sendRedirect("search.jsp");
			}else{
				request.setAttribute("itemsList", items);
				request.setAttribute("categoryName", items.get(0).getCategory());
				RequestDispatcher rd=request.getRequestDispatcher("/search.jsp");
				rd.forward(request,response);
			}
			
		}
		
	}

}
