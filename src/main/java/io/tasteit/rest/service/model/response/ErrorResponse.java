package io.tasteit.rest.service.model.response;

public class ErrorResponse {

    private String errorType;
    private String errorCode;
    private String errorDesc;

    public ErrorResponse(){}

    public String getErrorType() {
        return errorType;
    }
    public String getErrorCode() {
        return errorCode;
    }
    public String getErrorDesc() {
        return errorDesc;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((errorCode == null) ? 0 : errorCode.hashCode());
        result = prime * result
                + ((errorDesc == null) ? 0 : errorDesc.hashCode());
        result = prime * result
                + ((errorType == null) ? 0 : errorType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ErrorResponse other = (ErrorResponse) obj;
        if (errorCode == null) {
            if (other.errorCode != null)
                return false;
        } else if (!errorCode.equals(other.errorCode))
            return false;
        if (errorDesc == null) {
            if (other.errorDesc != null)
                return false;
        } else if (!errorDesc.equals(other.errorDesc))
            return false;
        if (errorType == null) {
            if (other.errorType != null)
                return false;
        } else if (!errorType.equals(other.errorType))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ErrorResponse [errorType=" + errorType + ", errorCode="
                + errorCode + ", errorDesc=" + errorDesc + "]";
    }
}
