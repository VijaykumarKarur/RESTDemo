# REST Demo Project
> The project is to demonstrate the REST controller and Method mapping for various HTTP methods such as GET, POST, PATCH and DELETE.

## Objective
>1. Learn to create REST Controller.
>2. Learn to handle and implement various HTTP methods.
>3. Learn to create appropriate HTTP responses with proper codes.

## Requirements
>1. Project should support creation, retrieval, update and deletion of Tasks.
>2. Each Task has a name, due date and status.
>   1. Name is a mandatory field.
>   2. due date by default is set to today + 7 days.
>   3. status by default is set to false.
>3. Ability to create task specifying name and/or due date and/or status.
>4. Task are assigned id sequentially, starting from 0.
>5. Ability to retrieve all Tasks.
>6. Ability to retrieve a specific Task based on id.
>7. Ability to update a Task due date and/or status based on id.
>8. Ability to delete a Task based on id.

## APIs
>1. GET http://[host][:port]/tasks/
>   1. Retrieves all Tasks
>2. GET http://[host][:port]/tasks/{id}
>   1. Retrieve a specific Task based on id
>3. POST http://[host][:port]/tasks/
>   1. Create a new Task based on request
>   2. Example Request -
>   http://localhost:3341/tasks/
>   Content-type: application/json

>    {"task":{"name":"Task 0","due_date":"2022-07-10","status":false}}
>4. PATCH http://[host][:port]/tasks/{id}
>    1. Update Task
>    2. Example Request -
>    http://localhost:3341/tasks/3
>    Content-type: application/json
   
>    {"due_date":"2022-07-05","status":true}
>5. DELETE http://[host][:port]/tasks/{id}
>   1. Delete Task


## Build Project
> .\gradlew.bat build

## Run Project
Go to build/libs folder
>  java -jar RESTDemo-0.0.1-SNAPSHOT.jar