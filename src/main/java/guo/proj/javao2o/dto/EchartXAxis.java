package guo.proj.javao2o.dto;

import java.util.HashSet;

public class EchartXAxis {
    private String type = "category";
    //为了去重
    private HashSet<String> data;

    public HashSet<String> getData() {
        return data;
    }

    public void setData(HashSet<String> data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

}
