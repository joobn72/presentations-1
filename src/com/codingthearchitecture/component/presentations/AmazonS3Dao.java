package com.codingthearchitecture.component.presentations;

import com.codingthearchitecture.domain.Country;
import com.codingthearchitecture.domain.Presentation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

class AmazonS3Dao extends Dao {

    private static final String DATE_FORMAT = "dd-MMM-yyyy";

    private String baseUrl;

    AmazonS3Dao(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public List<Presentation> loadPresentations() throws Exception {
        Set<String> presentationIds = new HashSet<>();
        URL url = new URL(baseUrl + "_presentations.txt");
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String presentationId;
            while ((presentationId = in.readLine()) != null) {
                presentationIds.add(presentationId);
            }
        }

        return presentationIds.parallelStream()
                .map(this::loadPresentationFromPropertiesFile)
                .collect(Collectors.toList());
    }

    private Presentation loadPresentationFromPropertiesFile(String presentation) {
        try {
            URL url = new URL(baseUrl + presentation + ".properties");
            System.out.println("Loading " + url.toExternalForm());
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            Properties props = new Properties();
            props.load(in);
            in.close();

            Presentation p = new Presentation(presentation);
            p.setTitle(props.getProperty("title"));
            p.setSummary(props.getProperty("summary"));
            p.setAuthor(props.getProperty("author"));
            p.setEvent(props.getProperty("event"));
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            if (props.getProperty("date") != null && props.getProperty("date").length() > 0) {
                p.setDate(sdf.parse(props.getProperty("date")));
            }
            p.setCity(props.getProperty("city"));
            p.setCountry(new Country(props.getProperty("country")));
            p.setBase(baseUrl + presentation);
            p.setNumberOfSlides(Integer.parseInt(props.getProperty("slides")));

            String pdf = props.getProperty("pdf");
            if (Boolean.parseBoolean(pdf)) {
                p.setPdf(baseUrl + presentation + ".pdf");
            }

            p.setVideo(props.getProperty("video"));

            return p;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
