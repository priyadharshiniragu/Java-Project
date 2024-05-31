package com.demo.jpa.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.jpa.model.Employee;
import com.demo.jpa.model.EmployeeUser;
import com.demo.jpa.repository.EmployeeRepo;
import com.demo.jpa.repository.EmployeeRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	EmployeeRepository repo;
	
	@Autowired
	EmployeeRepo repository;
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	@RequestMapping("/addUser")
	public String addUser(EmployeeUser user) {
		repo.save(user);
		return "home.jsp";
	}
	@GetMapping("/logIn")	
	public ModelAndView loginDetails(@RequestParam("name") String name ,@RequestParam("pass") String pass,EmployeeUser user) throws SQLException {
		String userName =user.getName();
		String password=user.getPass();
		ModelAndView mv = new ModelAndView();
		String url="jdbc:mysql://localhost:3306/employee_demo";
		String User="root";
		String Password="priya@123";
		Connection con= DriverManager.getConnection(url, User, Password);
	
		PreparedStatement ps = con.prepareStatement("SELECT * FROM employee_user WHERE name=? AND pass=?");
		ps.setString(1, name);
		ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			mv.addObject("name", name);
			mv.setViewName("welcome.jsp");
			
		}
		else {
		mv.addObject("error", "invalid username or password.");
		mv.setViewName("error.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/addEmployee")
	public String addEmployee(Employee employee) {
		repository.save(employee);
		return "welcome.jsp";
	}
	
	@GetMapping("/fetchEmployee")
public ModelAndView getEmployeeById(@RequestParam int id) {
		
		Employee employee =repository.findById(id).orElse(new Employee());
		ModelAndView mv = new ModelAndView();
		
			mv.addObject("employee",employee);
			mv.setViewName("fetch.jsp");
		
		return mv;
	}
	@RequestMapping("/updateEmployee")
public ModelAndView updateStudent( Employee employee,HttpSession session) {
		session.setAttribute("old", employee);
		ModelAndView mv = new ModelAndView("update.jsp");
		
		repository.save(employee);
				mv.addObject("employee", employee);
		return mv;
	}
	@RequestMapping("/deleteEmployee")
	public ModelAndView deleteStudent(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("delete.jsp");
		
		Employee emp =repository.findById(id).orElse(new Employee());
		
		
repository.deleteById(id);
mv.addObject("emp", emp);
		return mv;
			
		}
}
