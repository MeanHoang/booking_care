package com.example.demo.service.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.connection.ConnectionPoolImpl;
import com.example.demo.model.Admins;


public interface AdminService {
    // Lấy danh sách tất cả các admin
    List<Admins> getAllAdmins();

    // Thêm admin mới
    void addAdmin(Admins admin) throws SQLException;

    // Cập nhật thông tin admin
    void updateAdmin(Admins admin) throws SQLException;

    // Xóa admin theo ID
    void deleteAdmin(int id) throws SQLException;

    // Tìm admin theo tên
    Admins findAdminByUsername(String username);
}
