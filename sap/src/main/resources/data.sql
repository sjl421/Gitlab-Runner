insert into customer(id, first_name, last_name) values(1, 'Yassir', 'Bonyad');
insert into customer(id, first_name, last_name) values(2, 'Ramadan', 'Daoud');
insert into customer(id, first_name, last_name) values(3, 'Christoph', 'Held');


insert into bill (id, customer_id, tariff, period, tax, single_price, net_price, gross_price)  values(1, '1', 'MagentaEins', '01.08.2018 - 31.08.2018', '19%', '25.0', '25.0', '30.0');
insert into bill (id, customer_id, tariff, period, tax, single_price, net_price, gross_price)  values(2, '2', 'MagentaEins', '01.08.2018 - 31.08.2018', '19%', '25.0', '25.0', '30.0');
insert into bill (id, customer_id, tariff, period, tax, single_price, net_price, gross_price)  values(3, '3', 'MagentaEins', '01.08.2018 - 31.08.2018', '19%', '25.0', '25.0', '30.0');
insert into bill (id, customer_id, tariff, period, tax, single_price, net_price, gross_price)  values(4, '1', 'MagentaMobile', '01.08.2018 - 31.08.2018', '19%', '25.0', '25.0', '30.0');