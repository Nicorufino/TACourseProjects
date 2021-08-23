package com.solvd.newsPortal.models.article;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "articles")
@XmlAccessorType(XmlAccessType.FIELD)
public class Articles {
    @XmlElement(name = "article")
    private List<Article> articleList;

    public Articles() {
        this.articleList = new ArrayList<Article>();
    }


    public Articles(ArrayList<Article> articleList) {
        this.articleList = articleList;
    }
    @JsonProperty("article")
    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "articleList=" + articleList +
                '}';
    }
}
