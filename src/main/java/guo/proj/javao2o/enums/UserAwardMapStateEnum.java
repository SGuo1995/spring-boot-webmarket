package guo.proj.javao2o.enums;

public enum UserAwardMapStateEnum {
    SUCCESS(1, "Operation Success"), INNER_ERROR(-1001, "Operation Failed"), NULL_USERAWARD_ID(-1002,
            "UserAwardId is Null"), NULL_USERAWARD_INFO(-1003, "Null UserAward Info");

    private int state;

    private String stateInfo;

    private UserAwardMapStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static UserAwardMapStateEnum stateOf(int index) {
        for (UserAwardMapStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}

