package kiomnd2.batchsvrmanager.common.exception;

import kiomnd2.batchsvrmanager.common.response.ErrorCode;

public class InvalidParamException extends BaseException{

    public InvalidParamException(Object ... args) {
        super(ErrorCode.COMMON_REQUIRED_VALUE, args);
    }
}
