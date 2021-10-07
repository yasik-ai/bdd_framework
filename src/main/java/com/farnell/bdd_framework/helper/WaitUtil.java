package com.farnell.bdd_framework.helper;

import java.util.concurrent.TimeUnit;

public class WaitUtil {

	/**
	 * @Description Method to pause the execution of the automation script
	 * @param milliseconds
	 */
	public void pause(Integer milliseconds) {
		try {
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
