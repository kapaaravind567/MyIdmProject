
package com.examdao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.question.Question;


public class Examdao {
    public static ArrayList<Question> getQuestions() {
        Connection con = null;
        PreparedStatement pst = null;
    try {


        Class.forName("com.mysql.cj.jdbc.Driver");


        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aravind", "root", "root");
        System.out.println(con + " is connected successfully");
        
        String query = "select * from questions";
        System.out.println("query");
        pst = con.prepareStatement(query);
        ResultSet res = pst.executeQuery();
        ArrayList<Question> questions = new ArrayList<Question>();
        while(res.next()) {
            Question q = new Question(res.getString("qno"),res.getString("question"),
                    res.getString("ans1"),res.getString("ans2"),res.getString("ans3"),
                    res.getString("ans4"),res.getString("cans"));
            questions.add(q);
            System.out.println("Question id " + q.getQno());
        }
        return questions;
        
    } catch (Exception e) {
        System.out.println(e);
    }
    return null;
    }


}
 








