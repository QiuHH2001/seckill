package com.example.seckill.utils;

import com.example.seckill.entity.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：qhh
 * @date ：Created in 2022/6/5 22:12
 */
public class UserUtil {
    public static void main(String[] args) {
//        try {
//            genUser(200);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        for (int i = 6; i <= 205; i++) {
//            System.out.print(i + ",1\n");
//        }
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("testData.txt"));
            for (int i = 207; i < 407; i++) {
                out.write(i + ",4\n");
            }
            out.close();
            System.out.println("文件创建成功！");
        } catch (IOException e) {
        }
    }

    public static void genUser(int count) throws Exception{
        List<User> userList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            User user = new User();
            user.setName("user" + i);
            user.setPassword("123456");
            user.setIdentity("330327" + i);
            userList.add(user);
        }
//        插入数据库
        Connection conn = getConn();
        String sql = "INSERT INTO `user`(`name`, `password`, identity) VALUES(?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            pst.setString(1, user.getName());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getIdentity());
            pst.addBatch();
        }
        pst.executeBatch();
        pst.clearParameters();
        conn.close();
    }

    private static Connection getConn() throws Exception{
        String url = "jdbc:mysql://localhost:3306/seckill";
        String username = "root";
        String password = "root";
        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        return DriverManager.getConnection(url, username, password);
    }
}
