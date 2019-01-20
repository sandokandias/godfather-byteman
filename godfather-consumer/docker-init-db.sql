CREATE USER godfather_consumer WITH PASSWORD 'godfather_consumer';
CREATE DATABASE godfather_consumer;
GRANT ALL PRIVILEGES ON DATABASE godfather_consumer TO godfather_consumer;
ALTER USER godfather_consumer WITH SUPERUSER;
