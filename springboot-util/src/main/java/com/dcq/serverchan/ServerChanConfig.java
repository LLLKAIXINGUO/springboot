package com.dcq.serverchan;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServerChanConfig {
    @Value("${spring.serverchan.sckey}")
    private String sckey;

    public String getSckey() {
        return this.sckey;
    }


}
