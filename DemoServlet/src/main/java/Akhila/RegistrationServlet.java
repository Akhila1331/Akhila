package Akhila;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("name");
		int phno=Integer.parseInt(request.getParameter("phno"));
		String email=request.getParameter("email");
		String password=request.getParameter("password");try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			String sql="insert into Registration values(?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,name);
			pst.setInt(2, phno);
			pst.setString(3, email);
			pst.setString(4,password);
			int i=pst.executeUpdate();
			if(i!=0) 
				pw.println("registered successfully");
			
			else 
				pw.println("register again");
		}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
				
			}
			catch(SQLException e) {
				e.printStackTrace();
		
	}
}}