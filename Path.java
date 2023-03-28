package com.kniazeu.homework05;

public class Path {
	private String path;
	private Composite composite;
		
	public Path(String path) {	
		composite = Composite.getCompositeInstance();
		this.path = path;		
	}
		
	public void process() throws PathException {
		try {
			composite.addCatlog(path);
		} catch(PathException pe){
			throw new PathException(pe.getMessage());
		}
	}
	
}
