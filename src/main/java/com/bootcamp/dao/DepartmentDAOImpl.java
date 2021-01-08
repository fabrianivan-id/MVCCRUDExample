package com.bootcamp.dao;

import com.bootcamp.model.Department;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class DepartmentDAOImpl implements DepartmentDAO{
    @Autowired
    private SessionFactory sessionFactory;

    public void addDepartment(Department department){
        sessionFactory.getCurrentSession().saveOrUpdate(department);
    }

    @SuppressWarnings("unchecked")
    public List<Department> getAllDepartments(){
        return sessionFactory.getCurrentSession().createQuery("from Department").list();

    }

    @Override
    public void deleteDepartment(Integer departmentId){
        Department department = (Department) sessionFactory.getCurrentSession().load(Department.class, departmentId);
        if(null != department){
            this.sessionFactory.getCurrentSession().delete(department);
        }
    }
    @Override
    public Department getDepartment(int departmentId){
        return (Department) sessionFactory.getCurrentSession().get(Department.class, departmentId);
    }

    @Override
    public Department updateDepartment(Department department){
        sessionFactory.getCurrentSession().update(department);
        return department;
    }

}
