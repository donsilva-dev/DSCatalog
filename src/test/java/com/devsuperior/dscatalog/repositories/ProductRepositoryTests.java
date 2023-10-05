package com.devsuperior.dscatalog.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.devsuperior.dscatalog.entities.Product;

@DataJpaTest
public class ProductRepositoryTests {

	@Autowired
	private ProductRepository repository;

	@Test
	public void deleteShouldDeleteObjectwhenIdExist() {

		// instanciando o objeto necessario (Arrange)
		long existingId = 1L;

		// executar as acçoes necessarias (Act)
		repository.deleteById(existingId);

		// declarar o que deverar acontecer (Assert) verificar se realmente deleto

		Optional<Product> result = repository.findById(existingId);
		Assertions.assertFalse(result.isPresent());

	}

	@Test
	public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {

		// instanciando o objeto necessario (Arrange)
		long nonExistingId = 100L;

		// declarar o que deverar acontecer (Assert) verificar se realmente deleto
		Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
			repository.deleteById(nonExistingId);
		});

	}

}
