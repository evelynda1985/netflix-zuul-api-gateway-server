package com.in28minutes.microservices.netflixzuulapigatewayserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;

//Now we can access throw gateway using this url localhost:8765/{applicationName}/{url}
//for example localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/CLO

@Component
public class ZuulLoginFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        return "pre";//When the filter should happen before-pre, after-post, error-error
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true; //do we want to use this filter?
    }

    @Override
    public Object run() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();

        logger.info("request -> {} request uri -> {}", request, request.getRequestURI());
        return null;
    }
}
