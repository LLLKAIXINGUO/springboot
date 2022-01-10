package com.dcq.common;





//description : "接口返回对象"
public class R<T> {
    //"返回码，0：成功"
    private int code;
    //"返回信息
    private String msg;
    //"返回数据对象"
    private T data;

    private R(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> R<T> success() {
        return new R(0, "success", (Object)null);
    }

    public static <T> R<T> success(T data) {
        return new R(0, "success", data);
    }

    public static <T> R<T> success(String msg) {
        return new R(0, msg, (Object)null);
    }

    public static <T> R<T> success(String msg, T data) {
        return new R(0, msg, data);
    }

    public static <T> R<T> error() {
        return new R(-1, "internal error", (Object)null);
    }

    public static <T> R<T> error(int status) {
        return new R(status, "internal error", (Object)null);
    }

    public static <T> R<T> error(String msg) {
        return new R(-1, msg, (Object)null);
    }

    public static <T> R<T> error(int code, String msg) {
        return new R(code, msg, (Object)null);
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getData() {
        return this.data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof R)) {
            return false;
        } else {
            R<?> other = (R)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                Object this$msg = this.getMsg();
                Object other$msg = other.getMsg();
                if (this$msg == null) {
                    if (other$msg != null) {
                        return false;
                    }
                } else if (!this$msg.equals(other$msg)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof R;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getCode();
        Object $msg = this.getMsg();
        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "R(code=" + this.getCode() + ", msg=" + this.getMsg() + ", data=" + this.getData() + ")";
    }
}
