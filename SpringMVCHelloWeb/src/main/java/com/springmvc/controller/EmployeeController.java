package com.springmvc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.bean.Employee;

@Controller
public class EmployeeController {

	@ModelAttribute("Employee")
	public Employee addToRequestScope() {
		System.out.println("In @ModelAttribute");
		Employee emp = new Employee(12, "SSS_ModelAttribute", 34l, 32);
		return emp;
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView employee() {
		return new ModelAndView("employeeForm", "command", new Employee());
	}

	@RequestMapping(value = "/addEmployee", params = "action1", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("SpringWeb") Employee employee, ModelMap model) {
		model.addAttribute("name", employee.getName());
		model.addAttribute("age", employee.getAge());
		model.addAttribute("empId", employee.getEmpId());
		model.addAttribute("salary", employee.getSalary());
		return "employeeDetail";
	}

	@RequestMapping(value = "/addEmployee", params = "action2", method = RequestMethod.POST)
	public String addEmployeeException(@ModelAttribute("SpringWeb") Employee employee, ModelMap model)
			throws EmployeeException {

		if (employee.getName().length() < 5) {
			throw new EmployeeException("Given name is too short");
		} else {
			model.addAttribute("name", employee.getName());
		}
		if (employee.getAge() < 10) {
			throw new EmployeeException("Given age is too low");
		} else {
			model.addAttribute("age", employee.getAge());
		}
		model.addAttribute("empId", employee.getEmpId());
		model.addAttribute("salary", employee.getSalary());
		return "employeeDetail";
	}
	
	
	@ExceptionHandler(EmployeeException.class)
	public ModelAndView handleCustomException(EmployeeException ex) {
		ModelAndView model = new ModelAndView("ExceptionPage");
		model.addObject("exception", ex);
		return model;

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {
		ModelAndView model = new ModelAndView("error");
		return model;

	}

	

	@SuppressWarnings("rawtypes")
	@RequestMapping("/dosomething")
	public String requestHandlingMethod(Model model, HttpServletRequest request) {
		System.out.println("Inside of dosomething handler method");

		System.out.println("--- Model data ---");
		Map modelMap = model.asMap();
		Object modelValue = null;
		for (Object modelKey : modelMap.keySet()) {
			modelValue = modelMap.get(modelKey);
			System.out.println(modelKey + " -- " + modelValue);
		}

		System.out.println("=== Request data ===");
		java.util.Enumeration reqEnum = request.getAttributeNames();
		while (reqEnum.hasMoreElements()) {
			String s = (String) reqEnum.nextElement();
			System.out.println(s);
			System.out.println("==" + request.getAttribute(s));
		}
		model.addAttribute("name", ((Employee) modelValue).getName());
		model.addAttribute("age", ((Employee) modelValue).getAge());
		model.addAttribute("empId", ((Employee) modelValue).getEmpId());
		model.addAttribute("salary", ((Employee) modelValue).getSalary());
		return "employeeDetail";
	}
}