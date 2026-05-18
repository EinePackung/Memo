package com.yeseok.memo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    protected Memo() {
    }

    public Memo (String content) {
        this.content = content;
    }


    public Long getId(){
        return id;
    }

    public String getContent(){
        return content;
    }


    public void setId(Long setId) {
        this.id = setId;
    }

    public void setContent(String setContent) {
        this.content = setContent;
    }


}
