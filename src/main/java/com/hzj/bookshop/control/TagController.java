package com.hzj.bookshop.control;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hzj.bookshop.bean.Tag;
import com.hzj.bookshop.service.TagService;
import com.hzj.bookshop.utlis.Jsonutils;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    /**
     * 添加标签
     * @param tagJson
     */
    @PostMapping("/addTag")
    public void add(@RequestBody String tagJson) {
        tagService.addTag(tagJson);
    }

    /**
     * 删除标签
     * @param tagId
     */
    @PostMapping("/deleteTag")
    public void deleteTag(@RequestParam("tag_id") Integer tagId) {
        tagService.deleteTag(tagId);
    }

    /**
     * 查找标签， 通过标签名
     * @param tagValue
     */
    @GetMapping("/findTagByTagValue")
    public List<Tag> findTagByTagValue(@RequestParam("tag_value") String tagValue) {
        List<Tag> tagList = tagService.findTagByTagValue(tagValue);
        System.out.println(tagValue);
        return tagList;
    }

    /**
     * 查找标签， 通过标签类别
     * @param type
     * @return
     */
    @GetMapping("/findTagByType")
    public List<Tag> findTagByType(@RequestParam("type") String type) {
        List<Tag> tagList = tagService.findTagByType(type);
        return tagList;
    }


    /**
     * 更新标签
     * @param tag
     */
    @PostMapping("/updateTag")
    public void updateTag(@RequestBody Tag tag) {
        tagService.updateTag(tag);
    }


    @PostMapping("/test")
    public void testPost(@RequestParam("tag_id") String tag_id, @RequestParam("type") String type) {
        System.out.println(tag_id);
        System.out.println(type);
    }
}
