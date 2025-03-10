package com.bank.alert.template.application.service;

import com.bank.alert.template.application.input.port.TemplateInputPort;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
public class TemplateServiceImpl implements TemplateInputPort {
    private final TemplateEngine templateEngine;

    @Override
    public String processTemplate(String templateName, Map<String, Object> variables) {
        Context context = new Context();
        context.setVariables(variables);
        return templateEngine.process(templateName, context);
    }
}
