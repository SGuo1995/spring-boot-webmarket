package guo.proj.javao2o.service;

import guo.proj.javao2o.dto.UserProductMapExecution;
import guo.proj.javao2o.entity.UserProductMap;


public interface UserProductMapService {

    public UserProductMapExecution listUserProductMap(UserProductMap userProductMapCondition, Integer pageIndex, Integer pageSize);


    UserProductMapExecution addUserProductMap(UserProductMap userProductMap);
}
