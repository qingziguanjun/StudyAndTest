package vitualmachine.chapter7.mat;

import java.util.List;
import java.util.Vector;

public class TraceStudent {
	static List<WebPage> webPages = new Vector<WebPage>();
	public static void createWebPages(){
		for(int i=0; i<100; i++){
			WebPage wp = new WebPage();
			wp.setUrl("http://www." + Integer.toString(i) + ".com");
			wp.setContent(Integer.toString(i));
			webPages.add(wp);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createWebPages();
		Student s3 = new Student(3, "billy");
		Student s5 = new Student(5, "alice");
		Student s7 = new Student(7, "taotao");
		
		for(int i=0; i<webPages.size(); i++){
			if(i % s3.getId() == 0){
				s3.visist(webPages.get(i));
			}
			if(i % s5.getId() == 0){
				s5.visist(webPages.get(i));
			}
			if(i % s7.getId() == 0){
				s7.visist(webPages.get(i));
			}
		}
		webPages.clear();
		System.gc();

	}

}
