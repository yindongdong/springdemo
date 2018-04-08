package com.winter.web.service.impl;

import java.util.concurrent.CountDownLatch;

import org.apache.commons.lang.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.winter.web.service.IKafkaService;

/**
 * kafka业务实现
 * 
 * @author ydd
 *
 */
@Service
public class KafkaServiceImpl implements IKafkaService {

	Logger log = LoggerFactory.getLogger(KafkaServiceImpl.class);

	@Autowired
	private KafkaTemplate<String, String> template;

	private final CountDownLatch latch = new CountDownLatch(3);

	@Override
	public void sendMessage(String topic, String message) throws Exception{
		if (StringUtils.isBlank(topic) || StringUtils.isBlank(message)) {
			throw new Exception("topic or message is blank !");
		}
		template.send(topic, message);
//		latch.await(60, TimeUnit.SECONDS);
		log.info("All received");
	}

	
    @KafkaListener(topics = "spring")
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        log.info("top--spring--message"+cr.toString());
//        latch.countDown();
    }
}
