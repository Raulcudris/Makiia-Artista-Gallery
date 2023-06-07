package com.makiia.infrastructure.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication(scanBasePackages = {
		"com.makiia.infrastructure",
		"com.makiia.modules",
		"com.makiia.crosscutting"})
@EnableJpaRepositories(basePackages = {
		"com.makiia.crosscutting.persistence.repository",
		"com.makiia.modules.gallery.usecase.EntyRecgaleriarecmaService"})
@EntityScan(basePackages = "com.makiia.crosscutting.persistence.entity")
public class MakiiaArtistGalleryApplication {

	public static void main(final String[] args) {
		SpringApplication.run(MakiiaArtistGalleryApplication.class, args);
	}

}
