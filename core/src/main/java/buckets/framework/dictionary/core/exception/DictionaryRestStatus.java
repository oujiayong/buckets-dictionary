package buckets.framework.dictionary.core.exception;

import buckets.framework.base.common.exception.IRestStatus;

/**
 * 字典服务特殊异常内容枚举类
 * @author buckets
 * @date 2020/11/24
 */
public enum DictionaryRestStatus implements IRestStatus {

    /**
     * 状态码及对应信息
     */

    PARENT_DICT_NOT_FOUND(40101, "父节点不存在，请检查参数后再试"),
    DICT_CODE_IS_EXIST(40102, "字典码[%s]已存在，请输入新的字典码");


    private int errorCode;
    private String errorMsg;
    DictionaryRestStatus(int errorCode, String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public int errorCode() {
        return errorCode;
    }
    @Override
    public String errorMsg() {
        return errorMsg;
    }

    public DictionaryRestStatus format(Object... args){
        this.errorMsg = String.format(this.errorMsg,args);
        return this;
    }
}
