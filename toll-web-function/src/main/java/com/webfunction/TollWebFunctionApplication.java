package com.webfunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.webfunction.model.TollRecord;
import com.webfunction.model.TollStation;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class TollWebFunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(TollWebFunctionApplication.class, args);
	}

	private List<TollStation> tollStationList;

	public TollWebFunctionApplication() {
		tollStationList = new ArrayList<TollStation>();
		tollStationList.add(new TollStation("100A", 112.5f, 2));
		tollStationList.add(new TollStation("111C", 124f, 4));
		tollStationList.add(new TollStation("112B", 126.7f, 2));
	}

	@Bean
	public Function<String, TollStation> retrieveStation() {
		return value -> {
			System.out.println("received request for station - " + value);
			return tollStationList.stream().filter(toll -> value.equals((toll.getStationId())))
					.findAny().orElse(null);
		};
	}

	@Bean
	public Consumer<TollRecord> processTollRecord() {
		return value -> {
			System.out.println("Received toll for car with license plate - " + value.getLicensePlate());
		};
	}

	@Bean
	public Function<TollRecord, Mono<Void>> processTollRecordReactive() {
		return value -> {
			System.out.println("Received toll for car with license plate - " + value.getLicensePlate());
			return Mono.empty();
		};
	}

	@Bean
	public Consumer<Flux<TollRecord>> processListTollRecordReactive() {
		return value -> {
			value.subscribe(toll -> System.out.println(toll.getLicensePlate()));
		};
	}

	@Bean
	public Supplier<Flux<TollStation>> getTollStations() {
		return () -> Flux.fromIterable(tollStationList);
	}

}
