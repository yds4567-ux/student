package com.kedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.StudentDTO;

@Repository
public class StudentDAO {

	@Autowired
	private DataSource dbcp;
	 
	   public void insert(StudentDTO dto) throws Exception {
		   
		  String sql = "insert into student values(student_seq.nextval,?, ?,?,?)";
		   
		  try(Connection con = dbcp.getConnection();
			  PreparedStatement stat = con.prepareStatement(sql)) {
			  
			   stat.setString(1, dto.getName());
			   stat.setInt(2, dto.getKor());
			   stat.setInt(3, dto.getEng());
			   stat.setInt(4, dto.getMath());
			
			   
			   stat.executeUpdate();
			   
		  }
		   
	   }
	   
	   
	   
	   public List<StudentDTO> selectAll() throws Exception {
		   
		   String sql = "select * from student";
		   
		        List<StudentDTO> list = new ArrayList<>();
		   
		   try(Connection con = dbcp.getConnection();
			  PreparedStatement stat = con.prepareStatement(sql)) {
			   
			   ResultSet rs = stat.executeQuery();
			   
			   while(rs.next()) {
				   
				   int id = rs.getInt(1);
				   String name = rs.getString(2);
				   int kor = rs.getInt(3);
				   int eng = rs.getInt(4);
				   int math = rs.getInt(5);
				   
				   StudentDTO dto = new StudentDTO(id, name, kor, eng, math);
				   list.add(dto);
				   
			   }
			   
			   return list;
			   
		   }
		   
	   }
	   
	   
	   public void update(int id, String name, int kor, int eng, int math) throws Exception {
		   
		   String sql = "update student set name = ?, kor = ?, eng = ?, math = ? where id = ?";
		   
		   try(Connection con = dbcp.getConnection();
			  PreparedStatement stat = con.prepareStatement(sql)) {
			   
			   stat.setString(1, name);
			   stat.setInt(2, kor);
			   stat.setInt(3, eng);
			   stat.setInt(4, math);
			   stat.setInt(5, id);
			   
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
