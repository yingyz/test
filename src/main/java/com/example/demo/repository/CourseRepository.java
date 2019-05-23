package com.example.demo.repository;

import com.example.demo.modal.Course;
import com.example.demo.modal.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CourseRepository {
    List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        Course javaOne = Course.builder()
                .className("Java I")
                .instructor(new Instructor("Steve", "Jobs", "Phd", "TownHall201"))
                .startDate(new Date("8/1/2018"))
                .endDate(new Date("12/24/2018"))
                .timeFrame("8am-10am")
                .build();

        courses.add(javaOne);

      Course javaTwo = Course.builder()
        .className("Java II")
        .instructor(new Instructor("Tim", "Cook", "Phd", "TownHall202"))
        .startDate(new Date("8/1/2018"))
        .endDate(new Date("12/24/2018"))
        .timeFrame("1pm-4pm")
        .build();

      courses.add(javaTwo);

    }

    public List<Course> findAllClasses(){
        //链接数据库
        //返回数据库的信息
        return  courses;
    }

    public List<Course> findAllCourse(String searchByCourseName){

        return new ArrayList<Course>();
    }

    public List<Course> findCourseByName(String courseName) {
        List<Course> result = new ArrayList<>();
        courseName = courseName.replace("_"," ");
        for (Course c: courses)
        {
          if (c.getClassName().equals(courseName))
          {
            result.add(c);
          }
        }

        return result;
    }

  public void deleteCourseByName(String courseName) {

    courseName = courseName.replace("_"," ");
    for (Course c: courses)
    {
      if (c.getClassName().equals(courseName))
      {
        courses.remove(c);
        break;
      }
    }
    }

    public void addCourse (Course c)
    {
      courses.add(c);
    }

    public void updateCourse (Course c)
    {
      for(int i=0; i <courses.size(); i ++)
      {

        if(c.getClassName().equals(courses.get(i).getClassName()))
        {
          courses.set(i,c);
        }
      }
    }
}
