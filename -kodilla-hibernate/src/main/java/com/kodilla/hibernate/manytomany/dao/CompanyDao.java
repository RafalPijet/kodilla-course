package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CompanyDao extends CrudRepository<Company, Integer> {
    @Query(nativeQuery = true)
    List<Company> retrieveCompanyWithFirstThreeLetters(@Param("COMPANY_NAME") String companyName);
    @Query(nativeQuery = true)
    List<Company> retrieveCompanyWithoutAllLetters(@Param("COMPANY_NAME") String companyName);
}
