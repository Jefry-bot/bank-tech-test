package com.bank.finance.notification.application.service;

import com.bank.common.utilities.JsonUtility;
import com.bank.finance.movement.domain.model.MovementDomain;
import com.bank.finance.notification.application.input.port.NotificationInputPort;
import com.bank.finance.notification.application.output.port.NotificationOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationInputPort {
    private final NotificationOutputPort outputPort;

    @Override
    public void send(MovementDomain movement) {
        this.outputPort.send(JsonUtility.toString(movement));
    }
}
