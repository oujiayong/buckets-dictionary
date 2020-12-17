package buckets.framework.dictionary.core.service.impl;

import buckets.framework.base.common.exception.RestException;
import buckets.framework.base.common.service.impl.BaseServiceImpl;
import buckets.framework.dictionary.core.dao.DictionaryDao;
import buckets.framework.dictionary.core.exception.DictionaryRestStatus;
import buckets.framework.dictionary.core.service.DictionaryService;
import buckets.framework.dictionary.entity.Dictionary;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author buckets
 * @date 2020/11/24
 */
@Service
public class DictionaryServiceImpl extends BaseServiceImpl<DictionaryDao, Dictionary, Integer> implements DictionaryService {

    @Override
    public Dictionary add(Dictionary dictionary) {
        Dictionary parentDict = check(dictionary);
        dictionary.setHierarchy(parentDict.getHierarchy() + 1);
        return super.add(dictionary);
    }

    @Override
    public Dictionary update(Dictionary dictionary) {
        Dictionary parentDict = check(dictionary);
        dictionary.setHierarchy(parentDict.getHierarchy() + 1);
        return super.update(dictionary);
    }


    private Dictionary check(Dictionary dictionary) {
        //验证父节点的真实性
        Dictionary parentDict = dao.selectByPrimaryKey(dictionary.getParentId());
        if (parentDict == null) {
            throw new RestException(DictionaryRestStatus.PARENT_DICT_NOT_FOUND);
        }

        //id不为空时，是修改字典信息，若code获取的数据库数据id相同，则直接返回父节点对象
        if (dictionary.getId() != null && dictionary.getId() > 0) {
            Dictionary dict = dao.findByCode(dictionary.getCode());
            if (dict != null && dictionary.getId().intValue() == dict.getId().intValue()) {
                return parentDict;
            }
        }

        //验证code是否重复，当前有两种情况，1、新增字典；2、修改字典但code对应数据库数据id与修改的id不对应
        int count = dao.countByCode(dictionary.getCode());
        if (count > 0) {
            throw new RestException(DictionaryRestStatus.DICT_CODE_IS_EXIST.format(dictionary.getCode()));
        }
        return parentDict;
    }
}
