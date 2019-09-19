package com.lambdaschool.school.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.model.Instructor;
import com.lambdaschool.school.service.CourseService;
import com.lambdaschool.school.service.InstructorService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseControllerIntegrationTest
{
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private InstructorService instructorService;

	@Autowired
	private CourseService courseService;

	@Before
	public void setUp()
	{
		RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
	}

	// GET /courses/courses
	@Test
	public void whenMeasuredResponseTime()
	{
		given().when().get("/courses/courses").then().time(lessThan(5000L));
	}

	// POST /courses/course/add
	@Test
	public void givenPostACourse() throws Exception
	{
		Instructor i1 = instructorService.findInstructorById(1);
		Course c8 = new Course("TEST - Java Testing", i1);

		ObjectMapper mapper = new ObjectMapper();
		String stringC8 = mapper.writeValueAsString(c8);

		given().contentType("application/json").body(stringC8).when().post("/courses/course/add").then().statusCode(201);
	}
}
