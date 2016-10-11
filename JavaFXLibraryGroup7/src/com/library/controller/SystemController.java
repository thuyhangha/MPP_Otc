package com.library.controller;

import java.util.Random;

import com.library.model.DataAccessFacade;
import com.library.model.DataAccess;


public class SystemController {

	private static DataAccess dataAccess = null;

	private SystemController() {
	}

	public static DataAccess getDataAccessInstance() {
		if (dataAccess == null) {
			dataAccess = new DataAccessFacade();
		}
		return dataAccess;
	}

	public static void setDataAccess(DataAccess f) {
		dataAccess = f;
	}

	public static String getRandom() {
		String myRandomNumber;
		Random random = new Random();
		myRandomNumber = Long.toString(System.currentTimeMillis()) + Integer.toString(random.nextInt(10000));
		return myRandomNumber;
	}

}
