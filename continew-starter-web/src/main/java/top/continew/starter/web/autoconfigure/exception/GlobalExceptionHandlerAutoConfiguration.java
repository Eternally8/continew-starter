/*
 * Copyright (c) 2022-present Charles7c Authors. All Rights Reserved.
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package top.continew.starter.web.autoconfigure.exception;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import top.continew.starter.web.autoconfigure.i18n.I18nProperties;

/**
 * 全局异常处理器自动配置
 *
 * @author Charles7c
 * @since 1.0.0
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnMissingBean(BasicErrorController.class)
@Import({GlobalExceptionHandler.class, GlobalErrorHandler.class})
@EnableConfigurationProperties(I18nProperties.class)
public class GlobalExceptionHandlerAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandlerAutoConfiguration.class);

    @PostConstruct
    public void postConstruct() {
        log.debug("[ContiNew Starter] - Auto Configuration 'Web-Global Exception Handler' completed initialization.");
    }
}
