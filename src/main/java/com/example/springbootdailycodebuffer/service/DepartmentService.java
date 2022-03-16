package com.example.springbootdailycodebuffer.service;

import com.example.springbootdailycodebuffer.entity.Department;
import com.example.springbootdailycodebuffer.error.DepartmentNotFoundException;
import com.example.springbootdailycodebuffer.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;


    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);

    }

    public List<Department> getDepartmentDetails(Department department) {
        return departmentRepository.findAll();
    }

    public Department getById(long  depeartmentId) throws DepartmentNotFoundException {
        Optional<Department> department=departmentRepository.findById(depeartmentId);
        if(!department.isPresent())
        {
            throw new DepartmentNotFoundException("Department not available");
        }
        return department.get();
    }

    public void  deleteById(long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    public Department updateDepartment(Long departmentId, Department department) {

        Department db=departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName())&&!" ".equalsIgnoreCase(department.getDepartmentName()))
        {
            db.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress())&&!" ".equalsIgnoreCase(department.getDepartmentAddress()))
        {
            db.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode())&&!" ".equalsIgnoreCase(department.getDepartmentCode()))
        {
            db.setDepartmentCode(department.getDepartmentCode());
        }


        return departmentRepository.save(db);
    }
}
