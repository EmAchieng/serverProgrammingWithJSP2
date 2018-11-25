package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.LoginBiz;
import vo.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public LoginServlet () {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		//(1)
		System.out.println(id);
		
		
		LoginBiz loginBiz = new LoginBiz();
		User user = loginBiz.getUserLogin(id,passwd);
		if(user != null ) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("logInSuccess.jsp");
			dispatcher.forward(request, response);
			//2
			System.out.println(id);	
		}
	}

}
