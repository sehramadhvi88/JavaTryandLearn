package com.javatechlearning;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {

	public static void main(String[] args) {
		
		CompletableFuture cf = CompletableFuture.runAsync(()->{
			
			try {
				System.out.println("Running asynchronous task in parallel");
				TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException ex) {
				throw new IllegalStateException(ex);
				}
		}); 
		
		//cf.get();
		
		CompletableFuture cfsupply = CompletableFuture.supplyAsync(()->{
			
			try {
				TimeUnit.SECONDS.sleep(1);
				
			}catch(InterruptedException e) {
				throw new IllegalStateException(e);
			}
			
			return "This is the result of the asynchronous computation";
			
		});
		
		CompletableFuture cfsupply1 = CompletableFuture.supplyAsync(()->{
			
			try {
				TimeUnit.SECONDS.sleep(1);
				
			}catch(InterruptedException e) {
				throw new IllegalStateException(e);
			}
			
			return "John";
			
		});
		
		CompletableFuture result = cfsupply1.thenApply(name -> "Hello "+name).thenApply(greet -> greet + " Welcome to new Company!!");
		
		
		
		
	}
	
}
