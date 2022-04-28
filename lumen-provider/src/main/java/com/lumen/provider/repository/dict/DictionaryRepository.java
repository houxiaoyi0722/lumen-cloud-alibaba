package com.lumen.provider.repository.dict;

import com.lumen.common.domain.provider.dict.entity.Dictionary;
import com.lumen.common.domain.provider.dict.entity.query.QDictionary;
import com.lumen.common.domain.provider.dict.vo.DataDictionaryQry;
import io.ebean.BeanRepository;
import io.ebean.Database;
import io.ebean.PagedList;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiaoy
 */
@Repository
public class DictionaryRepository extends BeanRepository<Long, Dictionary> {

    protected DictionaryRepository(Database server) {
        super(Dictionary.class, server);
    }

    public List<Dictionary> getDictionaryListByGroupIds(List<String> groupIds) {
        return new QDictionary().groupId.in(groupIds).deleted.isFalse().findList();
    }

    public PagedList<Dictionary> getDictionaryList(DataDictionaryQry dataDictionaryQry) {
        QDictionary dataDictionary = QDictionary.alias();

        return new QDictionary()
                .select(dataDictionary.groupId,
                        dataDictionary.groupName,
                        dataDictionary.comment)
                .deleted.isFalse()
                .setFirstRow(dataDictionaryQry.getStartPosition())
                .setMaxRows(dataDictionaryQry.getEndPosition())
                .orderBy().whenCreated.desc()
                .findPagedList();
    }
}
