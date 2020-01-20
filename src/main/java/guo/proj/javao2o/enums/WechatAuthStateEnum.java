package guo.proj.javao2o.enums;

public enum WechatAuthStateEnum {
    LOGINFAIL(-1, "Wrong openId"), SUCCESS(0, "Success"), NULL_AUTH_INFO(-1006, "Null auth info");

    private int state;

    private String stateInfo;

    private WechatAuthStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static WechatAuthStateEnum stateOf(int index) {
        for (WechatAuthStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }

}
