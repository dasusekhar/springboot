package com.example.springbootdailycodebuffer.controller;

import com.example.springbootdailycodebuffer.entity.Department;
import com.example.springbootdailycodebuffer.error.DepartmentNotFoundException;
import com.example.springbootdailycodebuffer.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);



    @PostMapping("/saveDepartment")
    public String saveDepartment(@Valid  @RequestBody Department department)
    {
        departmentService.saveDepartment(department);
        LOGGER.info("inside the save department of departmentController");

        return "successfully saved in database";
    }
    @GetMapping("/getDepartment")
    public List<Department> getDepartmentDetails(Department department)
    {
        LOGGER.info("inside the getDepartmentDetails of departmentController");
        return departmentService.getDepartmentDetails(department);
    }

    @GetMapping("/{id}")
    public  Department getById(@PathVariable ("id")   Long  departmentId) throws DepartmentNotFoundException {
        LOGGER.info("inside the getById of departmentController");
        return departmentService.getById(departmentId);
    }

      @DeleteMapping("/delete/{id}")
    public String  deleteById(@PathVariable("id") Long  departmentId)
            {
                departmentService.deleteById(departmentId);
                LOGGER.info("inside the deleteById  of departmentController");
                return  "successfully deleted"+departmentId;

            }
            @PutMapping("/update/{id}")
            public  Department  updateDepartment(@PathVariable ("id") Long  departmentId,@RequestBody  Department department)
            {
                LOGGER.info("inside the updateDepartment of departmentController");
                return departmentService.updateDepartment(departmentId,department);
            }








}
