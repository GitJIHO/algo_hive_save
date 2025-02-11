package com.knu.algo_hive.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${file.path}")
    String uploadPath;
    @Value("${image.url}")
    String imageUrl;
    @Value("${post.image.url}")
    private String postImageUrl;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*") // 와일드카드 사용
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(imageUrl + "**")
                .addResourceLocations("file://" + uploadPath);

        registry.addResourceHandler(postImageUrl + "**")
                .addResourceLocations("file://" + uploadPath);
    }
}
