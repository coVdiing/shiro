package com.vi.dao;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

/**
 * 用于数据库的连接以及密码、角色、权限的查询
 */
public class Dao {
//    static Connection conn;
//
//    static {
//        String url = "jdbc:mysql://localhost:3306/shiro?characterEncoding=UTF-8";
//        String username = "root";
//        String password = "root";
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(url, username, password);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    /**
//     * 新增用户
//     *
//     * @param name
//     * @param password
//     */
//    public void addUser(String name, String password) {
//        String sql = "INSERT INTO user VALUES(null,?,?,?)";
//        String salt = new SecureRandomNumberGenerator().nextBytes().toString();//盐量随机
//        String encryptPwd = new SimpleHash("md5", password, salt, 2).toString();   //md5加密算法，加密2次
//        try {
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, name);
//            pstmt.setString(2, encryptPwd);
//            pstmt.setString(3, salt);
//            pstmt.execute();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 获取用户
//     * @return
//     */
//    public User getUser(String username) {
//        String sql = "SELECT * FROM user WHERE name = ?";
//        User user = null;
//        try {
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1,username);
//            ResultSet rs = pstmt.executeQuery();
//            if(rs.next()) {
//                user = new User();
//                user.setId(rs.getInt("id"));
//                user.setName(rs.getString("name"));
//                user.setPassword(rs.getString("password"));
//                user.setSalt(rs.getString("salt"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return user;
//    }
//
//    /**
//     * 根据用户名查询是否存在数据
//     *
//     * @param username
//     * @return
//     */
//    public String getPassword(String username) {
//        String sql = "SELECT password FROM user WHERE name = ?";
//        ResultSet rs = null;
//        try {
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, username);
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                return rs.getString("password");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     * 查询对应的角色
//     *
//     * @param username
//     * @return
//     */
//    public Set<String> listRoles(String username) {
//        String sql = "SELECT r.name FROM user u " +
//                "LEFT JOIN user_role u_r ON u.id = u_r.uid " +
//                "LEFT JOIN role r ON u_r.rid = r.id WHERE u.name = ?";
//        Set<String> result = new HashSet<String>();
//        try {
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, username);
//            ResultSet rs = pstmt.executeQuery();
//            while (rs.next()) {
//                result.add(rs.getString(1));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    /**
//     * 查询拥有的权限
//     *
//     * @param username
//     * @return
//     */
//    public Set<String> listPermissions(String username) {
//        String sql = "SELECT p.name FROM user u " +
//                "LEFT JOIN user_role u_r ON u.id = u_r.uid " +
//                "LEFT JOIN role r ON u_r.rid = r.id " +
//                "LEFT JOIN role_permission r_p ON r.id = r_p.rid " +
//                "LEFT JOIN permission p ON r_p.pid = p.id WHERE u.name = ?";
//        ResultSet rs = null;
//        Set<String> result = new HashSet<String>();
//        try {
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, username);
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                result.add(rs.getString(1));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }

}
