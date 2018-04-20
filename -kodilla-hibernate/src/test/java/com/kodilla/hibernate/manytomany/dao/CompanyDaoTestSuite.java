package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.facade.CompanyFacade;
import com.kodilla.hibernate.manytomany.facade.SearchProcessingException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private CompanyFacade companyFacade;

    @Test
    public void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalski = new Employee("Linda", "Kovalski");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalski);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalski);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalski.getCompanies().add(dataMaesters);
        lindaKovalski.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int sofwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = softwareMachine.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, sofwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);
        Assert.assertEquals("Kovalski", employeeDao.retrieveEmployeeWithLastname("Kovalski").get(0).getLastname());
        Assert.assertEquals("Software Machine", companyDao.retrieveCompanyWithFirstThreeLetters("sof").get(0).getName());

        //CleanUp
        try {
            companyDao.delete(sofwareMachineId);
            companyDao.delete(dataMaestersId);
            companyDao.delete(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }
    @Test
    public void testCompanyFacade() throws SearchProcessingException {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalski = new Employee("Linda", "Kovalski");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalski);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalski);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalski.getCompanies().add(dataMaesters);
        lindaKovalski.getCompanies().add(greyMatter);
        //When
        int employeesQuantity;
        int companiesQuantity;
        companyDao.save(softwareMachine);
        int sofwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = softwareMachine.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();
        try {
            List<Employee> employeesResult = companyFacade.getEmployeesByLastName("%val%");
            List<Company> companiesResult = companyFacade.getCompanyByName("%Ma%");
            employeesQuantity = employeesResult.size();
            companiesQuantity = companiesResult.size();
            employeesResult.stream()
                    .forEach(employee -> System.out.println("Found --> " + employee.getFirstname() + " " + employee.getLastname()));
            companiesResult.stream()
                    .forEach(company -> System.out.println("Found --> " + company.getName()));
        } catch (NullPointerException e) {
            throw new SearchProcessingException(SearchProcessingException.ERR_NOT_FOUND_EMPLOYEE + " or " + SearchProcessingException.ERR_NOT_FOUND_COMPANY);
        }
        //Then
        Assert.assertEquals(1, employeesQuantity);
        Assert.assertEquals(3, companiesQuantity);
        //CleanUp
        try {
            companyDao.delete(sofwareMachineId);
            companyDao.delete(dataMaestersId);
            companyDao.delete(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }
}
