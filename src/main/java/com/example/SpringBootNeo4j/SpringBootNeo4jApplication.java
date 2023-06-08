package com.example.SpringBootNeo4j;

import com.example.SpringBootNeo4j.model.AppearsOn;
import com.example.SpringBootNeo4j.model.Song;
import com.example.SpringBootNeo4j.repository.SongRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootNeo4jApplication implements CommandLineRunner {

	public SpringBootNeo4jApplication(SongRepository songRepository) {
		this.songRepository = songRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootNeo4jApplication.class, args);
	}

	private final SongRepository songRepository;

	@Override
	public void run(String... args) throws Exception {
		for(Song song : songRepository.findAll()) {
			System.out.println(song.getName());
			for(AppearsOn appearsOn : song.getReleases()) {
				System.out.println("   " + appearsOn.getSongNr() + " " + appearsOn.getRelease().getName());
			}
		}
	}
}
