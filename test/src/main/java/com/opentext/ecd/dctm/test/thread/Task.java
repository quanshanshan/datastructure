package com.opentext.ecd.dctm.test.thread;


import org.openjdk.jol.info.ClassLayout;

public class Task {
	
	public static final String TEXT = "text";
	
	int id;
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}

	String name;
	Task task;
	boolean isstop;
	boolean isstart;
	char xyz;
	
	
	public char getXyz() {
		return xyz;
	}
	public void setXyz(char xyz) {
		this.xyz = xyz;
	}
	public boolean isIsstart() {
		return isstart;
	}
	public void setIsstart(boolean isstart) {
		this.isstart = isstart;
	}
	
	public boolean isIsstop() {
		return isstop;
	}
	public void setIsstop(boolean isstop) {
		this.isstop = isstop;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return 34;
		
		
	}
	
	public static void main(String[] args) {
		
		Task task = new Task();
		task.setId(1);
		task.setName("te");
		System.out.println(ClassLayout.parseInstance(task).toPrintable());
		
		//System.out.println(RamUsageEstimator.shallowSizeOf(task));
	}

}
