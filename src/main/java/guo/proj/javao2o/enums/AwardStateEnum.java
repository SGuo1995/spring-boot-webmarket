package guo.proj.javao2o.enums;

public enum AwardStateEnum {
    OFFLINE(-1, "Illegal rewards"), SUCCESS(0, "Operation success"), INNER_ERROR(-1001, "Opeartion failed"), EMPTY(
            -1002, "Null rewards info");

    private int state;

    private String stateInfo;

    private AwardStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static AwardStateEnum stateOf(int index) {
        for (AwardStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }

}

