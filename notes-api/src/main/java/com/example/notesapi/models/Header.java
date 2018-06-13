package com.example.notesapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity @Table(name = "HEADERS")
public class Header {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TEXT")
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="title_id")
    @JsonIgnoreProperties("headers")
    public Title title;

    @OneToMany(mappedBy="header", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("header")
    public List<Para> paras = new ArrayList<>();

    @OneToMany(mappedBy="header", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("header")
    public List<Codeblock> codeblocks = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public List<Para> getParas() {
        return paras;
    }

    public void setParas(List<Para> paras) {
        this.paras = paras;
    }

    public List<Codeblock> getCodeblocks() {
        return codeblocks;
    }

    public void setCodeblocks(List<Codeblock> codeblocks) {
        this.codeblocks = codeblocks;
    }
}
