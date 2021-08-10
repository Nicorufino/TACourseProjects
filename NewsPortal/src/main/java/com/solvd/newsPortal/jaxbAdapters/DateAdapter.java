package com.solvd.newsPortal.jaxbAdapters;

import org.apache.log4j.Logger;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DateAdapter extends XmlAdapter<String, LocalDate> {
private final static Logger LOGGER = Logger.getLogger(DateAdapter.class);

    @Override
    public LocalDate unmarshal(String s) throws Exception {
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(s);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return LocalDate.ofInstant(calendar.getTime().toInstant(), ZoneId.systemDefault());
    }

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(localDate.toString()));
        return new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime());
    }
}


