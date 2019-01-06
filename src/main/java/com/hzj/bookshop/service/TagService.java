package com.hzj.bookshop.service;

import com.hzj.bookshop.bean.Tag;
import com.hzj.bookshop.mapper.TagMapper;
import com.hzj.bookshop.utlis.Jsonutils;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagMapper tagMapper;

    /**
     * 添加标签
     * @param tagJson
     */
    public void addTag(String tagJson) {
        String tag_value = (String)Jsonutils.getValue(tagJson, "tag_value", "string");
        String type = (String) Jsonutils.getValue(tagJson, "type", "string");
        Tag tag = new Tag(tag_value, type);
        System.out.println(tag);
        tagMapper.addTag(tag);
    }

    /**
     * 删除标签
     * @param tagId
     */
    public void deleteTag(int tagId) {
        tagMapper.deleteTag(tagId);
    }

    /**
     * 查找标签内容, 通过标签内容查找
     * @param tagValue
     */
    public List<Tag> findTagByTagValue(String tagValue) {
        List<Tag> tagList = tagMapper.findTagByTagValue(tagValue);
        System.out.println(tagList);
        return tagList;
    }


    /**
     * 查找标签内容， 通过标签类型查找
     * @param type
     * @return
     */
    public List<Tag> findTagByType(String type) {
        List<Tag> tagList = tagMapper.findTagByType(type);
        return tagList;
    }

    public void updateTag(Tag tag) {
        tagMapper.updateTag(tag);
    }


}
