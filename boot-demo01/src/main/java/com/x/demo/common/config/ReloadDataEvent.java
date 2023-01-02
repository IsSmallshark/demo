package com.x.demo.common.config;

import org.springframework.context.ApplicationEvent;

public class ReloadDataEvent extends ApplicationEvent {
    public ReloadDataEvent(Object source) {
        super(source);
    }
}
