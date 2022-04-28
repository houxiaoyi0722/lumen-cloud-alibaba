package com.lumen.common.domain.provider.dict.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lumen.common.domain.base.BaseModel;
import com.lumen.common.domain.provider.dict.entity.finder.DictionaryFinder;
import lombok.*;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;

/**
 * 数据字典 组
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Entity
@Table(name = "DATA_DICTIONARY")
public class Dictionary extends BaseModel {

    public static final DictionaryFinder finder = DictionaryFinder.builder().build();

    @JsonIgnore
    @OneToMany(mappedBy = "dictionary", cascade = PERSIST)
    private List<DictionaryItem> dictionaryItems;
    /**
     * 组id
     */
    @Column(length = 10,nullable = false,unique = true)
    private String groupId;
    /**
     * 组名称
     */
    @Column(length = 10,nullable = false,unique = true)
    private String groupName;
    /**
     * 备注
     */
    @Column(length = 50)
    private String comment;

}
