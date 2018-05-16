/*
 * Copyright (C) 2018 justlive1
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package vip.justlive.common.base.convert.support;

import java.util.Set;
import com.google.common.collect.ImmutableSet;
import vip.justlive.common.base.convert.Converter;

/**
 * String -> Boolean 转换器<br>
 * 注意: null和空字符串被解析为false
 * 
 * 
 * @author wubo
 *
 */
public class StringToBooleanConverter implements Converter<String, Boolean> {

  /**
   * 表示true的字符值
   */
  private static final Set<String> TRUE_VALUES = ImmutableSet.of("true", "on", "yes", "1");

  /**
   * 表示false的字符值
   */
  private static final Set<String> FALSE_VALUES = ImmutableSet.of("false", "off", "no", "0");


  @Override
  public Boolean convert(String source) {

    String value = source;
    if (value == null || value.trim().isEmpty()) {
      return Boolean.FALSE;
    }

    value = value.toLowerCase();

    if (TRUE_VALUES.contains(value)) {
      return Boolean.TRUE;
    } else if (FALSE_VALUES.contains(value)) {
      return Boolean.FALSE;
    } else {
      throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
    }
  }

  @Override
  public ConverterTypePair pair() {
    return ConverterTypePair.create(String.class, Boolean.class);
  }
}
