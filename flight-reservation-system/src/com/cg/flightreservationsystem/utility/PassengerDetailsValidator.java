package com.cg.flightreservationsystem.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.flightreservationsystem.exception.FRSException;

public class PassengerDetailsValidator {
	public void isNameValid(String name) throws FRSException {
		int nameCount = 0;

		Pattern pattern = Pattern.compile("^[A-Z]{1}[a-z]{2,20}\\s[A-Z]{1}[a-z]{4,20}$");

		Matcher m = pattern.matcher(name);

		if (!m.find()) {
			throw new FRSException("Passenger " + ++nameCount + " Name is Invalid");
		}
	}

	public void isNoOfPassengersValid(int noOfPassengers, int remainingSeats) throws FRSException {
		Pattern pattern = Pattern.compile("^[1-9]{1}$");

		Matcher m = pattern.matcher(noOfPassengers + "");

		if (!m.find()) {
			throw new FRSException(ExceptionMessages.MESSAGE2);
		}

		if (noOfPassengers > remainingSeats) {
			throw new FRSException("Only " + remainingSeats + " are remaining");
		}

	}

	public void isAgeValid(String age) throws FRSException {
		int ageCount = 0;
		Pattern pattern = Pattern.compile("^[1-9]{1,2}");

		Matcher m = pattern.matcher(age);

		if (!m.find()) {
			throw new FRSException("Passenger " + ++ageCount + " Age is Invalid");
		}

	}

	public void isMobileNoValid(String mobileNo) throws FRSException {
		int mobileNoCount = 0;
		Pattern pattern = Pattern.compile("^[6-9]{1}[0-9]{9}$");

		Matcher m = pattern.matcher(mobileNo);

		if (!m.find()) {
			throw new FRSException("Passenger " + ++mobileNoCount + " Mobile No is Invalid");
		}
	}

	public void isEmailIdValid(String emailId) throws FRSException {
		int emailCount = 0;

		Pattern pattern = Pattern.compile("[a-z0-9._%+-]{6,12}+@[a-z0-9.-]{4,10}\\.[a-z]{2,6}");
		Matcher m = pattern.matcher(emailId);

		if (!m.find()) {
			throw new FRSException("Passenger " + ++emailCount + " Email Id is Invalid");
		}
	}

	// it will check length of ticket id(should be 1-3)
	public boolean isTicketIdValid(String ticketId) {
		Pattern pattern = Pattern.compile("^[1-9]{1}[0-9]{0,2}$");
		Matcher m = pattern.matcher(ticketId);

		if (m.find()) {
			return true;
		} else {
			return false;
		}
	}
}
