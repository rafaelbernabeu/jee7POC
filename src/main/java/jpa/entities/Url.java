package jpa.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "Url")
public class Url {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "url", length = 1000)
    private String url;

    public Url(){}
    public Url(String url) {
        if (url.startsWith("www")) {
            this.url = "http://".concat(url);
        } else { this.url = url; }
    }
}
