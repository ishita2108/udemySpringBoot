package com.in28minutes.springboot.firstrestapi.survey;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class SurveyResource {
	
	private SurveyService surveyService;
	
	public SurveyResource(SurveyService surveyService) {
		this.surveyService = surveyService;
	}

	@RequestMapping("/surveys")
	public List<Survey> getAllSurveys() {
		List<Survey> surveys = surveyService.getAllSurveys();
		return surveys;

	}
	
	@RequestMapping("/surveys/{id}")
	public Survey getSurveyById(@PathVariable String id) {
		Survey survey = surveyService.getSurveyById(id);
		if(survey == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return survey;

	}
	
	@RequestMapping("/surveys/{id}/questions")
	public List<Question> getAllSurveyQuestions(@PathVariable String id) {
		List<Question> questions = surveyService.getAllSurveyQuestion(id);
		if(questions == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return questions;

	}
	
	@RequestMapping("/surveys/{id}/questions/{qid}")
	public Question getSurveyQuestionsById(@PathVariable String id, @PathVariable String qid) {
		Question question = surveyService.getSurveyQuestionsById(id, qid);
		if(question == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return question;

	}
	
	@RequestMapping(value = "/surveys/{id}/questions", method = RequestMethod.POST)
	public ResponseEntity<Object> addNewSurveyQuestion(@PathVariable String id, @RequestBody Question question){
		String questionId = surveyService.addNewSurveyQuestion(id, question);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{questionId}").buildAndExpand(questionId).toUri();
		return ResponseEntity.created(location).build();

	}
	
	@RequestMapping(value = "/surveys/{id}/questions/{qid}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteSurveyQuestion(@PathVariable String id, @PathVariable String qid){
		String question = surveyService.deleteSurveyQuestion(id, qid);
		if(question == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.noContent().build();
	}


}
