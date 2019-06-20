package com.javatechlearning.multithreading;

public class CreateThreadUsingAnonymousRunnable {

public static void main(String[] args) {
	
		
		System.out.println("Inside :"+ Thread.currentThread().getName());
		
		
		System.out.println("Creating Runnable...");
		// instead of implementing runnable interface we create anonymous class
		Runnable runn= new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Inside :"+ Thread.currentThread().getName());
				System.out.println("Running thread by using anonymous runnable instance");
			}
			
		};
		
		System.out.println("Creating thread 1...");
        Thread thread = new Thread(runn);

        System.out.println("Starting thread 1...");
        thread.start();
		
		Runnable runnLambda = () -> {
			System.out.println("Inside :"+ Thread.currentThread().getName());
			System.out.println("Running thread by using lambda runnable instance");
		};
		
		System.out.println("Creating thread 2...");
        Thread thread1 = new Thread(runnLambda);

        System.out.println("Starting thread 2...");
        thread1.start();
		
	}
	
	
	
}
