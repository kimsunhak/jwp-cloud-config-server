package com.config.cloud.test;


import com.ulisesbocchio.jasyptspringboot.properties.JasyptEncryptorConfigurationProperties;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JasyptConfigTest {

    private static final Logger logger = LoggerFactory.getLogger(JasyptConfigTest.class);

    @Value("${jasypt.encryptor.password}")
    private String jasyptPassword;

    @Test
    public void contextLoads() throws Exception {
        JasyptEncryptorConfigurationProperties properties = new JasyptEncryptorConfigurationProperties();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(jasyptPassword);
        config.setAlgorithm(properties.getAlgorithm());
        config.setKeyObtentionIterations(properties.getKeyObtentionIterations());
        config.setPoolSize(properties.getPoolSize());
        config.setSaltGeneratorClassName(properties.getSaltGeneratorClassname());
        config.setIvGeneratorClassName(properties.getIvGeneratorClassname());
        config.setStringOutputType(properties.getStringOutputType());

        PooledPBEStringEncryptor pooledPBEStringEncryptor = new PooledPBEStringEncryptor();
        pooledPBEStringEncryptor.setConfig(config);

        logger.info("password : {}", pooledPBEStringEncryptor.encrypt("사용자 이름"));
    }
}
