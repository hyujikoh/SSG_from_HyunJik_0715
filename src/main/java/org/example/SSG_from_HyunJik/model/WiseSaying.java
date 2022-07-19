package org.example.SSG_from_HyunJik.model;

public class WiseSaying {
    public int id;
    public String content;
    public String author;

    public WiseSaying(int id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }
    @Override
    public String toString() {
        return "WiseSaying{" +
                "id=" + id +
                ", content=" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}