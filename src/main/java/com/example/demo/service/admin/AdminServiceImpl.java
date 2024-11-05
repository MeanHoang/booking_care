package com.example.demo.service.admin;

import com.example.demo.model.Admins;
import com.example.demo.connection.ConnectionPoolImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    
    private ConnectionPoolImpl connectionPool;

    public AdminServiceImpl() {
        this.connectionPool = new ConnectionPoolImpl(); // Khởi tạo connection pool
    }

    @Override
    public List<Admins> getAllAdmins() {
        List<Admins> adminsList = new ArrayList<>();
        String sql = "SELECT * FROM admins";

        try (Connection connection = connectionPool.getConnection("AdminService");
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Admins admin = new Admins();
                admin.setID(resultSet.getInt("id"));
                admin.setUsername(resultSet.getString("username"));
                admin.setPassword(resultSet.getString("password"));
                admin.setName(resultSet.getString("name"));
                adminsList.add(admin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminsList;
    }

	@Override
	public void addAdmin(Admins admin) throws SQLException  {
        try (Connection connection = connectionPool.getConnection("AdminService")) {
            String query = "INSERT INTO admins (username, password, name) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {

                stmt.setString(1, admin.getUsername());
                stmt.setString(2, admin.getPassword());
                stmt.setString(3, admin.getName());
                stmt.executeUpdate();
            }
        }
		
	}


	@Override
	public void updateAdmin(Admins admin) throws SQLException {
		// TODO Auto-generated method stub
		  try (Connection connection = connectionPool.getConnection("AdminService")) {
			    String query = "UPDATE admins SET username = ?, password = ?, name = ? WHERE id = ?";
			    try (PreparedStatement stmt = connection.prepareStatement(query)) {
	                stmt.setString(1, admin.getUsername());
	                stmt.setString(2, admin.getPassword());
	                stmt.setString(3, admin.getName());
	                stmt.setInt(4, admin.getID());
	                stmt.executeUpdate();
	            }
		  }
	}

	@Override
	public void deleteAdmin(int id) throws SQLException {
		  try (Connection connection = connectionPool.getConnection("AdminService")) {
			    String query = "DELETE FROM admins WHERE id = ?";
			    try (PreparedStatement stmt = connection.prepareStatement(query)) {
			    	if(stmt==null)
	                stmt.setInt(1, id);
	                stmt.executeUpdate();
	                System.out.println(" Deleted successful admin with id: "+ id);
	            }catch(Exception e) {
	                System.out.println(" Deleted failed admin with id: "+ id);
	            }
		  }		
		
	}

	@Override
	public Admins findAdminByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

    // Các phương thức khác như thêm, sửa, xóa admin có thể được triển khai ở đây
}
