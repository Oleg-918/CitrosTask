package com.oleg.document.flow.document.util;

import com.oleg.document.flow.document.dto.OrganizationDTO;
import com.oleg.document.flow.document.model.Organization;
import org.mapstruct.Mapper;

@Mapper
public interface OrganizationMapper {
    OrganizationDTO toOrganizationDTO(Organization organization);
    Organization toOrganization(OrganizationDTO organizationDTO);
}
