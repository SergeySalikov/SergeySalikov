package ru.job4j.models;

public class Item {
    private String id;
    private String name;
    private String desc;
    private long created;
    private String[] comments;

    public Item() {
    }

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return this.desc;
    }
}