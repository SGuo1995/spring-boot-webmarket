package guo.proj.javao2o.enums;

public enum ShopStateEnum {
    CHECK(0, "in review"), OFFLINE(-1, "illegal"), SUCCESS(1, "success"),
    PASS(2, "Pass certification"), INNER_ERROR(-1001, "System Inner Error"),
    NULL_SHOPID(-1002, "Null shopId"), NULL_SHOP(-1003, "Shop is Null");
    private int state;
    private String stateInfo;

    private ShopStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;

    }

    /**
     * 依据传入的state返回相应的enum值
     */
    public static ShopStateEnum stateOf(int state) {
        for (ShopStateEnum stateEnum : values()) {
            if (stateEnum.getState() == state) {
                return stateEnum;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }


    public String getStateInfo() {
        return stateInfo;
    }

}
