package buckets.framework.dictionary.core.controller;

import buckets.framework.base.common.web.BaseRestController;
import buckets.framework.dictionary.core.service.DictionaryService;
import buckets.framework.dictionary.core.vo.DictionaryCuVo;
import buckets.framework.dictionary.entity.Dictionary;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author buckets
 * @date 2020/11/24
 */
@Api(tags = "字典管理")
@RestController
@RequestMapping("/dictionary")
public class DictionaryRestController extends BaseRestController {

    @Autowired
    DictionaryService dictionaryService;

    @ApiOperation(value = "查询详情", notes = "")
    @GetMapping("/get/{id}")
    public Dictionary get(@PathVariable("id") Integer id) {
        return dictionaryService.get(id);
    }

    @ApiOperation(value = "添加", notes = "")
    @PostMapping("/add")
    public Dictionary add(@RequestBody DictionaryCuVo dictionaryCuVo) {
        Dictionary dictionary = new Dictionary();
        BeanUtils.copyProperties(dictionaryCuVo, dictionary);
        return dictionaryService.add(dictionary);
    }

    @ApiOperation(value = "修改", notes = "")
    @PostMapping("/update/{id}")
    public Dictionary update(@PathVariable("id") Integer id, @RequestBody DictionaryCuVo dictionaryCuVo) {
        Dictionary dictionary = new Dictionary();
        BeanUtils.copyProperties(dictionaryCuVo, dictionary);
        dictionary.setId(id);
        return dictionaryService.update(dictionary);
    }

    @ApiOperation(value = "删除", notes = "")
    @PostMapping("/del")
    public int del(@RequestBody Integer[] ids) {
        return dictionaryService.del(ids);
    }

}
