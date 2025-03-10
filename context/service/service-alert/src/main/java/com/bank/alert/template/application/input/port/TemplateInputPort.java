package com.bank.alert.template.application.input.port;

import java.util.Map;

public interface TemplateInputPort {
    String processTemplate(String templateName, Map<String, Object> variables);
}
