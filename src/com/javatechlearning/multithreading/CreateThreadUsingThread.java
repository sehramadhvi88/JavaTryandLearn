package com.javatechlearning.multithreading;

public class CreateThreadUsingThread extends Thread {

	public static void main(String[] args) {
		
		System.out.println("Inside :"+ Thread.currentThread().getName());
		
		System.out.println("Creating thread...");
        Thread thread = new CreateThreadUsingThread();

        System.out.println("Starting thread...");
        thread.start();
		
		
	}
	
	@Override
	public void run() {
		System.out.println("Inside :"+ Thread.currentThread().getName());
		System.out.println("Running thread by extending thread class");
	}
	
}
