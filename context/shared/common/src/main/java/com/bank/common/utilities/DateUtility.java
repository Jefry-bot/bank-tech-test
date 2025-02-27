package com.bank.common.utilities;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class DateUtility {

    public static LocalDateTime now(String zone) {
        return LocalDateTime.now(ZoneId.of(zone));
    }
}