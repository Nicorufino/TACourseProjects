package com.solvd.newsPortal.main;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.newsPortal.dao.mySql.mybatis.ArticleDAO;
import com.solvd.newsPortal.dao.mySql.mybatis.CommentDAO;
import com.solvd.newsPortal.dao.mySql.mybatis.TagDAO;
import com.solvd.newsPortal.models.article.Article;
import com.solvd.newsPortal.models.article.Articles;
import com.solvd.newsPortal.models.article.Category;
import com.solvd.newsPortal.models.article.Location;
import com.solvd.newsPortal.models.comment.Comment;
import com.solvd.newsPortal.models.tag.Tag;
import com.solvd.newsPortal.models.user.Suscription_level;
import com.solvd.newsPortal.models.user.User;
import com.solvd.newsPortal.dom.Serializer;
import com.solvd.newsPortal.services.IArticleService;
import com.solvd.newsPortal.services.impl.ArticleService;
import com.solvd.newsPortal.services.impl.UserService;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import static com.solvd.newsPortal.dom.Deserializer.deserialize;

public class Runner {
    private final static Logger LOGGER = Logger.getLogger(Runner.class);

    public final static void main(String[] args) throws JAXBException, SAXException, ParserConfigurationException, IOException, ParseException {


/*

        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Schema schema = schemaFactory.newSchema(new File("src/main/resources/Articles.xsd"));


        JAXBContext jbc = JAXBContext.newInstance(Articles.class);
        Unmarshaller um = jbc.createUnmarshaller();
        um.setSchema(schema);
        Articles unmarshalledArticles = (Articles) um.unmarshal(new File("src/main/resources/Articles.xml"));
        // LOGGER.debug(unmarshalledArticles.getArticleList().get(2).toString());


        Article first = new Article(18L, "Marshalling with JaxB", LocalDate.of(2021, 8, 10), "body", new Suscription_level(7L, "test", 25F), new Category(70L, "test"), new User(255L, "Lorem", "Ipsum", 25, new Suscription_level(7L, "test", 9.99F)));
        Articles articlesToMarshall = new Articles();
        articlesToMarshall.getArticleList().add(first);


        Marshaller marshaller = jbc.createMarshaller();
        marshaller.setSchema(schema);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(articlesToMarshall, new File("src/main/resources/Marshalled.xml"));

        Articles articles = new Articles(deserialize(new File("src/main/resources/Articles.xml")));
        //articles.getArticleList().stream().forEach(article -> LOGGER.debug(article));

        Serializer serializer = new Serializer();
        try {
            serializer.serialize(first);
        } catch (TransformerConfigurationException e) {
            LOGGER.debug(e);
        } catch (TransformerException e) {
            LOGGER.debug(e);
        }

        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        Articles jsonArticles = objectMapper.readValue(new File("src/main/resources/Articles.json"), Articles.class);
        jsonArticles.getArticleList().stream().forEach(article -> LOGGER.debug(article));

        objectMapper.writeValue(new File("src/main/resources/Marshalled.json"), first);
        */
        ArticleService articleService = new ArticleService();
        LOGGER.debug(articleService.getArticleById(11L));

        UserService userService = new UserService();
        LOGGER.debug(userService.getUserById(2L));
    }
}

