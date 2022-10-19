package com.in28minutes.springboot.firstrestapi.survey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class SurveyService {

	private static List<Survey> surveys = new ArrayList<Survey>();

	static {
		Question question1 = new Question("Question1", "Most Popular Cloud Platform Today",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
		Question question2 = new Question("Question2", "Fastest Growing Cloud Platform",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
		Question question3 = new Question("Question3", "Most Popular DevOps Tool",
				Arrays.asList("Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

		List<Question> questions = new ArrayList<Question>(Arrays.asList(question1, question2, question3));

		Survey survey = new Survey("Survey1", "My Favorite Survey", "Description of the Survey", questions);

		surveys.add(survey);

	}

	public List<Survey> getAllSurveys() {
		return surveys;
		
	}

	public Survey getSurveyById(String id) {
		Predicate<Survey> predicate = survey -> survey.getId().equals(id);
		Optional<Survey> optionalSurvey = surveys.stream().filter(predicate).findFirst();
		if(optionalSurvey.isEmpty()) {
			return null;
		}
		return optionalSurvey.get();
	}

	public List<Question> getAllSurveyQuestion(String id) {
		Survey survey = getSurveyById(id);
		if(survey == null) {
			return null;
		}
		List<Question> questions = survey.getQuestions();
		return questions;
	}

	public Question getSurveyQuestionsById(String id, String qid) {
		Survey survey = getSurveyById(id);
		if(survey == null) {
			return null;
		}
		else {
			Predicate<Question> predicate = question -> question.getId().equals(qid);
			Optional<Question> optionalQuestion = survey.getQuestions().stream().filter(predicate).findFirst();
			if(optionalQuestion.isEmpty()) {
				return null;
			}
			
			return optionalQuestion.get();	
		}
		
	}
	

}
