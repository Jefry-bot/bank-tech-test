package com.bank.common.adapter.input.web.dto;

import com.bank.common.utilities.JsonUtility;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder(builderMethodName = "init")
public class ExceptionBody {

    private String date;
    private String line;
    private String clazz;
    private String method;
    private String message;
    private String endpoint;
    private String exceptionName;
    private String messageDetail;
    @Setter
    private Object additionalInformation;

    @Override
    public String toString() {
        return JsonUtility.toStringFormat(this);
    }
}
