package com.oleg.document.flow.document.service;

import com.oleg.document.flow.document.dto.DivisionDTO;
import com.oleg.document.flow.document.model.Division;
import com.oleg.document.flow.document.repository.DivisionRepository;
import com.oleg.document.flow.document.util.DivisionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DivisionService {
    private final DivisionRepository divisionRepository;
    private final DivisionMapper divisionMapper;


    public DivisionDTO createNewDivision(DivisionDTO divisionDTO) {
        Division division = divisionMapper.toDivision(divisionDTO);
        divisionRepository.save(division);
        return divisionMapper.toDivisionDTO(division);
    }

    public DivisionDTO updateDivision(DivisionDTO divisionDTO) {
        Division division = divisionMapper.toDivision(divisionDTO);
        divisionRepository.save(division);
        return divisionMapper.toDivisionDTO(division);
    }

    public void deleteDivision(Integer id) {
        divisionRepository.deleteById(id);
    }

    public List<Division> getAllDivision() {
        return divisionRepository.findAll();
    }
}
