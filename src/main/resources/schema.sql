CREATE DATABASE event_manager;

\c event_manager;

CREATE TABLE event (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    status VARCHAR(50) NOT NULL,
    CONSTRAINT event_status_check CHECK (status IN ('STARTED', 'COMPLETED', 'PAUSED')),
    CONSTRAINT end_date_after_start_date CHECK (end_date > start_date)
);

INSERT INTO event (title, start_date, end_date, price, status) VALUES
('Agriculture Expo', '2024-10-10 09:00:00', '2024-10-10 17:00:00', 50.00, 'Started'),
('FarmTech Conference', '2024-11-05 10:00:00', '2024-11-05 16:00:00', 75.00, 'Paused'),
('Harvest Festival', '2024-12-01 08:00:00', '2024-12-01 20:00:00', 30.00, 'Completed'),
('Smart Farming Workshop', '2024-12-15 09:30:00', '2024-12-15 17:00:00', 100.00, 'Started');

SELECT * FROM event;
