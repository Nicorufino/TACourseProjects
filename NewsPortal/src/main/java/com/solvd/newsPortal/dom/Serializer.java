package com.solvd.newsPortal.dom;

import com.solvd.newsPortal.classes.article.Article;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Serializer {
    public void serialize(Article article) throws ParserConfigurationException, TransformerException {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();


        Element root = document.createElement("Article");
        document.appendChild(root);

        root.setAttribute("id", String.valueOf(article.getId()));
        Element name = document.createElement("name");
        name.appendChild(document.createTextNode(article.getName()));
        root.appendChild(name);

        Element date = document.createElement("date");
        date.appendChild(document.createTextNode(String.valueOf(article.getDate())));
        root.appendChild(date);

        Element body = document.createElement("body");
        body.appendChild(document.createTextNode(article.getBody()));
        root.appendChild(body);


        // complex types
        Element suscriptionLevel = document.createElement("suscriptionLevel");
        root.appendChild(suscriptionLevel);
        suscriptionLevel.setAttribute("id", String.valueOf(article.getSuscription_level().getId()));

        Element slName = document.createElement("name");
        slName.appendChild(document.createTextNode(article.getSuscription_level().getName()));
        suscriptionLevel.appendChild(slName);

        Element cost = document.createElement("cost");
        cost.appendChild(document.createTextNode(String.valueOf(article.getSuscription_level().getCost())));
        suscriptionLevel.appendChild(cost);


        Element category = document.createElement("category");
        root.appendChild(category);
        category.setAttribute("id", String.valueOf(article.getCategory().getId()));

        Element catName = document.createElement("name");
        catName.appendChild(document.createTextNode(article.getCategory().getName()));
        category.appendChild(catName);


        Element author = document.createElement("author");
        root.appendChild(author);
        author.setAttribute("id", String.valueOf(article.getAuthor().getId()));
        author.setAttribute("age", String.valueOf(article.getAuthor().getAge()));


        Element firstName = document.createElement("firstname");
        firstName.appendChild(document.createTextNode(article.getAuthor().getName()));
        author.appendChild(firstName);

        Element lastname = document.createElement("lastname");
        lastname.appendChild(document.createTextNode(article.getAuthor().getLast_name()));
        author.appendChild(lastname);

        Element autSL = document.createElement("suscriptionLevel");
        author.appendChild(autSL);
        autSL.setAttribute("id", String.valueOf(article.getAuthor().getSuscription_level().getId()));

        Element autSlName = document.createElement("name");
        autSlName.appendChild(document.createTextNode(article.getAuthor().getName()));
        autSL.appendChild(autSlName);

        Element autSlCost = document.createElement("cost");
        autSlCost.appendChild(document.createTextNode(String.valueOf(article.getAuthor().getSuscription_level().getCost())));
        autSL.appendChild(autSlCost);


        // create the xml file
        //transform the DOM Object to an XML File
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File("src/main/resources/Serialized.xml"));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");


        transformer.transform(domSource, streamResult);
    }
}
