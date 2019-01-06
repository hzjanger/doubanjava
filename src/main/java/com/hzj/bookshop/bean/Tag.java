package com.hzj.bookshop.bean;

/**
 * 标签实体类
 */
public class Tag {
    /**
     * 标签主键
     */
    private Integer tag_id;
    /**
     * 标签内容
     */
    private String tag_value;

    /**
     * 标签所属类别
     */
    private String type;

    public Tag() {
    }

    public Tag(String tag_value, String type) {
        this.tag_value = tag_value;
        this.type = type;
    }

    public Tag(Integer tag_id, String tag_value, String type) {
        this.tag_id = tag_id;
        this.tag_value = tag_value;
        this.type = type;
    }



    public Integer getTag_id() {
        return tag_id;
    }

    public void setTag_id(Integer tag_id) {
        this.tag_id = tag_id;
    }

    public String getTag_value() {
        return tag_value;
    }

    public void setTag_value(String tag_value) {
        this.tag_value = tag_value;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tag_id=" + tag_id +
                ", tag_value='" + tag_value + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
