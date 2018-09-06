package com.yi.util;

import java.util.Date;
/*
 * 任务的抽象类
 */
public class Task {
private int id;
private String task_name;
private Date task_start;
private Date task_end;
private String task_charge;
private int task_progress;
private int task_priority;
private int task_difficulty;
@Override
public String toString() {
	return "Task [id=" + id + ", task_name=" + task_name + ", task_start=" + task_start + ", task_end=" + task_end
			+ ", task_charge=" + task_charge + ", task_progress=" + task_progress + ", task_priority=" + task_priority
			+ ", task_difficulty=" + task_difficulty + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTask_name() {
	return task_name;
}
public void setTask_name(String task_name) {
	this.task_name = task_name;
}
public Date getTask_start() {
	return task_start;
}
public void setTask_start(Date task_start) {
	this.task_start = task_start;
}
public Date getTask_end() {
	return task_end;
}
public void setTask_end(Date task_end) {
	this.task_end = task_end;
}
public String getTask_charge() {
	return task_charge;
}
public void setTask_charge(String task_charge) {
	this.task_charge = task_charge;
}
public int getTask_progress() {
	return task_progress;
}
public void setTask_progress(int task_progress) {
	this.task_progress = task_progress;
}
public int getTask_priority() {
	return task_priority;
}
public void setTask_priority(int task_priority) {
	this.task_priority = task_priority;
}
public int getTask_difficulty() {
	return task_difficulty;
}
public void setTask_difficulty(int task_difficulty) {
	this.task_difficulty = task_difficulty;
}
}
