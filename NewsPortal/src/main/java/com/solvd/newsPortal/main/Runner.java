package com.solvd.newsPortal.main;

import com.mysql.cj.result.LocalDateTimeValueFactory;
import com.solvd.newsPortal.classes.article.Article;
import com.solvd.newsPortal.classes.article.Articles;
import com.solvd.newsPortal.classes.article.Category;
import com.solvd.newsPortal.classes.user.Suscription_level;
import com.solvd.newsPortal.classes.user.User;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.validation.ValidatorHandler;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.solvd.newsPortal.dom.Deserializer.deserialize;

public class Runner {
    private final static Logger LOGGER = Logger.getLogger(Runner.class);

    public final static void main(String[] args) throws JAXBException, SAXException, ParserConfigurationException, IOException, ParseException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Schema schema = schemaFactory.newSchema(new File("src/main/resources/Articles.xsd"));


        JAXBContext jbc = JAXBContext.newInstance(Articles.class);
        Unmarshaller um = jbc.createUnmarshaller();
        um.setSchema(schema);
        Articles unmarshalledArticles = (Articles) um.unmarshal(new File("src/main/resources/Articles.xml"));
        // LOGGER.debug(unmarshalledArticles.getArticleList().get(2).toString());


        Article first = new Article(18L, "Marshalling with JaxB", LocalDate.of(2021, 8, 10), "body", new Suscription_level(7L, "test", 9.99F), new Category(99L, "test"), new User(255L, "Lorem", "Ipsum", 25, new Suscription_level(7L, "test", 9.99F)));
        Articles articlesToMarshall = new Articles();
        articlesToMarshall.getArticleList().add(first);


        Marshaller marshaller = jbc.createMarshaller();
        marshaller.setSchema(schema);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(articlesToMarshall, new File("src/main/resources/Marshalled.xml"));

        Articles articles = new Articles(deserialize(new File("src/main/resources/Articles.xml")));
        articles.getArticleList().stream().forEach(article -> LOGGER.debug(article));

    }
}


    /*    Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM newsPortal.Categories where id = 1;")) {
            try {
                ResultSet rs = ps.executeQuery();
                rs.next();
                LOGGER.debug("name: " + rs.getString("name"));

            } catch (SQLException e) {
                LOGGER.error(e);
            }

        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        }

        UserService userService = new UserService();
        LOGGER.debug(userService.getUserById(2L).toString());
    }

    JAXBContext c;

    {
        try {
            c = JAXBContext.newInstance(Article.class);
        } catch (JAXBException e) {
            LOGGER.error(e);
        }
    }

    Unmarshaller um;

    {
        try {
            um = c.createUnmarshaller();
        } catch (JAXBException e) {
            LOGGER.error(e);
        }
    }

    Articles articles;

    {
        try {
            articles = (Articles) um.unmarshal(new File("Articles.xml"));
        } catch (JAXBException e) {
            LOGGER.error(e);
        }
    LOGGER.debug(articles.toString());
}
}
*/