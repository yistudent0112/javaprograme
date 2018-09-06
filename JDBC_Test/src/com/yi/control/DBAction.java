package com.yi.control;

import java.util.List;
import java.util.Map;

import com.yi.dao.Dao;
import com.yi.util.Task;

public class DBAction {
public static Dao dao=null;
static {
	dao=new Dao();
}
	public void addTask(Task t) {
		dao.addTask(t);
	}
	public void updateTask(Task t) {
		dao.updateTask(t);
	}
	public void deleteTask(Task t) {
		dao.deleteTask(t);
	}
	public Task searchById(Task t) {
		return dao.queryTaskByID(t);
	}
	public List<Task> searchAllTask() {
		return dao.queryTask();
	}
	public List<Task> searchTaskDIY(List<Map<String,Object>>params){
		return dao.queryTaskByDesign(params);
	}
	public List<Task> searchAllTaskOrderByPriority(boolean asc){
		return dao.queryTaskOrderByPriority(asc);
	}
	public List<Task> searchAllTaskOrderByDifficulty(boolean asc){
		return dao.queryTaskOrderByDifficulty(asc);
	}
}
