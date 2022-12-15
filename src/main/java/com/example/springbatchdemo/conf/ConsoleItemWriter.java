package com.example.springbatchdemo.conf;

import io.micrometer.core.instrument.util.JsonUtils;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public  class ConsoleItemWriter<T> implements ItemWriter<T> {
    @Override
    public void write(List<? extends T> items) throws Exception {
        System.out.println("===========================================================");
        System.out.println("consolewrite");
        System.out.println(items.get(0).toString());
        for (T item : items) {
            System.out.println(item);
        }
    }


}
