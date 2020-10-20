package loginanddisplayandexam;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ojas.exam.*;
import com.examdao.*;
import com.question.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayServlet() {
		super();
		// TODO Auto-generated constructor stub
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		try {
			PreparedStatement pst = con.prepareStatement("select photo from img where no=?");
			pst.setString(1, "01");
			ResultSet res = pst.executeQuery();
			if (res.next()) {
				InputStream in = res.getBinaryStream("photo");
				FileOutputStream fos = new FileOutputStream("A:\\Pictures\\family\\baby.jpg");
				byte size[] = new byte[47232];
				int bytes = 0;
				while ((bytes = in.read(size)) != -1)
					fos.write(size, 0, bytes);
			}
			pw.println("<div align='center'>"
					+ "<IMG src='A:\\Pictures\\family\\baby.jpg' WIDTH='250' HEIGHT='125' BORDER='1' ALT=''>"
					+ "</div>");
			pw.println("<h1 style=background-color:skyblue;color:white;padding:20px;text-align:center;border-radius:39px 2px 4px 5px;>Login Successful</h1><a href='ScheduleExamination'><button>Please take the Exam</button></a>");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}