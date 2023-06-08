package com.example.SpringBootNeo4j.repository;

import com.example.SpringBootNeo4j.model.Song;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SongRepository extends Neo4jRepository<Song, Long> {
}
