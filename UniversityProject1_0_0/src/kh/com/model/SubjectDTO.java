package kh.com.model;

import java.io.Serializable;

// 과목테이블
public class SubjectDTO implements Serializable {
	
	/*
	 CREATE TABLE SUBJECT(
     SUB_SEQ NUMBER(8) PRIMARY KEY,
     SUB_CATEGORY VARCHAR2(50) NOT NULL,         -- 전공:100,교양:200
     MAJOR_NUMBER NUMBER(8) NOT NULL,            -- 없음:0,기계공학과:100,전기공학과:200,컴퓨터공학과:300...       
     SUB_GRADE NUMBER(8) NOT NULL,               -- 학년
     SUB_SEMESTER NUMBER(8) NOT NULL,            -- 학기(1~2)  
     SUB_NAME VARCHAR2(50),                      -- 과목명
     USER_ID VARCHAR2(50) NOT NULL,              -- 교수아이디 외래키
     USER_NAME VARCHAR2(50) NOT NULL,            -- 교수명 외래키
     SUB_INFO VARCHAR2(4000) NOT NULL,           -- 강의 소개
     SUB_ROOM VARCHAR2(255) NOT NULL,            -- 강의실
     SUB_WEEK NUMBER(8) NOT NULL,                -- 1 ~ 5 (월~금)
     SUB_CLASS NUMBER(8) NOT NULL,               -- 1 ~ 10 (1~10교시)
     SUB_MAX_STUDENT NUMBER NOT NULL,            -- 최대 인원수
     SUB_NOW_STUDENT NUMBER DEFAULT 0 NOT NULL,  -- 현재 인원수
     SUB_POINT NUMBER NOT NULL                   -- 학점(1~3)   
	);
	*/
	
	//sub_seq
	private String sub_category;		// -- 전공:100교양:200
	private int major_number;          // -- 없음:0기계공학과:100전기공학과:200컴퓨터공학과:300...       
	private int sub_grade;           	// -- 학년
	private int sub_semester;       	// -- 학기(1~2)  
	private String sub_name;           // -- 과목명
	private String user_id;            // -- 교수아이디 외래키
	private String user_name;          // -- 교수명 외래키
	private String sub_info;			// -- 강의 소개
	private String sub_room;      		// -- 강의실
	private int sub_week;            	// -- 1 ~ 5 (월~금)
	private int sub_class;           	// -- 1 ~ 10 (1~10교시)
	private int sub_max_student;     	// -- 최대 인원수
	private int sub_now_student; 		// -- 현재 인원수
	private int sub_point;             // -- 학점(1~3) 
     
	public SubjectDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public SubjectDTO(String sub_category, int major_number, int sub_grade, int sub_semester, String sub_name,
			String user_id, String user_name, String sub_info, String sub_room, int sub_week, int sub_class,
			int sub_max_student, int sub_now_student, int sub_point) {
		super();
		this.sub_category = sub_category;
		this.major_number = major_number;
		this.sub_grade = sub_grade;
		this.sub_semester = sub_semester;
		this.sub_name = sub_name;
		this.user_id = user_id;
		this.user_name = user_name;
		this.sub_info = sub_info;
		this.sub_room = sub_room;
		this.sub_week = sub_week;
		this.sub_class = sub_class;
		this.sub_max_student = sub_max_student;
		this.sub_now_student = sub_now_student;
		this.sub_point = sub_point;
	}

	public String getSub_category() {
		return sub_category;
	}

	public void setSub_category(String sub_category) {
		this.sub_category = sub_category;
	}

	public int getMajor_number() {
		return major_number;
	}

	public void setMajor_number(int major_number) {
		this.major_number = major_number;
	}

	public int getSub_grade() {
		return sub_grade;
	}

	public void setSub_grade(int sub_grade) {
		this.sub_grade = sub_grade;
	}

	public int getSub_semester() {
		return sub_semester;
	}

	public void setSub_semester(int sub_semester) {
		this.sub_semester = sub_semester;
	}

	public String getSub_name() {
		return sub_name;
	}

	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getSub_info() {
		return sub_info;
	}

	public void setSub_info(String sub_info) {
		this.sub_info = sub_info;
	}

	public String getSub_room() {
		return sub_room;
	}

	public void setSub_room(String sub_room) {
		this.sub_room = sub_room;
	}

	public int getSub_week() {
		return sub_week;
	}

	public void setSub_week(int sub_week) {
		this.sub_week = sub_week;
	}

	public int getSub_class() {
		return sub_class;
	}

	public void setSub_class(int sub_class) {
		this.sub_class = sub_class;
	}

	public int getSub_max_student() {
		return sub_max_student;
	}

	public void setSub_max_student(int sub_max_student) {
		this.sub_max_student = sub_max_student;
	}

	public int getSub_now_student() {
		return sub_now_student;
	}

	public void setSub_now_student(int sub_now_student) {
		this.sub_now_student = sub_now_student;
	}

	public int getSub_point() {
		return sub_point;
	}

	public void setSub_point(int sub_point) {
		this.sub_point = sub_point;
	}

	@Override
	public String toString() {
		return "KhSubjectDTO [sub_category=" + sub_category + ", major_number=" + major_number + ", sub_grade="
				+ sub_grade + ", sub_semester=" + sub_semester + ", sub_name=" + sub_name + ", user_id=" + user_id
				+ ", user_name=" + user_name + ", sub_info=" + sub_info + ", sub_room=" + sub_room + ", sub_week="
				+ sub_week + ", sub_class=" + sub_class + ", sub_max_student=" + sub_max_student + ", sub_now_student="
				+ sub_now_student + ", sub_point=" + sub_point + "]";
	}
	
}
