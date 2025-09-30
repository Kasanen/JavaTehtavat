-- Create the company database
CREATE DATABASE IF NOT EXISTS company;

-- Grant permissions to appuser
GRANT ALL PRIVILEGES ON company.* TO 'appuser'@'localhost';
FLUSH PRIVILEGES;

-- Create the employee table
USE company;
CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    salary DOUBLE
);

-- Insert some sample data
INSERT INTO employee (first_name, last_name, email, salary) VALUES 
('John', 'Doe', 'john.doe@company.com', 50000.0),
('Jane', 'Smith', 'jane.smith@company.com', 60000.0),
('Bob', 'Johnson', 'bob.johnson@company.com', 55000.0);