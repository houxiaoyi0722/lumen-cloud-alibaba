package com.lumen.common.domain.provider.dict.entity.finder;

import com.lumen.common.domain.provider.dict.entity.Dictionary;
import io.ebean.Finder;
import lombok.Builder;

/**
 * @author xiaoy
 */
@Builder
public class DictionaryFinder extends Finder<Long, Dictionary> {

  /**
   * Construct using the default EbeanServer.
   */
  public DictionaryFinder() {
    super(Dictionary.class);
  }

}

