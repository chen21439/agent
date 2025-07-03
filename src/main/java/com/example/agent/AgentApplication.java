package com.example.agent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AgentApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(AgentApplication.class, args);
        List<byte[]> list = new ArrayList<>();
        while (true) {
            // 每100ms分配10MB，快速填满Eden区
            list.add(new byte[10 * 1024 * 1024]);
            Thread.sleep(100);
            if (list.size() > 50) {
                list.clear(); // 释放引用触发GC
                System.out.println("List cleared");
            }
        }
    }

}
