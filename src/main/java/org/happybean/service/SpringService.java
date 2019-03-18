package org.happybean.service;

import org.happybean.repository.SpringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wgt
 * @date 2019-03-14
 * @description
 **/
@Service
public class SpringService {

    @Autowired
    private SpringRepository springRepository;
}
