package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import dto.Customer;

@WebServlet("/customersignup")
public class CustomerSignup extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("name");
	long mobile=Long.parseLong(req.getParameter("mobile"));
    String email=req.getParameter("email");
    String password=req.getParameter("password");
    String gender=req.getParameter("gender");
    Date d=Date.valueOf(req.getParameter("dob")); 
    String dob=req.getParameter("dob");
    
    Date date=Date.valueOf(dob);
   
    CustomerDao dao=new CustomerDao();

    
    int age=Period.between(date.toLocalDate(),LocalDate.now()).getYears();
    if(age<18)
    {
    	resp.getWriter().print("<h1>Your not eligible to create an bank account</h1>"
    			+ "<h1>Age is less than 18</h1>");
    	req.getRequestDispatcher("Signup.html").include(req, resp);
    }
    else 
    {
    	if(dao.check(mobile).isEmpty()&&dao.check(email).isEmpty())
		{
		Customer customer=new Customer();
		customer.setName(req.getParameter("name"));
		customer.setGender(req.getParameter("gender"));
		customer.setPassword(req.getParameter("password"));
		customer.setDob(date);
		customer.setEmail(email);
		customer.setMobile(mobile);
		dao.save(customer);
		
		Customer customer2=dao.check(email).get(0);
		resp.getWriter().print("<h1>Account Created Successfully</h1>");
		if(customer2.getGender().equals("male")) {
			
		
			resp.getWriter().print("<h1>Hello Sir</h1>");
			 resp.getWriter().print("<h1>Your Customer Id is : "+customer.getCust_id()+"</h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
		}else {
			resp.getWriter().print("<h1>Hello mam</h1>");
		 resp.getWriter().print("<h1>Your Customer Id is : "+customer.getCust_id()+"</h1>");
		 req.getRequestDispatcher("home.html").include(req, resp);
	
		
		
		}
		}
	
		else {
			resp.getWriter().print("<h1>Email or Phone No already exists</h1>");
			
			req.getRequestDispatcher("signin.html").include(req, resp);
		}
		    }
	
    }

}

