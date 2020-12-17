package buckets.framework.dictionary.core.dao;

import buckets.framework.dictionary.entity.Dictionary;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author buckets
 * @date 2020/11/23
 */

public interface DictionaryDao extends Mapper<Dictionary> {

    /**
     * 统计字典码code的数量
     * @param code 字典码
     * @return 统计数量
     */
    int countByCode(String code);

    /**
     * 统计字典码code的数量
     * @param code 字典码
     * @return 统计数量
     */
    Dictionary findByCode(String code);
}
