package com.arquitetura.hexagonal.adapter.cli;

import com.arquitetura.hexagonal.Application;
import com.arquitetura.hexagonal.adapters.cli.ProductCommandLineRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.ContextConfiguration;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = Application.class)
public class ProductCommandLineRunnerTest {

    @MockBean
    private ProductCommandLineRunner productCommandLineRunner;

    @Test
    public void testRunWithCreate1() throws Exception {
        productCommandLineRunner.run("create1");
        verify(productCommandLineRunner, times(1)).run("create1");
    }

    @Test
    public void testRunWithCreate2() throws Exception {
        productCommandLineRunner.run("create2");
        verify(productCommandLineRunner, times(1)).run("create2");
    }

    @Test
    public void testRun() throws Exception {
        verify(productCommandLineRunner, times(1)).run();
    }
}
