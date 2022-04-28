package com.lumen.provider.service.dict;

import com.lumen.api.dict.DataHandleApi;
import com.lumen.common.domain.provider.dict.entity.Dictionary;
import com.lumen.common.domain.provider.dict.vo.DataDictionaryQry;
import com.lumen.provider.repository.dict.DictionaryRepository;
import io.ebean.PagedList;
import io.ebean.annotation.Transactional;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hxy
 * @date 2020/8/3 shanghai
 */
@Service(version = "1.0.0",group = "provider")
@CommonsLog(topic = "DataHandleService")
public class DataHandleService implements DataHandleApi {

    @Resource
    private DictionaryRepository dictionaryRepository;

    @Override
    public PagedList<Dictionary> dictionaryList(DataDictionaryQry dataDictionaryQry) {
        return dictionaryRepository.getDictionaryList(dataDictionaryQry);
    }

    @Override
    public Dictionary findOne(Long id) {
        return dictionaryRepository.findById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Dictionary dictionary) {
        dictionary.save();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(Dictionary dictionary) {
        dictionary.insert();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Dictionary dictionary) {
        dictionary.update();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Dictionary dictionary) {
        dictionaryRepository.delete(dictionary);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAll(List<Dictionary> dictionaries) {
        dictionaryRepository.saveAll(dictionaries);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAll(List<Dictionary> dictionaries) {
        dictionaryRepository.deleteAll(dictionaries);
    }

}
