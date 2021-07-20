package com.extenda_retail.exercise.service;

import java.util.List;

import com.extenda_retail.exercise.request.Range;

public interface NumberService {

	Boolean checkIfNumberIsPerfect(Long number);

	List<String> checkAllNumbers(Range range);

}
