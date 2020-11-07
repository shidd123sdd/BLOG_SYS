package cn.siwuya.blogsys.common;

/**
 * @author shi_dd
 * @date 2020/7/11 0:23
 */
public class ServiceException extends RuntimeException{
    private static final long serialVersionUID = -2850276659806418376L;
    public ServiceException() {
        super();
    }
    public ServiceException(String message) {
        super(message);
    }
    public ServiceException(Throwable cause) {
        super(cause);
    }
}
