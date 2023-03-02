CREATE TABLE IF NOT EXISTS suppliers
(
    id   serial PRIMARY KEY,
    name varchar(20) not null
);

CREATE TABLE IF NOT EXISTS products
(
    id            serial PRIMARY KEY,
    name          text not null unique,
    product_type  varchar(20)  not null
);

CREATE TABLE IF NOT EXISTS products_suppliers
(
    suppliers_id int,
    products_id int,
    primary key (suppliers_id,products_id),
    FOREIGN KEY (suppliers_id) REFERENCES suppliers (id),
    FOREIGN KEY (products_id) REFERENCES products (id)
);

CREATE TABLE IF NOT EXISTS users
(
    id             serial PRIMARY KEY,
    email          varchar(20)     not null unique,
    password       text            not null,
    roles          varchar(20)     not null
);

INSERT INTO users (email, password, roles)
values ('Zertallian@mail.ru', '$2a$12$sXGNwTmtWp45MdLPgFL6V.kjmEIDPTahQm2hDtGwaKom3g0xSa02i', 'ROLE_ADMIN');

CREATE TABLE IF NOT EXISTS workers
(
    id          serial PRIMARY KEY,
    first_name   varchar(15) not null,
    last_name    varchar(15) not null,
    date_of_birth date        not null,
    post        varchar(20)         not null,
    salary      float       not null,
    user_id      int         not null,
    FOREIGN KEY (user_id) REFERENCES users (id)
);


CREATE TABLE IF NOT EXISTS orders
(
    id         serial PRIMARY KEY,
    product_id  int       not null,
    supplier_id int       not null,
    manager_id  int       not null,
    quantity   int       not null,
    date       timestamp not null,
    FOREIGN KEY (product_id) REFERENCES products (id),
    FOREIGN KEY (supplier_id) REFERENCES suppliers (id),
    FOREIGN KEY (manager_id) REFERENCES workers (id)
);

CREATE TABLE IF NOT EXISTS point_of_sale_types
(
    id   serial PRIMARY KEY,
    name varchar(20) not null
);

CREATE TABLE IF NOT EXISTS points_of_sale
(
    id                serial PRIMARY KEY,
    square            float not null,
    rent_price        float not null,
    halls_num          int not null,
    counters_num       int not null,
    point_of_sale_type_id int not null,
    manager_id         int,
    FOREIGN KEY (manager_id) REFERENCES workers (id),
    FOREIGN KEY (point_of_sale_type_id) REFERENCES point_of_sale_types (id)
);

CREATE TABLE IF NOT EXISTS products_points_of_sales
(
    id            int PRIMARY KEY,
    product_id     int not null,
    point_of_sale_id int not null,
    price         int not null,
    quantity      int not null,
    FOREIGN KEY (point_of_sale_id) REFERENCES points_of_sale (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);


CREATE TABLE IF NOT EXISTS customers
(
    id          serial PRIMARY KEY,
    first_name   varchar(15) not null,
    last_name    varchar(15) not null,
    date_of_birth date        not null,
    phone_number text        not null
);

CREATE TABLE IF NOT EXISTS purchases
(
    id            serial PRIMARY KEY,
    buyer_id       int       not null,
    worker_id      int       not null,
    point_of_sale_id int       not null,
    product_id     int       not null,
    price         int       not null,
    quantity       float       not null,
    date_of_sale   timestamp not null,
    FOREIGN KEY (buyer_id) REFERENCES customers (id),
    FOREIGN KEY (worker_id) REFERENCES workers (id),
    FOREIGN KEY (point_of_sale_id) REFERENCES points_of_sale (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);

CREATE TABLE IF NOT EXISTS workers_points_of_sale
(
    id            serial PRIMARY KEY,
    worker_id      int       not null,
    point_of_sale_id int       not null,
    start_work     date      not null,
    end_work       date      not null,
    salary        int       not null,
    FOREIGN KEY (worker_id) REFERENCES workers (id),
    FOREIGN KEY (point_of_sale_id) REFERENCES points_of_sale (id)
);




