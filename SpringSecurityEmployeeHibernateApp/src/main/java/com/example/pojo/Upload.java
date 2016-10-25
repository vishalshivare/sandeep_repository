package com.example.pojo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Upload {

	private String file;

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	List<String> list=new ArrayList<String>();;
	public Upload(String file) {
		super();
		File ff =new File("F:\\STSExample\\FileUpload3usingAjax\\images");
		for(String s:ff.list()){
			System.out.println(s);
		}
		this.file = file;
		System.out.println("In Pojo File name is:"+this.file);
		list.add(file);
		list.toString();
		System.out.println("Printing List"+list.toString());
		
		System.out.println("In Upload Pojo:Constructor");
		
	}

	@Override
	public String toString() {
		return "Upload [file=" + file + "]";
	}
	
	
}
