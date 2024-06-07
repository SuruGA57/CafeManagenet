package com.in.cafe.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CafeUtils {

	private CafeUtils() {
	}

	public static ResponseEntity<String> errorResponse(String responseMessage, HttpStatus httpStatus) {
		return new ResponseEntity<String>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	


    // Method to create a generic success response
    public static ResponseEntity<String> successResponse(String message) {
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
//
//    // Method to create a generic error response
//    public static ResponseEntity<String> errorResponse(String message) {
//        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    // Method to create a bad request response
    public static ResponseEntity<String> badRequestResponse(String message) {
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    // Method to create a not found response
    public static ResponseEntity<String> notFoundResponse(String message) {
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

}
