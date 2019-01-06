package com.hzj.bookshop.mapper;

import com.hzj.bookshop.bean.Tag;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TagMapper {


    /**
     * 添加新的标签
     */
    public void addTag(Tag tag);

    /**
     * 删除标签
     * @param tagId
     */
    public void deleteTag(Integer tagId);

    /**
     * 通过标签内容查找
     * @param tagValue
     */
    public List<Tag> findTagByTagValue(String tagValue);

    /**
     * 通过标签类型查找
     * @param type
     * @return
     */
    public List<Tag> findTagByType(String type);

    /**
     * 更新标签
     * @param tag
     */
    public void updateTag(Tag tag);
}
