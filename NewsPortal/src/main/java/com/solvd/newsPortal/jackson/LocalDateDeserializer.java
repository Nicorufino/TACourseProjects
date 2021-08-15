package com.solvd.newsPortal.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class LocalDateDeserializer extends StdDeserializer<java.sql.Date> {
    private final static Logger LOGGER = Logger.getLogger(LocalDateDeserializer.class);
    public LocalDateDeserializer() {
            super(LocalDate.class);
    }


    @Override
    public java.sql.Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Date date = null;
        try {
            date = new SimpleDateFormat("dd-MM-yyyy").parse(jsonParser.readValueAs(String.class));
        } catch (ParseException e) {
            LOGGER.error(e);
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return java.sql.Date.valueOf(LocalDate.ofInstant(calendar.getTime().toInstant(), ZoneId.systemDefault()));

    }
}
