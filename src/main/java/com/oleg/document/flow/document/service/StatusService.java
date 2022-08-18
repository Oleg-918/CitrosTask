package com.oleg.document.flow.document.service;

import com.oleg.document.flow.document.dto.StatusDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class StatusService {
    private Map<String, List<String>> availableAction = new HashMap<>();

    @PostConstruct
    public void init() {
        availableAction.put("Start", List.of("Preparation"));
        availableAction.put("Preparation", List.of("Execution"));
        availableAction.put("Execution", List.of("Control"));
        availableAction.put("Control", List.of("Reception", "Modification"));
        availableAction.put("Modification", List.of("Execution"));
        availableAction.put("Reception", List.of("Finish"));
    }

    public List<String> getAvailableStatus(StatusDTO statusDTO) {
        return availableAction.get(statusDTO.getStatus());
    }

}

