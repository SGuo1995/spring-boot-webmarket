package guo.proj.javao2o.exceptions;

public class WechatAuthOperationException extends RuntimeException {


    private static final long serialVersionUID = 6041594838463339992L;

    public WechatAuthOperationException(String msg) {
        super(msg);
    }
}