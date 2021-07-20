package com.extenda_retail.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.extenda_retail.exercise.request.Range;
import com.extenda_retail.exercise.response.MessageResponseGenerator;
import com.extenda_retail.exercise.service.NumberService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author shozab
 *
 */

@RestController
@RequestMapping("/perfect-number")
@Slf4j
public class MainController {

	@Autowired
	private NumberService numberService;

	private final String LOGGER = MainController.class.getName();

	/**
	 * To check one number
	 * 
	 * @param number
	 * @return String
	 */

	@GetMapping("/check/{number}")
	public ResponseEntity<String> checkNumberForPerfect(@PathVariable("number") Long number) {
		log.info(LOGGER + " inside method checkNumberForPerfect()");
		Boolean status = numberService.checkIfNumberIsPerfect(number);
		MessageResponseGenerator responseGenerator = new MessageResponseGenerator();
		if (status) {
			return new ResponseEntity<String>(responseGenerator.generatePerfectNumberResponse(number), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(responseGenerator.generateNotAPerfectNumberResponse(number),
					HttpStatus.OK);
		}
	}

	/**
	 * To check range of numbers
	 * 
	 * @param range
	 * @return
	 */
	@GetMapping("/check-all")
	public ResponseEntity<List<String>> checkNumberRangeForPerfect(@RequestBody Range range) {
		log.info(LOGGER + " inside method checkNumberRangeForPerfect()");
		List<String> listOfNumbers = numberService.checkAllNumbers(range);
		if (listOfNumbers != null && !listOfNumbers.isEmpty()) {
			return new ResponseEntity<List<String>>(listOfNumbers, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);
		}

	}

}
