
package com.question;

public class Question {
	private String qno, question, ans1, ans2, ans3, ans4, cans;
	public String getQno() {
		return qno;
	}
	public Question(String qno, String question, String ans1, String ans2, String ans3, String ans4, String cans) {
		super();
		this.qno = qno;
		this.question = question;
		this.ans1 = ans1;
		this.ans2 = ans2;
		this.ans3 = ans3;
		this.ans4 = ans4;
		this.cans = cans;
	}
	public void setQno(String qno) {
		this.qno = qno;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAns1() {
		return ans1;
	}
	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}
	public String getAns2() {
		return ans2;
	}
	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}
	public String getAns3() {
		return ans3;
	}

	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}

	public String getAns4() {
		return ans4;
	}

	public void setAns4(String ans4) {
		this.ans4 = ans4;
	}

	public String getCans() {
		return cans;
	}

	public void setCans(String cans) {
		this.cans = cans;
	}

	@Override
	public String toString() {
		return "Question [qno=" + qno + ", question=" + question + ", ans1=" + ans1 + ", ans2=" + ans2 + ", ans3="
				+ ans3 + ", ans4=" + ans4 + ", cans=" + cans + "]";
	}
}

// create table questions(qno int(5) primary key,question varchar(2000),ans1
// varchar(1000),ans2 varchar(1000),ans3 varchar(1000),ans4 varchar(1000),cans
// char(1));

/*
 * insert into questions values(1,'What is the size of char data type', '2
 * byte', '1 byte', 'Depends on OS', '3 bytes', 1);
 * 
 * 
 * 
 * insert into questions values(2,'Which of the following not a method in Object
 * class?', 'toString()', 'wait()', 'finalize()', 'compare()', 4);
 * 
 * 
 * 
 * insert into questions values(3,'Which is NOT a valid operator in Java?',
 '++', '+=', '_', '>>', 3);
 * 
 * 
 * 
 * insert into questions values(4,'Which class do you use if you have to
 * represent a collection of unique values that are sorted?', 'ArrayList',
 * 'Vector', 'HashSet', 'TreeSet', 4);
 * 
 * 
 * 
 * insert into questions values(5,'What is downcasting?', 'Converting superclass
 * to subclass', 'Converting subclass to superclass', 'Converting Interface to
 * class', 'Converting structure to class', 1);
 * 
 * 
 * 
 * insert into questions values(6,'What is boxing?', 'Converting primitive type
 * to object', 'Converting object to primitive type', 'Converting one primitive
 * type to another', 'Converting one object to another object', 1);
 * 
 * 
 * 
 * insert into questions values(7,'Which of the following is an Interface in
 * Collection API', 'ArrayList', 'IList', 'Comparator', 'Stack', 3);
 * 
 * 
 * 
 * insert into questions values(8,'Which is one of the differences between class
 * and an interface?', 'Interface does not support inheritance', 'Interface
 * cannot have object', 'Interface cannot have object reference', 'Interface
 * cannot have variables', 2);
 * 
 * 
 * 
 * insert into questions values(9,'Which of the following is correct about final
 * variables?', 'It must be assigned a value at the time of declaration', 'It
 * must be of int type', 'It must be assigned a value before constructor of the
 * class is completed', 'It must be assigned a value before any method in the
 * class is called', 3);
 * 
 * 
 * 
 * 
 * insert into questions values(10,'Which two keywords are mutually exclusive?',
 * 'final and abstrcat', 'final and static', 'final and sychronized', 'all the
 * above', 1);
 * 
 * 
 * 
 * 
 * insert into questions values(11,'Which of the following keywords are related
 * to multithreading?', 'final', 'synchronized', 'thread', 'running', 2);
 * 
 * 
 * 
 * 
 * insert into questions values(12,'How do you determine whether an object
 * reference points to a particular type of object?', 'points', 'typeof',
 * 'instanceof', 'objectof', 3);
 * 
 * 
 * 
 * 
 * insert into questions values(13,'Which is the stream used to read a complete
 * line at a time?', 'FileReader', 'Reader', 'BufferedReader', 'StreamReader',
 * 3);
 * 
 * 
 * 
 * 
 * insert into questions values(14,'Which of the following features was
 * introduced in Java 5.0?', 'inner classes', 'static members', 'final members',
 * 'static import', 4);
 * 
 * 
 * 
 * 
 * insert into questions values(15,'What is the parameter type for equals()
 * method in Object class?', 'String', 'Object', 'It depends on the calling
 * object', 'It has no parameter', 2);
 * 
 */
