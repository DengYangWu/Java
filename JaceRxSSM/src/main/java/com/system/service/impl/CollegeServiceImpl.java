package com.system.service.impl;

import java.util.List;

import com.system.mapper.CollegeMapper;
import com.system.po.College;
import com.system.po.CollegeExample;
import org.springframework.beans.factory.annotation.Autowired;

import com.system.service.CollegeService;
import org.springframework.stereotype.Service;

@Service
public class CollegeServiceImpl implements CollegeService{
	@Autowired
    private CollegeMapper collegeMapper;

    public List<College> finAll() throws Exception {
        CollegeExample collegeExample = new CollegeExample();
        CollegeExample.Criteria criteria = collegeExample.createCriteria();

        criteria.andCollegeidIsNotNull();


        return collegeMapper.selectByExample(collegeExample);
    }
}
