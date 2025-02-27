package com.bank.finance.notification.application.input.port;

import com.bank.finance.movement.domain.model.MovementDomain;

public interface NotificationInputPort {
    void send(MovementDomain movement);
}
