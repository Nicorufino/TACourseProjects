package com.solvd.newsPortal.dom;

import com.solvd.newsPortal.models.article.Article;
import com.solvd.newsPortal.models.article.Category;
import com.solvd.newsPortal.models.user.Suscription_level;
import com.solvd.newsPortal.models.user.User;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Deserializer {
    private final static Logger LOGGER = Logger.getLogger(Deserializer.class);
    
    

    public static ArrayList<Article> deserialize(File file) throws ParserConfigurationException, IOException, SAXException, ParseException {
        NodeList list = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file).getElementsByTagName("article");
        ArrayList<Article> articles = new ArrayList<Article>();
        


        for (int i = 0; i < list.getLength(); i++) {
            Article deserialized = new Article();
            Node node = list.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                deserialized.setId(Long.valueOf(element.getAttribute("id")));

                deserialized.setName((element.getElementsByTagName("name").item(0).getTextContent()));

                java.util.Date date = new SimpleDateFormat("dd-MM-yyyy").parse(element.getElementsByTagName("date").item(0).getTextContent());
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(date);
                deserialized.setDate(Date.valueOf(LocalDate.ofInstant(calendar.getTime().toInstant(), ZoneId.systemDefault())));

                deserialized.setBody(element.getElementsByTagName("body").item(0).getTextContent());


                NodeList slList = element.getElementsByTagName("suscriptionLevel");
                String name = element.getElementsByTagName("name").item(1).getTextContent();
                Float cost = Float.valueOf(element.getElementsByTagName("cost").item(0).getTextContent());
                Long id = Long.valueOf(slList.item(0).getAttributes().getNamedItem("id").getTextContent());
                deserialized.setSuscription_levelRequired(new Suscription_level(id, name, cost));

                NodeList catList = element.getElementsByTagName("category");
                String catName = element.getElementsByTagName("name").item(2).getTextContent();
                Long catId = Long.valueOf(catList.item(0).getAttributes().getNamedItem("id").getTextContent());
                deserialized.setCategory(new Category(catId, catName));

                NodeList autList = element.getElementsByTagName("author");
                String autName = element.getElementsByTagName("firstname").item(0).getTextContent();
                String autLName = element.getElementsByTagName("lastname").item(0).getTextContent();
                Long autId = Long.valueOf(autList.item(0).getAttributes().getNamedItem("id").getTextContent());
                Integer autAge = Integer.valueOf(autList.item(0).getAttributes().getNamedItem("age").getTextContent());

                Suscription_level autSL = new Suscription_level();
                autSL.setId(Long.valueOf(slList.item(1).getAttributes().getNamedItem("id").getTextContent()));
                autSL.setName(element.getElementsByTagName("name").item(3).getTextContent());
                autSL.setCost(Float.parseFloat(element.getElementsByTagName("cost").item(1).getTextContent()));
                deserialized.setAuthor(new User(autId, autName, autLName, autAge, autSL));

            }
            articles.add(deserialized);
        }
        return articles;
    }
}
