package com.project.bookstoreapi.util;

import com.project.bookstoreapi.exception.BookStoreException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class CommonUtil {

    public static final String dd_MM_yyyy = "dd-MM-yyyy";
    public static Timestamp getTimeStamp() {
        final Date date = new Date();
        long time = date.getTime();
        return (new Timestamp(time));
    }

    public static Date toDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(dd_MM_yyyy);
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            throw new BookStoreException(HttpStatus.INTERNAL_SERVER_ERROR, "date", "The date should be in dd-MM-yyyy format",
                    e);
        }
    }

    public static String fromDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(dd_MM_yyyy);
        return dateFormat.format(date);
    }

}
