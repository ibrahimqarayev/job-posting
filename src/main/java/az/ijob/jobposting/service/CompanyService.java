package az.ijob.jobposting.service;

import az.ijob.jobposting.exception.ResourceNotFoundException;
import az.ijob.jobposting.model.Company;
import az.ijob.jobposting.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public Company findById(Long companyId) {
        return companyRepository.findById(companyId).orElseThrow(() -> new ResourceNotFoundException("Company not found with id: " + companyId));
    }

}
