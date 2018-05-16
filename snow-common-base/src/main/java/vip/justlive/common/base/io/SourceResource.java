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
package vip.justlive.common.base.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 各种类型的资源公共接口，包括文件系统的文件或者是classpath下的资源
 * 
 * @author wubo
 *
 */
public interface SourceResource extends SourceStream {

  /**
   * 返回资源路径
   * 
   * @return
   */
  String path();

  /**
   * 是否存在
   * 
   * @return
   */
  default boolean exist() {
    try {
      return getFile().exists();
    } catch (IOException e) {
      try {
        InputStream in = getInputStream();
        in.close();
        return true;
      } catch (IOException e1) {
        return false;
      }
    }
  }

  /**
   * 是否文件
   * 
   * @return
   */
  boolean isFile();

  /**
   * 获取文件
   * 
   * @return
   */
  File getFile() throws IOException;

  /**
   * 获取资源的URL
   * 
   * @return
   * @throws IOException
   */
  URL getURL() throws IOException;

  /**
   * 使用{@value path}创建相对路径的{@code SourceResource}
   * 
   * @param path
   * @return
   */
  SourceResource createRelative(String path) throws IOException;
}