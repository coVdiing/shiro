package com.vi.entity;

public class Role {
    private Long id;

    private String name;

    private String desc_;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc_() {
        return desc_;
    }

    public void setDesc_(String desc_) {
        this.desc_ = desc_;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", desc_='" + desc_ + '\'' +
                '}';
    }
}