package buckets.framework.dictionary.entity;

import buckets.framework.base.common.entity.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author buckets
 * @date 2020/11/23
 */
@Data
//@Entity
@Table(name = "dictionary")
public class Dictionary extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id",columnDefinition = "主键")
    private Integer id;

    @Column(name="parent_id",columnDefinition = "父级节点ID")
    private Integer parentId;

    @Column(name="name",columnDefinition = "节点显示名称")
    private String name;

    @Column(name="code",columnDefinition = "节点代表字符")
    private String code;

    @Column(name="hierarchy",columnDefinition = "节点层级，建议节点层级不要超过10级")
    private Integer hierarchy;

    @Column(name="remark",columnDefinition = "备注/说明")
    private String remark;

    @Column(name="create_time",columnDefinition = "创建时间")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Column(name="update_time",columnDefinition = "更新时间")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
