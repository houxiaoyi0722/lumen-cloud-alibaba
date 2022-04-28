package com.lumen.common.domain.provider.dict.entity.finder;

import com.lumen.common.domain.provider.dict.entity.DictionaryItem;
import io.ebean.Finder;
import lombok.Builder;

/**
 * @author xiaoy
 */
@Builder
public class DictionaryItemFinder extends Finder<Long, DictionaryItem> {

  /**
   * Construct using the default EbeanServer.
   */
  public DictionaryItemFinder() {
    super(DictionaryItem.class);
  }

}

