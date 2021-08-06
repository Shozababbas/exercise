package com.ER.exercise.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ER.exercise.request.Range;
import com.ER.exercise.response.MessageResponseGenerator;
import com.ER.exercise.service.NumberService;

@Service
public class NumberServiceImpl implements NumberService {

	@Override
	public Boolean checkIfNumberIsPerfect(Long number) {
		if (number == 1)
			return false;
		int sum = 1;
		for (int i = 2; i * i <= number; i++) {

			if (number % i == 0) {
				if (i * i == number)
					sum += i;
				else
					sum += i + (number / i);
			}
		}
		if (sum == number)
			return true;
		return false;
	}

	@Override
	public List<String> checkAllNumbers(Range range) {
		List<String> listToReturn = new ArrayList<>();
		for (Long i = range.getFrom(); i <= range.getTo(); i++) {
			Boolean status = checkIfNumberIsPerfect(i);
			MessageResponseGenerator responseGenerator = new MessageResponseGenerator();
			String message = "";
			if (status) {
				message = responseGenerator.generatePerfectNumberResponse(i);
				listToReturn.add(message);
			} else {
				message = responseGenerator.generateNotAPerfectNumberResponse(i);
				listToReturn.add(message);
			}
		}
		return listToReturn;
	}

}
