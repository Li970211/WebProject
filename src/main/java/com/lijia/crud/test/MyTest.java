package com.lijia.crud.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?useUnicode=true&characterEncoding=utf-8", "root", "123");
			conn.setAutoCommit(false);//设置手动提交事务
			st = conn.createStatement();
			for(int i = 1;i<48;i++) {
				String sql = "insert into tbl_emp (emp_name,gender,email,d_id) values('赵六"+i+"',1,'14365@qq.com',3)";
				st.addBatch(sql);
		
			}
			st.executeBatch();//执行批处理
			conn.commit();//提交事务
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//关闭顺序： ResultSet--->Statement-->connection
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(st != null){
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
