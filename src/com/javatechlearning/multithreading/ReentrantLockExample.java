package com.javatechlearning.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

	private final ReentrantLock lock = new ReentrantLock();
	private int count=0;
	
	public static void main(String[] args) {
		
		ReentrantLockExample obj = new ReentrantLockExample();
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		executorService.submit(()->{
			 System.out.println("IncrementCount (First Thread) : " + obj.incrementAndGet() + "\n");
		});
		
		executorService.submit(()->{
			 System.out.println("IncrementCount (Second Thread) : " + obj.incrementAndGet() + "\n");
		});
		
		executorService.shutdown();
		
	}
	
	public int increment() {
		
		lock.lock();
		try {
			count = count+1;
		}finally {
			lock.unlock();
		}
		
		return count;
		
	}

	
	public int incrementAndGet() {
		
		System.out.println("check if lock is acquired ? "+lock.isLocked());
		
		System.out.println("check if lock is held by current thread ? "+lock.isHeldByCurrentThread());
		
		boolean tryAcquire = lock.tryLock();
		System.out.println("Lock Acquired : " + tryAcquire + "\n");

		if(tryAcquire) {
			try {
				Thread.sleep(2000);
				count = count+1;
			}catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }finally {
				lock.unlock();
			}
		}
		
		
		
		return count;
		
	}
	
	
	
}
