package com.winter.web.service;

/**
 * kafka业务接口
 * 
 * @author ydd
 *
 */
public interface IKafkaService {

	/**
	 * 发送消息
	 * @param topic
	 * @param message
	 */
	public void sendMessage(String topic, String message) throws Exception;

}
