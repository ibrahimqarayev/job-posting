package az.ijob.jobposting.service;

import az.ijob.jobposting.model.Company;
import az.ijob.jobposting.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public Company findByName(String name) {
        Optional<Company> optionalCompany = companyRepository.findByName(name);
        return optionalCompany.orElseGet(() -> saveCompany(name));
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company saveCompany(String name) {
        Company company = new Company(name);
        return companyRepository.save(company);
    }

}
