
package loginanddisplayandexam;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public LoginServlet() {
        super();
    }


    Connection con = null;


    @Override
    public void init() throws ServletException {
        try {


            Class.forName("com.mysql.cj.jdbc.Driver");


            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aravind", "root", "root");
            System.out.println(con + " is connected successfully");


        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");


        String num = request.getParameter("no");
        String pass = request.getParameter("mail");
        try {


            PreparedStatement pst = con.prepareStatement("select * from stdregister where no=? && pwd=?");
            pst.setString(1, num);
            pst.setString(2, pass);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                response.sendRedirect("./DisplayServlet");
                
            } else {
                response.sendRedirect("./LoginPage.html");
            }


        } catch (Exception e) {
            System.out.println(e);
        }


    }


}
 

















