package com.ozkansari.httpproxy.configuration;

import org.mitre.dsmiley.httpproxy.ProxyServlet;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class GeneralHttpProxyServletConfiguration implements EnvironmentAware {

	private static final String ENV_PROXY_REPLACER = "proxy.general.my.";
	
	private RelaxedPropertyResolver propertyResolver;

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {

		String servletUrlProperty = propertyResolver.getProperty("servlet_url");
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new ProxyServlet(), servletUrlProperty);

		String targetUrlProperty = propertyResolver.getProperty("target_url");
		servletRegistrationBean.addInitParameter("targetUri", targetUrlProperty);
		servletRegistrationBean.addInitParameter(ProxyServlet.P_LOG, propertyResolver.getProperty("logging_enabled", "false"));
		
		return servletRegistrationBean;
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.propertyResolver = new RelaxedPropertyResolver(environment, ENV_PROXY_REPLACER);
	}
}
