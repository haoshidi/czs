package com.czscloud.czs.common.security.component;

import com.czscloud.czs.common.core.util.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

/**
 * @author lengleng
 * @date 2020/9/29
 * <p>
 * redis token store 自动配置
 */
@Slf4j
@EnableScheduling
@ConditionalOnBean(AuthorizationServerConfigurerAdapter.class)
public class MyTokenStoreAutoCleanSchedule {

	/**
	 * 每小时执行一致，避免 redis zset 容量问题
	 */
	@Scheduled(cron = "@hourly")
	public void doMaintenance() {
		MyRedisTokenStore tokenStore = SpringContextHolder.getBean(MyRedisTokenStore.class);
		long maintenance = tokenStore.doMaintenance();
		log.debug("清理Redis ZADD 过期 token 数量: {}", maintenance);
	}

}
