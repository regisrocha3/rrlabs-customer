package rr.labs.customer.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import rr.labs.customer.domain.Customer;

/**
 * Repositorio para armazenar acesso as informacoes dos clientes.
 * 
 * @author regis
 *
 */
@Repository
public interface CustomerRepository extends CassandraRepository<Customer, Customer> {
	
}
