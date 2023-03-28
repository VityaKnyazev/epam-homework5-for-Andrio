package com.kniazeu.homework05;

import java.util.ArrayList;


public class Composite implements IComposite {
	private static Composite composite;
	private ArrayList <Catalog> composition = new ArrayList<Catalog>();
		
	private Composite(){}
	
	public static Composite getCompositeInstance() {		
		if (composite == null) {
			composite = new Composite();
		} 		
		return composite;
	}	
	
	//Adding Catalog catalog to composition;
	public void addCatlog(String path) throws PathException {		
		Catalog catalog = null;
		
		//if path contains file
		if (path.contains(".")) {
			int lastIndex = path.lastIndexOf("/");
			String catalogPath = path.substring(0, lastIndex);
			String filePath = path.substring(lastIndex + 1);
			try {
				catalog = getCatalogOnPath(catalogPath);
				String[] fileInCatalog = catalog.getFiles();
				for (int i = 0; i < fileInCatalog.length; i++) {
					if (filePath.equals(fileInCatalog[i])) {
						throw new PathException("File in current catalog already exists!");
					}
				}
				catalog.add(new File(filePath));
				composition.remove(getCatalogIndex(catalog));
				composition.add(catalog);				
			} catch(CatalogPathException ec) {
				//if catalog not exists or do not find catalog number in composition
				//System.out.println(ec.getMessage());
				catalog = new Catalog(catalogPath);		
				catalog.add(new File(filePath));
				composition.add(catalog);				
			} catch(FilePathException ef) {
				//if catalog is empty and dose not contain files
				//System.out.println(ef.getMessage());
				catalog.add(new File(filePath));
				composition.remove(getCatalogIndex(catalog));
				composition.add(catalog);				
			}
		} else {
			try {
				catalog = getCatalogOnPath(path);
				throw new PathException("Catalog in this path already exist!");
			} catch(CatalogPathException ecp) {
				//System.out.println(ecp.getMessage());
				//if catalog not exists
				composition.add(new Catalog(path));				
			}
		}
		
	}		
	
	private final Catalog getCatalogOnPath(String path) throws CatalogPathException {
		
		for (int i = 0; i < composition.size(); i++) {
			if (path.equals(composition.get(i).getName())) {				
				return composition.get(i);
			}		
		}		
		throw new CatalogPathException("Error! Catalog on this path not found!");		
	}
	
	private final int getCatalogIndex(Catalog catalog) throws CatalogPathException {
		for (Catalog singleCatalog : composition) {
			if (catalog.getName().equals(singleCatalog.getName())) {				
				return composition.indexOf(singleCatalog);
			}		
		}		
		throw new CatalogPathException("Can't find catalog and its number on this path!");		
	}	
		
	@Override
	public void print() throws PathException {
		if (composition.isEmpty()) {
			throw new PathException("Error. Please add pathes in File System!");
		}				
		for (Catalog catalog : composition) {
			catalog.print();
		}
	}

}
