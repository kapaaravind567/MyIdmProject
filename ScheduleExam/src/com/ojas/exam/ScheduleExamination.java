package com.ojas.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examdao.Examdao;
import com.question.Question;

@WebServlet("/ScheduleExamination")
public class ScheduleExamination extends HttpServlet {

	private Map<String, String> queAnsMap = new HashMap<>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		ArrayList<Question> q = Examdao.getQuestions();
		pw.println("<form action='ScheduleExamination' method='post'>");
		int index = 1;
		pw.println("<h1 style=background-color:skyblue;color:balck;text-align:center;>Exam Paper</h1>");
		for (Question quest : q) {
			
			pw.println("<h3 style=background-color:yellow;color:black;padding:20px;text-align:left;>Question "+quest.getQno()+"</h3>");
			pw.println(quest.getQuestion() + "<br><br>");
			pw.println("<h1 style=background-color:aqua; ><input type='radio' name='que" + index + "' value='1'>" + quest.getAns1() + "&nbsp;&nbsp;<br>");
			pw.println("<h1 style=background-color:aqua; ><input type='radio' name='que" + index + "' value='2'>" + quest.getAns2() + "&nbsp;&nbsp;<br>");
			pw.println("<h1 style=background-color:aqua; ><input type='radio' name='que" + index + "' value='3'>" + quest.getAns3() + "&nbsp;&nbsp;<br>");
			pw.println("<h1 style=background-color:aqua; ><input type='radio' name='que" + index + "' value='4'>" + quest.getAns4() + "&nbsp;&nbsp;<br></h1>");
			index++;
			queAnsMap.put(quest.getQno(), quest.getCans());
		}
		pw.println("<input type='submit' value='Finish' style=color:red;background-color:skyblue/> <br><br>" + "&nbsp;&nbsp;<br><br>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int score = 0;
		for (int i = 1; i < 16; i++) {
			if (request.getParameter("que" + i) != null
					&& request.getParameter("que" + i).trim().equals(queAnsMap.get("" + i)))
				score++;
		}
		out.println("Score is " + score+"/8");
	}
}