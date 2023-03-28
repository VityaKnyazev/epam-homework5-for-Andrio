package com.kniazeu.homework05;

import java.util.ArrayList;

public class Catalog implements IComposite {
	private ArrayList<File> file = new ArrayList<File>();
	private String name;
	
	public Catalog(String name) {
		this.name = name;
	}
	
	public void add(File file) {
		this.file.add(file);
	}
	
	public String getName() {
		return name;
	}
	
	public String[] getFiles() throws FilePathException {
		if (isFilesPresent()) {
			String[] file = new String[this.file.size()];
			for (int i = 0; i < file.length; i++) {
				file[i] = this.file.get(i).getName();
			}
			return file;
		} else {
			throw new FilePathException("Catalog is empty! Files are not found!");
		}
	}
	
	private boolean isFilesPresent(){
		return file.size() > 0;
	}
	
	@Override
	public void print() {
		String[] name = this.name.split("/");
		int interval = 1;	
		
		for (int i = 0; i < name.length; i++) {
			if (i == 0) {
				System.out.printf("%s%n", name[i]);
			} else {
				System.out.format("%" + interval + i +"s%n", name[i]);
			}	
						
			if (i == name.length - 1) {
				for (File singleFile : file) {
					System.out.format("%" + interval + i + "s%n", singleFile.getName());
				}
			}
		}		
	}
	
}
