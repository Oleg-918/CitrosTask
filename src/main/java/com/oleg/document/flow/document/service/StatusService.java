package com.oleg.document.flow.document.service;

import com.oleg.document.flow.document.dto.StatusDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class StatusService {
    private Map<String, Set<String>> availableAction = new HashMap<>();

    @PostConstruct
    public void init() {
        availableAction.put("Start", Set.of("Preparation"));
        availableAction.put("Preparation", Set.of("Execution"));
        availableAction.put("Execution", Set.of("Control"));
        availableAction.put("Control", Set.of("Reception", "Modification"));
        availableAction.put("Modification", Set.of("Execution"));
        availableAction.put("Reception", Set.of("Finish"));
    }

    public Set<String> getAvailableStatus(String status) {
        return availableAction.get(status);
    }

}

