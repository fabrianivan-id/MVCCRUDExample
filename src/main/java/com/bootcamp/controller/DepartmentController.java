package com.bootcamp.controller;

import com.bootcamp.model.Department;
import com.bootcamp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/listDepartment")
    public ModelAndView listDepartment(ModelAndView model) throws IOException{
        List<Department> listDepartment = departmentService.getAllDepartments();
        model.addObject("listDepartment", listDepartment);
        model.setViewName("Department");
        return model;
    }
    @RequestMapping(value = "/newDepartment", method = RequestMethod.GET)
    public ModelAndView newDepartment(ModelAndView model){
        Department department = new Department();
        model.addObject("department", department);
        model.setViewName("DepartmentForm");
        return model;
    }
    @RequestMapping(value = "/saveDepartment", method = RequestMethod.POST)
    public ModelAndView saveDepartment(@ModelAttribute Department department){
        if(department.getId() == 0){
            //If employee ud us 0 then creating the employee after updating the department
            departmentService.addDepartment(department);
        }
        else{
            departmentService.updateDepartment(department);
        }
        return new ModelAndView(("redirect:/"));
    }
    @RequestMapping(value="/deleteDepartment", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(HttpServletRequest request){
        int departmentID = Integer.parseInt(request.getParameter("id"));
        departmentService.deleteDepartment(departmentID);
        return new ModelAndView("redirect:/");
    }
    @RequestMapping(value="/editDepartment", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request){
        int departmentId = Integer.parseInt(request.getParameter("id"));
        Department department = departmentService.getDepartment(departmentId);
        ModelAndView model = new ModelAndView(("DepartmentForm"));
        model.addObject("department", department);
        return model;
    }
}
