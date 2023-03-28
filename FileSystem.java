package com.kniazeu.homework05;

import java.util.Scanner;

public class FileSystem {
		
	public static void main(String[] args) {
		System.out.println("Print path to save like D:/123sas/32dff3_5s-4/1-4_df.txt \nPrint exit to close.");
		start();
	}
	
	public static void start() {				
			Scanner scanner = new Scanner(System.in);
			
			while (true) {
				String result = scanner.nextLine();
				if (result.equals("exit")) break;
				switch (result) {
					case "print":
						Composite composite = Composite.getCompositeInstance();
						try {
							composite.print();
						} catch (PathException e) {
							System.err.println(e.getMessage());							
						}
					break;					
					default :
						try {
							StringChecker stringChecker = new StringChecker(result);
							Path path = new Path(stringChecker.checkAndReturnPath());
							path.process();							
						} catch (PathException pe) {
							System.err.println(pe.getMessage());							
						}
					break;
				}	
			}
			scanner.close();
		}		
}