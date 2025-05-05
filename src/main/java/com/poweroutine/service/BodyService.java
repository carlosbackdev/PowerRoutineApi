package com.poweroutine.service;

import com.poweroutine.dtd.BodyDTD;
import com.poweroutine.model.BodyModel;
import com.poweroutine.repository.BodyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BodyService {
    @Autowired
    private BodyRepository bodyRepository;

    public BodyModel getBodyForId(Integer id) {
        Optional<BodyModel> body = bodyRepository.findById(id);
        if (body.isPresent()) {
            return body.get();
        } else {
            return null;
        }
    }

}
