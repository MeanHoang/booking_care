package com.example.demo.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Admins;
import com.example.demo.service.admin.AdminService;
import com.example.demo.service.admin.AdminServiceImpl; 
import com.example.demo.connection.ConnectionPoolImpl;

public class mainTest {
    
    @SuppressWarnings("unused")
    private ConnectionPoolImpl connectionPool;
    private static AdminService adminService; 

    // Khởi tạo AdminService
    static {
        adminService = new AdminServiceImpl(); 
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Admins ad1 = new Admins();
        ad1.setID(11);
        ad1.setUsername("kimnam123");
        ad1.setPassword("1");
        ad1.setName("Nguyen Kim Nam ngu");
//        try {
//			adminService.addAdmin(ad1);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
//        try {
//			adminService.updateAdmin(ad1);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
        
        try {
			adminService.deleteAdmin(53);
        } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
        }
     
        
        List<Admins> admins = new ArrayList<>();
        try {
            admins = adminService.getAllAdmins(); 
            System.out.print(admins);
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }
}
