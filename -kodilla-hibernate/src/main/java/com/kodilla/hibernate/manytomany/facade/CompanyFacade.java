package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class CompanyFacade {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private CompanyDao companyDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyFacade.class);

    public List<Employee> getEmployeesByLastName(String lastName) {
        LOGGER.info("Start searching for employees by lastname: " + lastName);
        List<Employee> result = employeeDao.retrieveEmployeeWithoutAllLetters(lastName);
        if (result.size() > 0) {
            LOGGER.info("Found " + result.size() + " employee(s)");
            return result;
        }
        LOGGER.error(SearchProcessingException.ERR_NOT_FOUND_EMPLOYEE);
        return null;
    }

    public List<Company> getCompanyByName(String name) {
        LOGGER.info("Start searching for company by name: " + name);
        List<Company> result = companyDao.retrieveCompanyWithoutAllLetters(name);
        if (result.size() > 0) {
            LOGGER.info("Found " + result.size() + " company(ies)");
            return result;
        }
        LOGGER.error(SearchProcessingException.ERR_NOT_FOUND_COMPANY);
        return null;
    }
}
