package com.example.springcloudconsulconsumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringCloudConsulConsumerApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testApi1() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Callable<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tasks.add(() -> {
                mvc.perform(MockMvcRequestBuilders.get("/req1").param("test1", "value1"))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(status().isOk());
                return null;
            });
        }
        executorService.invokeAll(tasks);
        executorService.shutdown();
    }

    @Test
    public void testApi2() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Callable<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tasks.add(() -> {
                mvc.perform(MockMvcRequestBuilders.get("/req2").param("test2", "value2"))
//                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(status().isOk());
                return null;
            });
        }
        executorService.invokeAll(tasks);
        executorService.shutdown();
    }

    @Test
    public void testApi() throws InterruptedException {
        testApi1();
        testApi2();
    }

}
