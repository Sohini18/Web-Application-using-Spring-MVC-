package com.cognizant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Student;
@Repository
public class StudentDaoImpl implements StudentDao {
	
	//private static List<Student> list = new ArrayList<Student>();
	@Autowired
	JdbcTemplate jdbcTemplate;
	public String insert(Student s) {
		
		int r=jdbcTemplate.update("INSERT INTO STUDENT (id,name) VALUES (?,?)", s.getId(), s.getName());
		if(r>0) {
		return "SUCCESS";
		}
		else {
			return "FAIL";
		}
	}
	public String update(Student s) {
		int id=s.getId();
		int r=this.jdbcTemplate.update(
		        "update STUDENT set name = ? where id = ?",
		        s.getName(),id);
		if(r>0){
			return "SUCCESS";
		}
		else{
		return "FAILURE";
		}
	}
	public String delete(int id) {
		int r=this.jdbcTemplate.update(
		        "delete from STUDENT where id = ?",
		        id);
		if(r>0){
			return "SUCCESS";
		}
		else
			return "FAILURE";
	}
	
	public List<Student> getAll() {

		 List < Student > students = jdbcTemplate.query("SELECT * FROM STUDENT", new BeanPropertyRowMapper(Student.class));
	        return students;
	}
}
