package com.egustore.eshop.config;


import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary getCloudinary(){
        Map<String, String> config = new HashMap();
        config.put("cloud_name", "dtakf5ayx");
        config.put("api_key", "177366443744147");
        config.put("api_secret", "FsmT1xuoPyLd001puITqdPtW4ZE");
        config.put("secure", "true");
        return new Cloudinary(config);
    }

}
