package com.oleg.document.flow.document.service;

import com.oleg.document.flow.document.dto.OrganizationDTO;
import com.oleg.document.flow.document.model.Organization;
import com.oleg.document.flow.document.repository.OrganizationRepository;
import com.oleg.document.flow.document.util.OrganizationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrganizationService {
    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;


    public OrganizationDTO createNewOrganization(OrganizationDTO organizationDTO){
        Organization organization = organizationMapper.toOrganization(organizationDTO);
        organizationRepository.save(organization);
        return organizationMapper.toOrganizationDTO(organization);
    }

    public OrganizationDTO updateOrganization(OrganizationDTO organizationDTO){
        Organization organization = organizationMapper.toOrganization(organizationDTO);
        organizationRepository.save(organization);
        return organizationMapper.toOrganizationDTO(organization);
    }

    public void deleteOrganization(Integer id){
        organizationRepository.deleteById(id);
    }

    public List<Organization> getAllOrganization(){
        return organizationRepository.findAll();
    }
}
