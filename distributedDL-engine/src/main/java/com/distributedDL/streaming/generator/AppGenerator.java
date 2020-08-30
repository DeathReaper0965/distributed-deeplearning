package com.distributedDL.streaming.generator;

import java.io.IOException;

public class AppGenerator extends ConsumerGenerator {
	
	public AppGenerator() throws IOException {
		super();
	}
	
	public static void main(String args[]) {
		
		try {
			AppGenerator generator = new AppGenerator();

			try {
				generator.generate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
