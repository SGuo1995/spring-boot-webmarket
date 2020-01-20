package guo.proj.javao2o.dao;

import guo.proj.javao2o.entity.Area;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea(){
        List<Area>  areaList=areaDao.queryArea();
        System.out.println(areaList.get(0).getAreaName());
    }
}
