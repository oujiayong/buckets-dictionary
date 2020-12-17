package buckets.framework.dictionary.core.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author buckets
 * @date 2020/11/24
 */
@Setter
@Getter
@ToString
public class DictionaryCuVo {

    private int parentId;

    private String name;

    private String code;

    private String remark;
}
