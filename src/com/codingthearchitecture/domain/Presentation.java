package com.codingthearchitecture.domain;

import com.codingthearchitecture.util.StringUtils;

import java.util.Date;

public class Presentation {

    private String id;
    private String title;
    private String summary;
    private String author;

    private String base;

    private String event;
    private String city;
    private Country country;
    private Date date;

    private String pdf;
    private String video;

    private int numberOfSlides;

    public Presentation(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTruncatedSummary() {
        return StringUtils.filterHtmlAndTruncate(getSummary());
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
        if (!this.base.endsWith("/")) {
            this.base = this.base + "/";
        }
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public boolean hasPdf() {
        return this.pdf != null && this.pdf.length() > 0;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public boolean hasVideo() {
        return this.video != null && this.video.length() > 0;
    }

    public String getPermalink() {
        return "http://www.codingthearchitecture.com/presentations/" + this.id;
    }

    public int getNumberOfSlides() {
        return numberOfSlides;
    }

    public void setNumberOfSlides(int numberOfSlides) {
        this.numberOfSlides = numberOfSlides;
    }

}
