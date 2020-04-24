package com.fideljose.reactivemiscelanea;

import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.IntStream;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.fideljose.reactivemiscelanea.configuration.LoadConfigFileData;

import lombok.extern.java.Log;
import reactor.core.publisher.Flux;

@Log
@PropertySource("classpath:custome.properties")
@SpringBootApplication
public class ReactiveMiscelaneaApplication implements CommandLineRunner {

	
	private static LoadConfigFileData loadConfigFileData = new LoadConfigFileData();
	
	@Autowired
	Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(ReactiveMiscelaneaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
//		FluxCreateExample();
//		BackPressureExample();
//		BackPressureExampleEasy();
//		IO_DataBuffer();
//		rangeStream();
//		sumStream();
		minStream();
	}
	
	public void BackPressureExampleEasy(){
		Flux.range(1, 100)
			.log()
			.limitRate(2)
			.doOnNext(e -> log.info(e.toString()))
			.doOnComplete(() -> log.info("FIN!!!"))
			.subscribe();
	}
	
	public void BackPressureExample(){
		Flux.range(1, 100)
		.log()
		.subscribe(new Subscriber<Integer>() {

			private Subscription s;
			private int count = 0;
			private int longRequest = 3;
			
			@Override
			public void onSubscribe(Subscription s) {
				log.info("Here onSubscribe");
				this.s = s;
				s.request(longRequest);
			}

			public void onNext(Integer t) {
				++count;
				if(count == longRequest) {
					count = 0;
					s.request(longRequest);
				}
				log.info("Here OnNetx " + t);
			}

			@Override
			public void onError(Throwable t) {
				log.info("Here Error");
			}

			@Override
			public void onComplete() {
				log.info("Here onComplete");
			}
			
		});
	}

	public void FluxCreateExample() {
		Flux.create(emitter -> {
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {

				private int count = 0;
				
				@Override
				public void run() {
					emitter.next(++count);
					if (count > 10) { 
						timer.cancel();
						emitter.complete();
					} 
				}
				
			}, 2000, 3000);
		}).doOnNext(n -> log.info("--- "+n))
		.doOnComplete(() -> log.info("Terminado"))
		.log()
		.subscribe();
	}
	
//	Recative I/O
//	public void IO_DataBuffer(){
//		Flux<DataBuffer> dataBuffer = DataBufferUtils
//				.read(
//						new DefaultResourceLoader().getResource("file.txt"),
//						new DefaultDataBufferFactory(),
//						1024
//						);
//		System.out.println("--------------------------" + dataBuffer.blockFirst().getByte(1024));
//	}
	
	public static void rangeStream() {
		IntStream.rangeClosed(1, 10)
				.forEach(i -> System.out.printf("%d ", i)); 
	}
	
	public static void sumStream() {
		int suma = IntStream.rangeClosed(1, 1000000)
					.sum();
		System.out.printf("%d", suma);
	}
	
	public static void minStream() {
		int[] valores = {/*3, 10, 6, 1, 4, 8, 2, 5, 9, 7*/};
		IntStream myStream = IntStream.of(valores);
		int min = myStream
					.min()
					.orElse(0);
		System.out.printf("%d", min);
		System.out.println("");
	}
	
}
