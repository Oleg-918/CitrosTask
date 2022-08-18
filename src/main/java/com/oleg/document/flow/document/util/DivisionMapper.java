package com.oleg.document.flow.document.util;

import com.oleg.document.flow.document.dto.DivisionDTO;
import com.oleg.document.flow.document.model.Division;
import org.mapstruct.Mapper;

@Mapper
public interface DivisionMapper {
    DivisionDTO toDivisionDTO(Division division);
    Division toDivision(DivisionDTO divisionDTO);
}
