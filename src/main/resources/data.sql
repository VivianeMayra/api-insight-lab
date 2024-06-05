INSERT INTO supplier (name, cnpj, address, phone, email, website, description, status, created_at, updated_at)
VALUES 
( 'Fornecedor 1', '54.321.987/0001-21', 'Rua 1 casa 10', '1234567890', 'fornecedor1@example.com', 'http://fornecedor1.com', 'Descrição 1', 'ACTIVE', NOW(), NOW()),
( 'Fornecedor 2', '98.765.432/0001-09', 'Rua 2 casa 104', '1234567891', 'fornecedor2@example.com', 'http://fornecedor2.com', 'Descrição 2', 'INACTIVE', NOW(), NOW()),
( 'Fornecedor 3', '23.456.789/0001-66', 'Rua 3 casa 1948', '1234567892', 'fornecedor3@example.com', 'http://fornecedor3.com', 'Descrição 3', 'UNDER_ANALYSIS', NOW(), NOW()); 

