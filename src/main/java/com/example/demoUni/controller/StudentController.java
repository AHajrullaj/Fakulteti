package com.example.demoUni.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demoUni.entity.Student;
import com.example.demoUni.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired private StudentService studentService;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
	    
	     
	    return "index1";
	}
	
	
	@RequestMapping("/Student/new")
	public String showNewStudentPage(Model model) {
	    Student student = new Student();
	    model.addAttribute("student", student);
	    
	    return "Student/new_student";
	}
	
	@RequestMapping("/Student/index")
	public String showStudentList(Model model) {
	List<Student> listStudents = studentService.listAll();
    model.addAttribute("listStudents", listStudents);
    return "Student/index";
	}
	
	//another handler method to save the product information into the database:
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("student") Student student) {
		System.out.println(student.getFirstname()+"------------------------------------------"+student.dtRegjistrimi);
		studentService.save(student);
	     
	    return "redirect:/Student/index";
	}
	@RequestMapping("/Student/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("Student/edit_student");
	    Student student = studentService.get(id);
	    mav.addObject("student", student);
	     
	    return mav;
	}
	
	@RequestMapping("/Student/delete/{id}")
	public String deleteStudent(@PathVariable(name = "id") int id) {
		studentService.delete(id);
	    return "success";       
	}
	
	
}