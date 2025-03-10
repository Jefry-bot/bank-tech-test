package com.bank.alert.mail.domain.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "init")
public class MailDomain {
    private String to;
    private String subject;
    private String content;
    private Boolean isHtml;
}
