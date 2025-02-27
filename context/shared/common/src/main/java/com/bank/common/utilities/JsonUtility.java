package com.bank.common.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
import static lombok.AccessLevel.PRIVATE;

@Slf4j
@NoArgsConstructor(access = PRIVATE)
public class JsonUtility {

  public static <T> String toStringFormat(T object) {
    try {
      return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(object);
    } catch (JsonProcessingException exception) {
      log.error("An error occurred while trying to convert the object: { }", exception);
      return null;
    }
  }

  public static <T> String toString(T object) {
    try {
      return new ObjectMapper()
          .registerModule(new JavaTimeModule())
          .configure(WRITE_DATES_AS_TIMESTAMPS, false)
          .writeValueAsString(object);
    } catch (JsonProcessingException exception) {
      log.error("An error occurred while trying to convert the object: { }", exception);
      return null;
    }
  }

  public static Map<String, Object> toJson(String json) {
    try {
      return new ObjectMapper().readValue(json, new TypeReference<>() {});
    } catch (JsonProcessingException exception) {
      log.error("An error occurred while trying to convert the object: { }", exception);
      return null;
    }
  }
}
