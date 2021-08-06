package com.ER.exercise.service;

import java.util.List;
import com.ER.exercise.request.Range;

public interface NumberService {

	Boolean checkIfNumberIsPerfect(Long number);

	List<String> checkAllNumbers(Range range);

}
