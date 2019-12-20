package rr.labs.customer.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import rr.labs.customer.domain.Customer;
import rr.labs.customer.repository.CustomerRepository;

/**
 * API para acesso as informacoes do cliente
 * 
 * @author regis
 *
 */
@RestController
@Api(value = "API para acesso as informacoes do cliente", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {
	
	/**
	 * LOG
	 */
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
    
    /**
     * @Inject
     */
    @Autowired
    private CustomerRepository repository;
    
    /**
     * Operacao para realizar a criacao de cliente
     * 
     * @param customer - Customer
     * 
     * @return ResponseEntity<Customer>
     */
    @PostMapping
    @ApiOperation(httpMethod = "POST", response = Customer.class, value = "Atualiza dados do cliente")
    public ResponseEntity<Customer> create(@Valid @RequestBody final Customer customer) {
    	LOGGER.info("Criando cliente: " + customer);
    	
    	customer.setId(UUID.randomUUID());
    	final Customer created = this.repository.save(customer);
    	
    	return ResponseEntity.created(URI.create("/customer/"+created.getId())).build();
    }
    
    @PutMapping
    @ApiOperation(httpMethod = "PUT", response = Customer.class, value = "Atualiza dados do cliente")
    public ResponseEntity<Customer> update(@Valid @RequestBody final Customer customer) {
    	LOGGER.info("Atualizando dados do cliente: {0}", customer);
    	
    	this.repository.save(customer);
    	
    	return ResponseEntity.created(URI.create("/customer/"+customer.getId())).build();
    }
    
	
    @GetMapping
    @ApiOperation(httpMethod = "GET", response = Customer.class, value = "API para consulta de todos os clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> findAll() {
    	LOGGER.info("Consultando dados de todos os clientes");
    	return ResponseEntity.ok(this.repository.findAll());
    }
    
	@GetMapping("/{id}")
	@ApiOperation(httpMethod = "GET", response = Customer.class, value = "API para consulta do cliente especifico pelo ID", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiParam(allowMultiple = false, example = "b256be94-bf6b-45ce-b5fb-a4fb672b745a", name = "ID do usuario", type = "String", required = true)
	public ResponseEntity<Customer> findById(@PathVariable("id") final String id) {
		LOGGER.info("Consultando dados do cliente por ID: " + id);
		
		final Optional<Customer> found = this.repository.findById(new Customer(id));
		
		if(found.isPresent()) {
			return ResponseEntity.ok(found.get());
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
}
