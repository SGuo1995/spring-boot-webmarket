package guo.proj.javao2o.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import guo.proj.javao2o.entity.Area;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class AreaServiceTest  {
    @Autowired
    private AreaService areaService;
    @Autowired
    private CacheService cacheService;

    @Test
    public void testGetAreaList() throws JsonProcessingException {
        List<Area> areaList=areaService.getAreaList();
        System.out.println(areaList.get(0).getAreaName());
        cacheService.removeFromCache(areaService.AREALISTKEY);
        areaList = areaService.getAreaList();
    }
}
