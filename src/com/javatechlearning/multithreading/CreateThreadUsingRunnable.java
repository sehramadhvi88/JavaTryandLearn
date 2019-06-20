package com.javatechlearning.multithreading;

public class CreateThreadUsingRunnable implements Runnable{

	
	public static void main(String[] args) {
	
		
		System.out.println("Inside :"+ Thread.currentThread().getName());
		
		
		System.out.println("Creating Runnable...");
		Runnable runn= new CreateThreadUsingRunnable();
		System.out.println("Creating thread...");
        Thread thread = new Thread(runn);

        System.out.println("Starting thread...");
        thread.start();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Inside :"+ Thread.currentThread().getName());
		System.out.println("Running thread by implementing runnable");
	}
	
	
	
	
}
