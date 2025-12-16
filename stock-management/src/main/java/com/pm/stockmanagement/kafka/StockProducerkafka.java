package com.pm.stockmanagement.kafka;

import com.pm.stockmanagement.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import stock.manager.StockBalance;

@Service
public class StockProducerkafka {
    @Autowired
    private KafkaTemplate<String, byte[]> kafkaTemplate;

    public void sendItemEvent(Item item) {
        var payload = StockBalance.newBuilder().setItemCode(item.getTitle()).setStockBalance("50").build();
        kafkaTemplate.send("item-topic", payload.toByteArray());
    }

}
