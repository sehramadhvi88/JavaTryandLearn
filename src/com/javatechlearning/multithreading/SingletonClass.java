package com.javatechlearning.multithreading;

public class SingletonClass {

	private static volatile SingletonClass _instance; // or private static final Singleton _instance;
	
	private SingletonClass() {}
	
	public static SingletonClass getInstance() {
		
		if(_instance == null) {
			synchronized(SingletonClass.class) {
				if(_instance == null)
					_instance= new SingletonClass();
			}
		}
		return _instance;
	}
	
	
}

/*
 * A variable declared with volatile keyword, has two main qualities which make it special.

1. If we have a volatile variable, it cannot be cached into the computer's(microprocessor) cache memory by any thread. 
Access always happened from main memory.

2. If there is a write operation going on a volatile variable, and suddenly a read operation is requested, 
it is guaranteed that the write operation will be finished prior to the read operation.

Two above qualities deduce that

a. All the threads reading a volatile variable will definitely read the latest value. Because no cached value can pollute it.
 And also the read request will be granted only after the completion of the current write operation.

And on the other hand,

b. If we further investigate the #2 that I have mentioned, we can see that volatile keyword is an ideal way to 
maintain a shared variable which has 'n' number of read threads and only one write thread to access it. Once we add the volatile keyword, it is done. No any other overhead about thread safety.

Conversly,

We can't make use of volatile keyword solely, to satisfy a shared variable which has more than one write threads accessing it.
 * 
 *
 */
