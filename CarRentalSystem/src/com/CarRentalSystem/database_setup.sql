
CREATE DATABASE IF NOT EXISTS car_rental_db;


USE car_rental_db;


CREATE TABLE IF NOT EXISTS cars (
    plate_no VARCHAR(20) PRIMARY KEY,           
    model VARCHAR(50) NOT NULL,                  
    category VARCHAR(20) NOT NULL,               
    rate_per_day DOUBLE NOT NULL,               
    status VARCHAR(20) DEFAULT 'Available'       
);


INSERT INTO cars (plate_no, model, category, rate_per_day, status) VALUES
('MH01AB1234', 'Maruti Suzuki Brezza', 'SUV', 2500.00, 'Available'),
('MH02CD5678', 'Hyundai Creta', 'SUV', 3000.00, 'Available'),
('DL03EF9012', 'Honda City', 'Sedan', 2000.00, 'Available'),
('KA04GH3456', 'Maruti Suzuki Dzire', 'Sedan', 1800.00, 'Available'),
('TN05IJ7890', 'Hyundai i20', 'Hatchback', 1500.00, 'Available'),
('GJ06KL2345', 'Maruti Suzuki Swift', 'Hatchback', 1400.00, 'Available'),
('RJ07MN6789', 'Mahindra Scorpio', 'SUV', 2800.00, 'Available'),
('UP08OP0123', 'Tata Nexon', 'SUV', 2600.00, 'Available'),
('MP09QR4567', 'Hyundai Verna', 'Sedan', 2200.00, 'Available'),
('WB10ST8901', 'Tata Altroz', 'Hatchback', 1600.00, 'Available');


SELECT * FROM cars;


