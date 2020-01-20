package guo.proj.javao2o.enums;

public enum LocalAuthStateEnum {
    LOGINFAIL(-1, "Incorrect username or password"), SUCCESS(0, "Success"), NULL_AUTH_INFO(-1006,
            "User not found"), ONLY_ONE_ACCOUNT(-1007, "Only one account can be bind");

    private int state;

    private String stateInfo;

    private LocalAuthStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static LocalAuthStateEnum stateOf(int index) {
        for (LocalAuthStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }

}
