package com.bigdatacompany.kafka;

import java.util.Properties;
import java.util.Scanner;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class Produce {

	public static void main(String[] args) {
		//input
		Scanner input = new Scanner(System.in);
		Properties config = new Properties();
		// configurations
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, new StringSerializer().getClass().getName());
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, new StringSerializer().getClass().getName());
		
		Producer producer = new KafkaProducer<String, String>(config);
		for(int i = 1; i<5; i++ ) {
			System.out.println("Produce edilcek data: ");
			String value = input.nextLine();
			
			ProducerRecord<String, String> rec = new ProducerRecord<String, String>("search", value);
			producer.send(rec);
		}
		System.out.println("Finished....");
		/*ProducerRecord<String, String> rec = new ProducerRecord<String, String>("search", "çanta");
		
		producer.send(rec);
		producer.close();
		*/
	}

}
