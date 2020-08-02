package com.djg.sms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.djg.sms.dao.IStudentDao;
import com.djg.sms.domain.Student;
import com.djg.sms.util.JDBCUtil;
import com.mysql.jdbc.StringUtils;

public class StudentDaoJDBCImpl implements IStudentDao {
	
	
	
	
	
	/****************************************/
	
	// 模糊查询方法
	  public List<Student> query() {
	    List<Student>stuList = new ArrayList<>();
	    Connection conn = null;
	    Scanner sc = new Scanner(System.in);
	    System.err.println("enter sno:");
	    String sno = sc.nextLine();
	    System.err.println("enter name:");
	    String name = sc.nextLine();
	    System.err.println("enter myclass:");
	    String myclass = sc.nextLine();
	    System.err.println("enter score:");
	    String score = sc.nextLine();
	    String sql = "select sno,name,myclass,score from t_student where name like '%?%'";
	        // 技巧在此，合理拼接字符串
	/*        + "where 1=1";
	    List<Object> list1 = new ArrayList<Object>();
	    
	    //使用 commons-lang包
	    if (StringUtils.isNullOrEmpty(sno)) {
	      sql += " and title like ?";
	      list1.add("%" + sno + "%");
	    }
	 
	    if (!StringUtils.isNullOrEmpty(name)) {
	      sql += " and content like ?";
	      list1.add("%" + name + "%");
	    }
	    
	    if (!StringUtils.isNullOrEmpty(myclass)) {
	      sql += " and addm like ?";
	      list1.add("%" + myclass + "%");
	    }
	    if (!StringUtils.isNullOrEmpty(score)) {
		      sql += " and adds like ?";
		      list1.add("%" + score + "%");
		    }*/
	    try {
	      conn = JDBCUtil.getConnection();
	      // SQL语句组成完成以后，就生成pst对象
	      PreparedStatement pst = conn.prepareStatement(sql);
	      // 设置?的值
	      for (int i = 0; i < stuList.size(); i++) {
	        pst.setObject(i + 1, stuList.get(i));
	      }
	      ResultSet rs = pst.executeQuery();
	      while (rs.next()) {
	    		Student s = new Student();
				s.setSno(rs.getInt("sno"));
				s.setName(rs.getString("name"));
				s.setMyclass(rs.getString("myclass"));
				s.setScore(rs.getDouble("score"));
				stuList.add(s);
	      }
	      rs.close();
	      pst.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      try {
	        conn.close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }
	    return stuList;
	  }

	
	
	/****************************************/

	@Override
	public List<Student> findAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Student> stuList = null;
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from t_student";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			//遍历结果集
			if(rs != null){
				boolean flag = true;
				while(rs.next()){
					if(flag){
						stuList = new ArrayList<Student>();
						flag = false;
					}
						
					Student s = new Student();
					s.setSno(rs.getInt("sno"));
					s.setName(rs.getString("name"));
					s.setMyclass(rs.getString("myclass"));
					s.setScore(rs.getDouble("score"));
					stuList.add(s);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stuList;
	}

	@Override
	public Student findById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Student student = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from t_student where sno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			//遍历结果集
			if(rs != null){
				while(rs.next()){
					student = new Student();
					student.setSno(rs.getInt("sno"));
					student.setName(rs.getString("name"));
					student.setMyclass(rs.getString("myclass"));
					student.setScore(rs.getDouble("score"));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return student;
	}
	

	
	
	@Override
	public int add(Student s) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int n = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "insert into t_student (name,myclass,score) values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setString(2, s.getMyclass());
			ps.setDouble(3, s.getScore());
			
			n = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}

	@Override
	public int deleteById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int n = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "delete from t_student where sno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			n = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}

	@Override
	public int modify(int id, Student s) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int n = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "update t_student set name=?,myclass=?,score=? where sno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setString(2, s.getMyclass());
			ps.setDouble(3, s.getScore());
			ps.setInt(4, id);
			
			
			n = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}

	@Override
	public int findTotalCount() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int n = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select count(*) as totalcount from t_student";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if(rs != null){
				while(rs.next()){
					n = rs.getInt("totalcount");
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}

	@Override
	public List<Student> findOnePage(int pageIndex, int pageSize) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Student> stuList = null;
		
		//计算分页相关参数
		//变量startRecordNo 存储的是当前分页第一条记录的前一个位置 
		int startRecordNo = (pageIndex - 1) * pageSize;
		
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from t_student limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startRecordNo);
			ps.setInt(2, pageSize);
			
			rs = ps.executeQuery();
			
			//遍历结果集
			if(rs != null){
				boolean flag = true;
				while(rs.next()){
					if(flag){
						stuList = new ArrayList<Student>();
						flag = false;
					}
						
					Student s = new Student();
					s.setSno(rs.getInt("sno"));
					s.setName(rs.getString("name"));
					s.setMyclass(rs.getString("myclass"));
					s.setScore(rs.getDouble("score"));
					stuList.add(s);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stuList;
	}

}
