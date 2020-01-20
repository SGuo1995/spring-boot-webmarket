package guo.proj.javao2o.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import guo.proj.javao2o.entity.Area;

import java.util.List;

public interface AreaService {
    public static final String AREALISTKEY = "arealist";

    /**
     * 获取区域列表，优先从缓存获取
     *
     * @return
     */
    List<Area> getAreaList() throws JsonProcessingException;


}