package jpa.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "Website")
public class WebSite {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Url url;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "LinksWebsite", joinColumns = @JoinColumn(name = "url_id"), inverseJoinColumns = @JoinColumn(name = "website_id"))
    private List<Url> links = Collections.emptyList();

    public WebSite(){}
    public WebSite(String url) {
        this.url = new Url(url);
    }

    public String getUrl(){ return this.url == null ? null : this.url.getUrl(); }
    public void addLink(String link) {
        if (links.isEmpty()) { links = new ArrayList<>(); }
        links.add(new Url(link));
    }
    public List<String> getLinks() { return links.stream().map(Url::getUrl).collect(Collectors.toList()); }
    public List<Url> getLinksEntity() { return links; }
}
