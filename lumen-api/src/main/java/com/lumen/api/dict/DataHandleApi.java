package com.lumen.api.dict;

import com.lumen.common.domain.provider.dict.entity.Dictionary;
import com.lumen.common.domain.provider.dict.vo.DataDictionaryQry;
import io.ebean.PagedList;

import java.util.List;

public interface DataHandleApi {

    PagedList<Dictionary> dictionaryList(DataDictionaryQry dataDictionaryQry);

    Dictionary findOne(Long id);

    void save(Dictionary dictionary);

    void saveAll(List<Dictionary> dictionaries);

    void insert(Dictionary dictionary);

    void update(Dictionary dictionary);

    void delete(Dictionary dictionary);

    void deleteAll(List<Dictionary> dictionaries);
}
