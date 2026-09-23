package com.kedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO {

	@Autowired
	private DataSource dbcp;
	 
	   public void insert(StudentDTO dto) throws Exception {
		   
		  String sql = "insert into student values(student_seq.nextval,?, ?";
		   
		  try(Connection con = dbcp.getConnection();
			  PreparedStatement stat = con.prepareStatement(sql)) {
			  
			   stat.setString(1, dto.getname());
			   stat.setString(1, dto.getcontact());
			   stat.setInt(1, dto.getId());
			   
			   stat.executeUpdate();
			   
		  }
		   
	   }
	   
	   
	   
	   public ArryaList<StudentDTO> selectAll() throws Exception {
		   
		   String sql = "select * from student";
		   
		   ArrayList<StudentDTO> list = new ArrayList<>();
		   
		   try(Connection con = dbcp.getConnection();
			  PreparedStatement stat = con.prepareStatement(sql)) {
			   
			   ResultSet rs = stat.executeQuery();
			   
			   while(rs.next()) {
				   
				   int id = rs.getInt(1);
				   String name = rs.getString(2);
				   String contact = rs.getString(3);
				   
				   StudentDTO dto = new Student(id, name, contact);
				   list.add(dto);
				   
			   }
			   
			   return list;
			   
		   }
		   
	   }
	   
	   
	   public void update(int id, String name, String contact) throws Exception {
		   
		   String sql = "update student set name = ?, contact = ?, where id = ?";
		   
		   try(Connection con = dbcp.getConnection();
			  PreparedStatement stat = con.prepareStatement(sql)) {
			   
			   stat.setString(1, name);
			   stat.setString(2, contact);
			   stat.setInt(3, id);
			   
			   stat.executeUpdate();
			   
		   }
		   
		   
	   }
	   
	   
	   
	   public void delete(int id) throws Exception {
		   
		   String sql = "delete from student where id = ?";
		   
		   try(Connection con = dbcp.getConnection();
			  PreparedStatement stat = con.prepareStatement(sql)) {
			   
			   stat.setInt(1,id);
			   stat.executeUpdate();
			   
		   }
		   
	   }
	   
	   
	   
	
	
	
}
