package com.operation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.connection.GetConnection;

public class OpImp implements Operation{

	@Override
	public void insertData() {
		PreparedStatement ps;
		try {
			ps = GetConnection.getConnection().prepareStatement("insert into info values(?,?)");
			ps.setInt(1, 1);
			ps.setString(2, "Tom");
			System.out.println("done");
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateData() {
		PreparedStatement ps;
		try {
			ps = GetConnection.getConnection().prepareStatement("update info set name=? where id=?");
			ps.setString(1, "Jerry");
			ps.setInt(2, 1);
			ps.executeUpdate();
			System.out.println("updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteData() {
		PreparedStatement ps;
		try {
			ps = GetConnection.getConnection().prepareStatement("delete from info where id=?");
			ps.setInt(1, 1);
			ps.executeUpdate();
			System.out.println("deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void showData() {
		Statement st;
		try {
			st = GetConnection.getConnection().createStatement();
			ResultSet rs= st.executeQuery("select * from info");
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
