package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "urls")
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long url_id;
    @Column
    private String original_url;
    @Column
    private String shortened_url;

    public Long getUrl_id() {
        return url_id;
    }

    public void setUrl_id(Long url_id) {
        this.url_id = url_id;
    }

    public String getOriginal_url() {
        return original_url;
    }

    public void setOriginal_url(String original_url) {
        this.original_url = original_url;
    }

    public String getShortened_url() {
        return shortened_url;
    }

    public void setShortened_url(String shortened_url) {
        this.shortened_url = shortened_url;
    }
}
