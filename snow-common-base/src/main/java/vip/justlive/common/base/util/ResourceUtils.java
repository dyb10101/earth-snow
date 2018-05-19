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
package vip.justlive.common.base.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import vip.justlive.common.base.constant.BaseConstants;

/**
 * 资源工具类
 * 
 * @author wubo
 *
 */
public class ResourceUtils {

  ResourceUtils() {}

  /**
   * 判断URL是否是jar文件
   * 
   * @param url 路径
   * @return true是jar文件
   */
  public static boolean isJarURL(URL url) {
    String protocol = url.getProtocol();
    return (BaseConstants.URL_PROTOCOL_JAR.equals(protocol)
        || BaseConstants.URL_PROTOCOL_WAR.equals(protocol)
        || BaseConstants.URL_PROTOCOL_ZIP.equals(protocol)
        || BaseConstants.URL_PROTOCOL_VFSZIP.equals(protocol)
        || BaseConstants.URL_PROTOCOL_WSJAR.equals(protocol));
  }

  /**
   * String转换成URI
   * 
   * @param url 路径
   * @return URI
   * @throws URISyntaxException 转换不了URI抛出异常
   */
  public static URI toURI(String url) throws URISyntaxException {
    return new URI(url.replace(" ", "%20"));
  }

  /**
   * URL转换成URI
   * 
   * @param url 路径
   * @return URI
   * @throws URISyntaxException 转换不了URI抛出异常
   */
  public static URI toURI(URL url) throws URISyntaxException {
    return new URI(url.toString().replace(" ", "%20"));
  }

  /**
   * 获取相对资源路径
   * 
   * @param rootPath 根路径
   * @param relative 相对路径
   * @return 路径
   */
  public static String relativePath(String rootPath, String relative) {
    int last = rootPath.lastIndexOf(BaseConstants.PATH_SEPARATOR);
    String newPath = rootPath;
    if (last > -1) {
      newPath = rootPath.substring(0, last);
      if (!relative.startsWith(BaseConstants.PATH_SEPARATOR)) {
        newPath += BaseConstants.PATH_SEPARATOR;
      }
      newPath += relative;
    }
    return newPath;
  }
}
