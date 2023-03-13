package com.spring.board.dto;

import java.sql.Date;
import java.sql.Time;

public class boardVO {
	private Integer bo_no;
	private String name;
	private String title;
	private Date date;
	private Time time;
	private String content;
	public int getBo_no() {
		return bo_no;
	}
	public void setBo_no(Integer bo_no) {
		this.bo_no = bo_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
