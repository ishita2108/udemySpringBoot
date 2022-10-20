package com.in28minutes.springboot.firstrestapi.survey;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SurveyResourceIT {
	
	
	private static String SPECIFIC_QUESTION_URL ="/surveys/Survey1/questions/Question1";
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
		JSONAssert.assertEquals(expectedResponse,responseEntity.getBody(),false);
//		System.out.println(responseEntity.getHeaders());
//		System.out.println(responseEntity.getBody());
	}

}
