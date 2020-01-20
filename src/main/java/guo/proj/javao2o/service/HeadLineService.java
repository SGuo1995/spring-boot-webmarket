package guo.proj.javao2o.service;

import guo.proj.javao2o.entity.HeadLine;

import java.io.IOException;
import java.util.List;

public interface HeadLineService {
    public static final String HLLISTKEY = "headlinelist";
    List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IOException;

}
