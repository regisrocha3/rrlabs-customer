CREATE KEYSPACE rrlabs_customer WITH replication = {'class' : 'SimpleStrategy','replication_factor' : 1};

create columnFamily rrlabs_customer.customer (
	id UUID,
	email text,
	birthdate date,
	name text,
	created timestamp,
	modified timestamp,
	PRIMARY KEY (id)
);











