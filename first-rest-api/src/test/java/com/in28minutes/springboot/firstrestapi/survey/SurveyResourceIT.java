package com.in28minutes.springboot.firstrestapi.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SurveyResourceIT {

	private static String SPECIFIC_QUESTION_URL = "/surveys/Survey1/questions/Question1";
	private static String ALL_QUESTIONS_URL = "/surveys/Survey1/questions";
	private static String SPECIFIC_SURVEY_URL = "/surveys/Survey1";
	private static String ALL_SURVEYS_URL = "/surveys";
	@Autowired
	private TestRestTemplate template;

	@Test
	void getSurveyQuestionsById_basicScenario() throws JSONException {
		ResponseEntity<String> responseEntity = template.getForEntity(SPECIFIC_QUESTION_URL, String.class);
		String expectedResponse = """
				{"id":"Question1",
				"description":"Most Popular Cloud Platform Today",
				"correctAnswer":"AWS"}
				""";
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);

	}

	@Test
	void getSurveyAllQuestions_basicScenario() throws JSONException {
		ResponseEntity<String> responseEntity = template.getForEntity(ALL_QUESTIONS_URL, String.class);
		String expectedResponse = """
									[
						  {
						    "id": "Question1"
						  },
						  {
						    "id": "Question2"
						  },
						  {
						    "id": "Question3"
						  }
						]
				""";
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);
		// System.out.println(responseEntity.getBody());

	}

	@Test
	void getSurveyById_basicScenario() throws JSONException {
		ResponseEntity<String> responseEntity = template.getForEntity(SPECIFIC_SURVEY_URL, String.class);
		String expectedResponse = """
								{
				    "id": "Survey1",
				    "title": "My Favorite Survey",
				    "description": "Description of the Survey",
				    "questions":[
						  {
						    "id": "Question1"
						  },
						  {
						    "id": "Question2"
						  },
						  {
						    "id": "Question3"
						  }
						]
				}
								""";
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);

	}

	@Test
	void getAllSurvey_basicScenario() throws JSONException {
		ResponseEntity<String> responseEntity = template.getForEntity(ALL_SURVEYS_URL, String.class);
		String expectedResponse = """
							[
				    {
				        "id": "Survey1",
				        "title": "My Favorite Survey",
				        "description": "Description of the Survey",
				        "questions": [
										  {
										    "id": "Question1"
										  },
										  {
										    "id": "Question2"
										  },
										  {
										    "id": "Question3"
										  }
										]
				    }
				]
								""";
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);

	}
	
	@Test
	void addNewSurveyQuestion_basicScenario() {
		
		String requestBody = """
				{
	    "description": "Your Favorite Language",
	    "options": [
	        "Java",
	        "Python",
	        "Java Script",
	        "C#"
	    ],
	    "correctAnswer": "Java Script"
	}
				""";
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		HttpEntity<String> entity = new HttpEntity<String>(requestBody, headers);
		ResponseEntity<String> responseEntity = template.exchange(ALL_QUESTIONS_URL, HttpMethod.POST, entity, String.class);
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		String locationHeader = responseEntity.getHeaders().get("Location").get(0);
		assertTrue(locationHeader.contains("/surveys/Survey1/questions"));
		
		template.delete(locationHeader);
		
	}



}
