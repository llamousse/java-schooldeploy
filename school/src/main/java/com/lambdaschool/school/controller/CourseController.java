package com.lambdaschool.school.controller;

import com.lambdaschool.restaurants.model.ErrorDetail;
import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.service.CourseService;
import com.lambdaschool.school.view.CountStudentsInCourses;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/courses")
public class CourseController
{
    @Autowired
    private CourseService courseService;

    @ApiOperation(value = "returns all Courses", response = Course.class, responseContainer = "List")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                         value = "Results page you want to retrieve (0..N)"),
        @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                         value = "Number of records per page."),
        @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                         value = "Sorting criteria in the format: property(,asc|desc). " +
                                 "Default sort order is ascending. " +
                                 "Multiple sort criteria are supported.")})
    @GetMapping(value = "/courses", produces = {"application/json"})
    public ResponseEntity<?> listAllCourses(
            @PageableDefault(page = 0,
                             size = 3)
                    Pageable pageable)
    {
        ArrayList<Course> myCourses = courseService.findAll(pageable);
        return new ResponseEntity<>(myCourses, HttpStatus.OK);
    }

    @ApiOperation(value = "returns Student Count in Courses", response = Course.class)
    @ApiResponses(value = {
            // code created
            @ApiResponse(code = 201, message = "Student Count Successful",
                         response = Course.class),
            // code error
            @ApiResponse(code = 500, message = "Error Returning Student Count",
                         response = ErrorDetail.class)
    })
    @GetMapping(value = "/studcount", produces = {"application/json"})
    public ResponseEntity<?> getCountStudentsInCourses()
    {
        return new ResponseEntity<>(courseService.getCountStudentsInCourse(), HttpStatus.OK);
    }

    @ApiOperation(value = "deletes Course by Id", response = Course.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Course Successfully Deleted",
                         response = void.class),
            @ApiResponse(code = 500, message = "Error Deleting Course",
                         response = ErrorDetail.class)
    })
    @DeleteMapping("/courses/{courseid}")
    public ResponseEntity<?> deleteCourseById(@PathVariable long courseid)
    {
        courseService.delete(courseid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
