

package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.model.Student;
import com.cognizant.service.StudentServiceImpl;

@Controller
public class StudentController {
@Autowired
private StudentServiceImpl studentService;

public void setStudentService(StudentServiceImpl studentService) {
	this.studentService = studentService;
}
@RequestMapping(value="insert",method=RequestMethod.GET)
public String insertPage(){
	return "insert";
	
}
@RequestMapping(value="insert" ,method=RequestMethod.POST)
public String insert(HttpServletRequest request) {
	//Read the request parameter
	int id=Integer.parseInt(request.getParameter("id"));
	String name=request.getParameter("name");
	//Create the student
	Student student=new Student(id, name);
	
	System.out.println(student);
	//insert student to db
	String res=studentService.insert(student);
	request.setAttribute("msg", res);
	
	return "insert";
}
@RequestMapping(value="update",method=RequestMethod.GET)
public String updatePage(){
	
	return "update";
	
}
@RequestMapping(value="update" ,method=RequestMethod.POST)
public String update(HttpServletRequest request) {
	//Read the request parameter
	int id=Integer.parseInt(request.getParameter("id"));
	String name=request.getParameter("name");
	//Create the student
	Student student=new Student(id, name);
	
	System.out.println(student);
	String res=studentService.update(student);
	request.setAttribute("msg", res);
	
	return "update";
}
@RequestMapping(value="delete",method=RequestMethod.GET)
public String deletePage(){
	return "delete";
	
}
@RequestMapping(value="delete" ,method=RequestMethod.POST)
public String delete(HttpServletRequest request) {
	//Read the request parameter
	int id=Integer.parseInt(request.getParameter("id"));
	
	System.out.println("id to be removed "+id);
	String res=studentService.delete(id);
	request.setAttribute("msg", res);
	
	return "delete";
}
@RequestMapping(value="viewAll",method=RequestMethod.GET)
public String getAll(HttpServletRequest request){
	List<Student> list=studentService.getAll();
	request.setAttribute("list", list);
	return "display";
	
}
}
