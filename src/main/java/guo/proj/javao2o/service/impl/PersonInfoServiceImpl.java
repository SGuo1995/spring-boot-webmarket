package guo.proj.javao2o.service.impl;

import guo.proj.javao2o.dao.PersonInfoDao;
import guo.proj.javao2o.entity.PersonInfo;
import guo.proj.javao2o.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {
    @Autowired
    private PersonInfoDao personInfoDao;

    @Override
    public PersonInfo getPersonInfoById(Long userId) {
        return personInfoDao.queryPersonInfoById(userId);
    }
}
