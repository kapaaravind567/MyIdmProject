package loginanddisplayandexam;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentRegisterServlet")
public class StudentRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public StudentRegisterServlet() {
        super();
    }
    Connection con = null;
    public void init(ServletConfig config) throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aravind", "root", "root");
            System.out.println(con + " is connected successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        String pwd = request.getParameter("pwd");
        String rpwd = request.getParameter("rpwd");
        String d = request.getParameter("ADate");
        String photo = request.getParameter("photo");
        if(pwd.equals(rpwd)) {
            try {
                File f = new File(photo);
                int size = (int) f.length();
                FileInputStream fos = new FileInputStream(f);
                PreparedStatement ps3 = con.prepareStatement("select count(*) from stdregister");
                ResultSet rs3 = ps3.executeQuery();
                String no;
                if(rs3.next()) {
                    no = "0"+(rs3.getInt(1) +1);
                } else {
                    no="01";
                }
                PreparedStatement ps1 = con.prepareStatement("insert into stdregister values(?,?,?,?,?)");
                ps1.setString(1,no);
                ps1.setString(2, name);
                ps1.setString(3,mail);
                ps1.setString(4,pwd);
                SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
                java.util.Date d1 = new java.util.Date(d);
                java.sql.Date d2 = new java.sql.Date(d1.getTime());
                ps1.setDate(5, d2);
                int x = ps1.executeUpdate();
                PreparedStatement ps = con.prepareStatement("insert into img values(?,?)");
                ps.setString(1,no);
                ps.setBinaryStream(2, fos,size);
                int x2 = ps.executeUpdate();        
                if(x != 0&&x2 != 0) 
                    out.println("<body><h3 style=background-color:red;color:black;padding:20px;text-align:center;border-radius:39px 2px 4px 5px;>successfully Inserted <br><br>  Your-Id : "+no+""
                            + "<br>Password : "+mail+"</center></h3></body>");
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            response.sendRedirect("wrong.html");
        }
        out.close();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}