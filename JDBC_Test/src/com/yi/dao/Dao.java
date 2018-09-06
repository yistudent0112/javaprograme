package com.yi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yi.db.DBConnect;
import com.yi.util.Task;

public class Dao {
	private static Connection conn = null;
	static {
		conn = DBConnect.getConn();
	}

	public void addTask(Task t) {
		try {
			String sql = " insert into task_manage" + " (task_name,task_start,task_charge,"
					+ "task_progress,task_priority,task_difficulty)" + " values(?,current_date(),?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getTask_name());
			// pst.setDate(2, new Date(t.getTask_start().getTime()));
			pst.setString(2, t.getTask_charge());
			pst.setInt(3, t.getTask_progress());
			pst.setInt(4, t.getTask_priority());
			pst.setInt(5, t.getTask_difficulty());
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateTask(Task t) {
		try {
			String sql = " update task_manage" 
		            + " set task_name=?,task_end=current_date(),task_charge=?"
					+ ",task_progress=?,task_priority=?,task_difficulty=?"
		            + " where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getTask_name());
			pst.setString(2, t.getTask_charge());
			pst.setInt(3, t.getTask_progress());
			pst.setInt(4, t.getTask_priority());
			pst.setInt(5, t.getTask_difficulty());
			pst.setInt(6, t.getId());
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteTask(Task t) {
try {
	String sql=" delete from task_manage"
			+ " where id=?";
	PreparedStatement pst=conn.prepareStatement(sql);
	pst.setInt(1, t.getId());
	pst.execute();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
public Task queryTaskByID(Task t) {
	Task result=null;
	try {
		String sql=" select * from task_manage"
				+ " where id=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setInt(1, t.getId());
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			result=new Task();
			result.setId(rs.getInt("id"));
			result.setTask_charge(rs.getString("task_charge"));
			result.setTask_difficulty(rs.getInt("task_difficulty"));
			result.setTask_end(rs.getDate("task_end"));
			result.setTask_name(rs.getString("task_name"));
			result.setTask_priority(rs.getInt("task_priority"));
			result.setTask_progress(rs.getInt("task_progress"));
			result.setTask_start(rs.getDate("task_start"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
	return result;
}
//支持对姓名的模糊查询
public Task queryTaskByName(Task t) {
	Task result=null;
	try {
		String sql=" select * from task_manage"
				+ " where task_name like ?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, "%"+t.getTask_name()+"%");
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			result=new Task();
			result.setId(rs.getInt("id"));
			result.setTask_charge(rs.getString("task_charge"));
			result.setTask_difficulty(rs.getInt("task_difficulty"));
			result.setTask_end(rs.getDate("task_end"));
			result.setTask_name(rs.getString("task_name"));
			result.setTask_priority(rs.getInt("task_priority"));
			result.setTask_progress(rs.getInt("task_progress"));
			result.setTask_start(rs.getDate("task_start"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
	return result;
}
//根据用户传入的map中的参数，自定义查询语句
public List<Task> queryTaskByDesign(List<Map<String,Object>>params){
	List<Task> list = new ArrayList<Task>();
	try {
		StringBuffer sb=new StringBuffer();
		Task temp=null;
		//where 1=1是一个小技巧
		sb.append("select * from task_manage where 1=1");
		if(params!=null&&params.size()>0) {
			int length=params.size();
			Map<String,Object>map=new HashMap<String,Object>();
			for(int i=0;i<length;i++) {
				map=params.get(i);
				sb.append(" and "+map.get("name")+map.get("rela")+map.get("value"));		
			}
		}
		System.out.println(sb.toString());
		PreparedStatement pst=conn.prepareStatement(sb.toString());
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			temp = new Task();
			temp.setId(rs.getInt("id"));
			temp.setTask_name(rs.getString("task_name"));
			temp.setTask_difficulty(rs.getInt("task_difficulty"));
			temp.setTask_charge(rs.getString("task_charge"));
			temp.setTask_priority(rs.getInt("task_priority"));
			temp.setTask_progress(rs.getInt("task_progress"));
			temp.setTask_start(rs.getDate("task_start"));
			temp.setTask_end(rs.getDate("task_end"));
			list.add(temp);
		}

	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
	return list;
}
	public List<Task> queryTask() {
		List<Task> list = new ArrayList<Task>();
		Task temp = null;
		try {
			String sql = "select * from task_manage";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			// Statement stat=conn.createStatement();
			// ResultSet rs=stat.executeQuery(sql);
			while (rs.next()) {
				// System.out.println(rs.getString(2));
				temp = new Task();
				temp.setId(rs.getInt("id"));
				temp.setTask_name(rs.getString("task_name"));
				temp.setTask_difficulty(rs.getInt("task_difficulty"));
				temp.setTask_charge(rs.getString("task_charge"));
				temp.setTask_priority(rs.getInt("task_priority"));
				temp.setTask_progress(rs.getInt("task_progress"));
				temp.setTask_start(rs.getDate("task_start"));
				temp.setTask_end(rs.getDate("task_end"));
				list.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	//支持对任务管理人员名字的模糊查询
	public List<Task> queryTaskByCharge(Task t) {
		List<Task> list = new ArrayList<Task>();
		Task temp = null;
		try {
			String sql = "select * from task_manage"
					+ " where task_charge like ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "%"+t.getTask_charge()+"%");
			ResultSet rs = pst.executeQuery();
			// Statement stat=conn.createStatement();
			// ResultSet rs=stat.executeQuery(sql);
			while (rs.next()) {
				// System.out.println(rs.getString(2));
				temp = new Task();
				temp.setId(rs.getInt("id"));
				temp.setTask_name(rs.getString("task_name"));
				temp.setTask_difficulty(rs.getInt("task_difficulty"));
				temp.setTask_charge(rs.getString("task_charge"));
				temp.setTask_priority(rs.getInt("task_priority"));
				temp.setTask_progress(rs.getInt("task_progress"));
				temp.setTask_start(rs.getDate("task_start"));
				temp.setTask_end(rs.getDate("task_end"));
				list.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	//查找按照任务优先级排序的结果，ASC代表递增，DESC代表递减
	public List<Task> queryTaskOrderByPriority(boolean ASC){
		List<Task> list = new ArrayList<Task>();
		try {
			Task temp = null;
			StringBuffer sb=new StringBuffer();
			sb.append("select * from task_manage order by task_priority");
			if(ASC) {
				sb.append(" ASC");
			}else {
				sb.append(" DESC");
			}
			PreparedStatement pst=conn.prepareStatement(sb.toString());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				temp = new Task();
				temp.setId(rs.getInt("id"));
				temp.setTask_name(rs.getString("task_name"));
				temp.setTask_difficulty(rs.getInt("task_difficulty"));
				temp.setTask_charge(rs.getString("task_charge"));
				temp.setTask_priority(rs.getInt("task_priority"));
				temp.setTask_progress(rs.getInt("task_progress"));
				temp.setTask_start(rs.getDate("task_start"));
				temp.setTask_end(rs.getDate("task_end"));
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	public List<Task> queryTaskOrderByDifficulty(boolean ASC){
		List<Task> list = new ArrayList<Task>();
		try {
			Task temp = null;
			StringBuffer sb=new StringBuffer();
			sb.append("select * from task_manage order by task_difficulty");
			if(ASC) {
				sb.append(" ASC");
			}else {
				sb.append(" DESC");
			}
			PreparedStatement pst=conn.prepareStatement(sb.toString());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				temp = new Task();
				temp.setId(rs.getInt("id"));
				temp.setTask_name(rs.getString("task_name"));
				temp.setTask_difficulty(rs.getInt("task_difficulty"));
				temp.setTask_charge(rs.getString("task_charge"));
				temp.setTask_priority(rs.getInt("task_priority"));
				temp.setTask_progress(rs.getInt("task_progress"));
				temp.setTask_start(rs.getDate("task_start"));
				temp.setTask_end(rs.getDate("task_end"));
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	public static void main(String[] args) {
		Dao test = new Dao();
		 Task t=new Task();
		 t.setId(11);
		 t.setTask_charge("yi0");
		 t.setTask_difficulty(10);
		 t.setTask_name("test");
		 t.setTask_priority(23); 
		 t.setTask_progress(10);
		 List<Map<String,Object>>params=new ArrayList<Map<String,Object>>();
		 Map<String,Object>param=new HashMap<String,Object>();
		 param.put("name", "task_charge");
		 param.put("rela","=");
		 param.put("value", "'yi'");
		 params.add(param);
		 param=new HashMap<String,Object>();
		 param.put("name", "task_name");
		 param.put("rela","=");
		 param.put("value", "'test2'");
		 params.add(param);
		// System.out.println(test.queryTaskByName(t));
		List<Task> list = new ArrayList<Task>();
		list = test.queryTaskOrderByDifficulty(true);
		for (Task temp : list) {
			System.out.println(temp.toString());
		}
	}
}
