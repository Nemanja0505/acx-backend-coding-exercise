insert into customer (first_name, last_name, birth_date, driver_license_number)
values
    ('John', 'Doe', '1990-05-15', 'ABC12345'),
    ('Jane', 'Smith', '1985-09-20', 'DEF67890'),
    ('Alice', 'Johnson', '1998-03-10', 'GHI54321'),
    ('Bob', 'Wilson', '1976-12-05', 'JKL98765'),
    ('Eva', 'Brown', '1993-07-25', 'MNO12345');

insert into vehicle (brand, model, year_production, colour, registration)
values
    ('Toyota', 'Camry', 2022, 'Silver', 'ABC123'),
    ('Honda', 'Civic', 2021, 'Red', 'DEF456'),
    ('Ford', 'Mustang', 2023, 'Yellow', 'GHI789'),
    ('Chevrolet', 'Malibu', 2022, 'Blue', 'JKL012'),
    ('Volkswagen', 'Golf', 2020, 'Black', 'MNO345');

insert into rental (customer_id, vehicle_id, start_date, end_date)
values
    (1, 3, '2023-07-25', '2023-08-25'),
    (2, 4, '2023-07-25', '2023-08-25');
insert into rental (customer_id, vehicle_id, start_date, end_date, status)
values
    (3, 5, '2023-07-25', '2023-08-25',1);