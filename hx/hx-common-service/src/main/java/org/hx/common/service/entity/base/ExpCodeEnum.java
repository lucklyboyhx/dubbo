package org.hx.common.service.entity.base;

import java.io.Serializable;

/**
 * @Author 大闲人柴毛毛
 * @Date 2017/10/27 下午10:37
 * 全局的异常状态码 和 异常描述
 *
 * PS:异常码一共由5位组成，前两位为固定前缀，请参考{@link com.gaoxi.utils.ExpPrefixUtil}
 */
public enum ExpCodeEnum implements Serializable {

    /** 通用异常 */
    UNKNOW_ERROR(ExpPrefixUtil.ComExpPrefix + "000", "未知异常"),
    ERROR_404(ExpPrefixUtil.ComExpPrefix + "001", "没有该接口"),
    PARAM_NULL(ExpPrefixUtil.ComExpPrefix + "002", "参数为空"),
    NO_REPEAT(ExpPrefixUtil.ComExpPrefix + "003", "请勿重复提交"),
    SESSION_NULL(ExpPrefixUtil.ComExpPrefix + "004", "请求头中SessionId不存在"),
    HTTP_REQ_METHOD_ERROR(ExpPrefixUtil.ComExpPrefix + "005", "HTTP请求方法不正确"),
    JSONERROR(ExpPrefixUtil.ComExpPrefix + "006", "JSON解析异常"),

    /** Analysis模块异常 */
    XXXX_NULL(ExpPrefixUtil.AnlsExpPrefix + "000", "XXXX异常");

    private String code;
    private String message;

    private ExpCodeEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    ExpCodeEnum(){}

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
