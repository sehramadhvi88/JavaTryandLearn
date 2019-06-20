package com.javatechlearning;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean flag = false;
		String str = null;
		int retry = 8;
		int b=0;
		
		do {
			try {
				System.out.println("b="+b); 
				int a = 10/b;
				
			}catch(Exception e) {
				flag = true;
				b=1;
				retry--;
				
				if (retry == 0) {
                    throw e;
                }
			}
			
		}while(flag && retry >0);
		
	}

}
