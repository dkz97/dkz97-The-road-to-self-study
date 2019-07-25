package dkz97.exception;

/**
 * 自定义系统异常类
 */
public class SysExeception extends Exception{

    // 自定义一个异常信息，如果需要抛出这个异常的话，就需要使用构造方法，对异常信息进行赋值
    private String message;

    public SysExeception(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
