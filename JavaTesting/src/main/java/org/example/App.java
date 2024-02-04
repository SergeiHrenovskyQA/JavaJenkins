package org.example;


import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        String date1 = "1683291621";
        String date2 = "2023-05-05T15:00:56.789Z";
        LocalDateTime r1 = parseDate(date1);
        LocalDateTime r2 = parseDate(date2);

        int a = 4;
    }

    public static LocalDateTime parseDate(String dateString) {
        if(!dateString.contains("-")) {
            long unixTimestamp = Long.parseLong(dateString);
            Instant instant = Instant.ofEpochSecond(unixTimestamp);
            return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
            Instant instant = Instant.from(formatter.parse(dateString));
            return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        }
        }
}
