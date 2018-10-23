package project.entity;

import java.io.Serializable;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/10 17:09
 * @Description:
 */
public class ResultPojo implements Serializable {

    private int code;

    private Object data;

    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
