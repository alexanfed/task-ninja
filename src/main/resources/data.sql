-- Start a transaction
BEGIN;

-- Create table "User"
DROP TABLE IF EXISTS "User";
CREATE TABLE "User" (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);

-- Create table Task
DROP TABLE IF EXISTS Task;
CREATE TABLE Task (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(1000),
  creation_date DATE NOT NULL,
  due_date DATE,
  status VARCHAR(50) NOT NULL,
  assignee_id INT,
  FOREIGN KEY (assignee_id) REFERENCES "User" (id)
);

-- Create table Comment
DROP TABLE IF EXISTS Comment;
CREATE TABLE Comment (
  id SERIAL PRIMARY KEY,
  text VARCHAR(1000) NOT NULL,
  creation_date DATE NOT NULL,
  task_id INT NOT NULL,
  user_id INT NOT NULL,
  FOREIGN KEY (task_id) REFERENCES Task (id),
  FOREIGN KEY (user_id) REFERENCES "User" (id)
);

-- Insert sample users
INSERT INTO "User" (name, email, password)
VALUES ('John Doe', 'john@example.com', 'password123'),
       ('Jane Smith', 'jane@example.com', 'securePassword'),
       ('Mike Johnson', 'mike@example.com', 'pass1234');

-- Insert sample tasks
INSERT INTO Task (name, description, creation_date, due_date, status, assignee_id)
VALUES ('Task 1', 'Sample task 1 description', '2023-08-01', '2023-08-15', 'In Progress', 888955977678422017),
       ('Task 2', 'Sample task 2 description', '2023-08-02', '2023-08-18', 'Not Started', 888955977678422017),
       ('Task 3', 'Sample task 3 description', '2023-08-03', '2023-08-20', 'Completed', 888955977678422017);

-- Insert sample comments
INSERT INTO Comment (text, creation_date, task_id, user_id)
VALUES ('This looks great!', '2023-08-05', 888957045432483841, 888955977678422017),
       ('Keep up the good work!', '2023-08-06', 888957045432483841, 888955977678422017),
       ('Well done!', '2023-08-06', 888957045432483841, 888955977678422017);

-- Commit the transaction
COMMIT;