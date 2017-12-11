package vitualmachine.chapter7.mat;

import java.util.List;
import java.util.Vector;

public class Student {
	private int id;
	private String name;
	private List<WebPage> history = new Vector<WebPage>();
	public Student(int id, String name){
		super();
		this.id = id;
		this.name = name;
	}
	
	public void visist(WebPage wp){
		history.add(wp);
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
	public List<WebPage> getHistory() {
		return history;
	}
	public void setHistory(List<WebPage> history) {
		this.history = history;
	}
	
	
}


