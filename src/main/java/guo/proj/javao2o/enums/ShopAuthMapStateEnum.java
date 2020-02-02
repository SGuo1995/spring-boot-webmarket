package guo.proj.javao2o.enums;

public enum ShopAuthMapStateEnum {
    SUCCESS(1, "Operation success"), INNER_ERROR(-1001, "Operation fail"), NULL_SHOPAUTH_ID(-1002,
            "ShopAuthId is null"), NULL_SHOPAUTH_INFO(-1003, "Null information");

    private int state;

    private String stateInfo;

    private ShopAuthMapStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static ShopAuthMapStateEnum stateOf(int index) {
        for (ShopAuthMapStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}