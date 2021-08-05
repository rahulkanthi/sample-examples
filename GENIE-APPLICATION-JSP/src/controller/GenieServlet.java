package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GenieDao;
import model.Genie;

/**
 * Servlet implementation class AddGenie
 */
@WebServlet("/")
public class GenieServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	GenieDao gd = new GenieDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getServletPath();
	
		
		PrintWriter out = response.getWriter();
		
		if(action.equals("/AddGenie"))
		{

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String severity = request.getParameter("severity");
		String description = request.getParameter("description");

		Genie g = new Genie(id, name, category, severity, description);
		
		gd.inertGenie(g);
		
		
		request.setAttribute("ans", "Successfully Inserted !!");
		
		RequestDispatcher rd=request.getRequestDispatcher("AddGenie.jsp");
		
		rd.forward(request, response);
		
		}
		else if(action.equals("/GetGenie")){
		
			List<Genie> genie=gd.getAllGenie();
			
			request.setAttribute("genies",genie);
			
			RequestDispatcher rd=request.getRequestDispatcher("GetGenie.jsp");
			
			rd.forward(request, response);
			
		}
		else if(action.equals("/GetGenieById")){
			
			int id=Integer.parseInt(request.getParameter("id"));
			
			Genie ans=gd.selectGenie(id);
			
			request.setAttribute("genie",ans);
			RequestDispatcher rd=request.getRequestDispatcher("GetGenieById.jsp");
			rd.forward(request, response);
			
		}
		else if(action.equals("/UpdateGenieById"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			String severity=request.getParameter("severity");
			
			try {
				boolean ans=gd.updateGenie(id, severity);
				if(ans){
					String message="Severity Updated Successfully";
					request.setAttribute("msg", message);
					RequestDispatcher rd=request.getRequestDispatcher("UpdateGenieById.jsp");
					rd.forward(request, response);
				}
				else{
					String message="Id not Found !!";
					request.setAttribute("msg", message);
					RequestDispatcher rd=request.getRequestDispatcher("UpdateGenieById.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				out.print("Unable to Update.....!! Exception occured");
			}
				
		}
		
		else if(action.equals("/DeleteGenieById")){
			
			
			int id=Integer.parseInt(request.getParameter("id"));
			
			
			try {
				boolean ans=gd.deleteGenie(id);
				if(ans){
					String message="Genie Deleted Successfully";
					request.setAttribute("msg", message);
					RequestDispatcher rd=request.getRequestDispatcher("DeleteGenieById.jsp");
					rd.forward(request, response);
				}
				else{
					String message="Id not Found !!!";
					request.setAttribute("msg", message);
					RequestDispatcher rd=request.getRequestDispatcher("DeleteGenieById.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				out.println("Unable to Delete !!");
			}
			
		}
		
		
	}

}
