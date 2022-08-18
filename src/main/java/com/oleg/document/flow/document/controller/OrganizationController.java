package com.oleg.document.flow.document.controller;

import com.oleg.document.flow.document.dto.OrganizationDTO;
import com.oleg.document.flow.document.model.Organization;
import com.oleg.document.flow.document.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class OrganizationController {
    private final OrganizationService organizationService;

    @PostMapping("/organization")
    public OrganizationDTO create(@RequestBody @Valid OrganizationDTO organizationDTO) {
        return organizationService.createNewOrganization(organizationDTO);
    }

    @DeleteMapping("/organization/{id}")
    public void delete(@PathVariable("id") Integer id) {
        organizationService.deleteOrganization(id);
    }

    @PutMapping("/organization")
    public OrganizationDTO update(@RequestBody @Valid OrganizationDTO organizationDTO) {
        return organizationService.updateOrganization(organizationDTO);
    }

    @GetMapping("/organization")
    public List<Organization> getAll() {
        return organizationService.getAllOrganization();
    }

}
