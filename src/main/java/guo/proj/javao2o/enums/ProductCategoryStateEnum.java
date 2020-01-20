package guo.proj.javao2o.enums;

public enum ProductCategoryStateEnum {
    SUCCESS(1, "Create Successfully"), INNER_ERROR(-1001, "Operation Failed"), EMPTY_LIST(-1002, "The amount of added categories is less than 1");

    private int state;

    private String stateInfo;

    private ProductCategoryStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static ProductCategoryStateEnum stateOf(int index) {
        for (ProductCategoryStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}