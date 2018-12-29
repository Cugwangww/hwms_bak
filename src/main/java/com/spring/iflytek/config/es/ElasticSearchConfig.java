package com.spring.iflytek.config.es;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class ElasticSearchConfig {

    @Value("${es.address}")
    private String address;
    @Value("${es.cluster.name}")
    private String clusterName;
    private TransportClient client = null;
    @Bean
    public TransportClient getConnect() throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name", clusterName).build();
        client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(address), 9300));
        return client;
    }
}
