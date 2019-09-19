//package com.lambdaschool.school.services;
//
//import com.lambdaschool.school.SchoolApplication;
//import com.lambdaschool.school.model.Course;
//import com.lambdaschool.school.model.Instructor;
//import com.lambdaschool.school.service.CourseService;
//import com.lambdaschool.school.service.InstructorService;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.persistence.EntityNotFoundException;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SchoolApplication.class)
//public class CourseServiceImplUnitTest
//{
//	// mocks - fake data
//	// stubs - code that forces return value
//
//	@Autowired
//	private CourseService courseService;
//
//	@Autowired
//	private InstructorService instructorService;
//
//	@Before
//	public void setUp()
//	{
//		MockitoAnnotations.initMocks(this);
//	}
//
//	@After
//	public void tearDown()
//	{
//	}
//
//	@Test
//	public void deleteFound()
//	{
//		courseService.delete(1);
//		assertEquals(5, courseService.findAll().size());
//	}
//
//	@Test(expected = EntityNotFoundException.class)
//	public void deleteNotFound()
//	{
//		courseService.delete(100);
//		assertEquals(5, courseService.findAll().size());
//	}
//
//	@Test
//	public void save()
//	{
//		String course7Name = "Java Testing";
//		Instructor instructor7Name = instructorService.findInstructorById(1);
//		Course c7 = new Course(course7Name, instructor7Name);
//
//		Course addCourse = courseService.save(c7);
//
//		assertNotNull(addCourse);
//
//		Course foundCourse = courseService.findCourseById(addCourse.getCourseid());
//		assertEquals(addCourse.getCoursename(), foundCourse.getCoursename());
//	}
//}
