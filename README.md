# Jumia Task

[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com)

[![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)](https://forthebadge.com)

[![forthebadge](https://forthebadge.com/images/badges/built-with-swag.svg)](https://forthebadge.com)

[![forthebadge](https://forthebadge.com/images/badges/uses-git.svg)](https://forthebadge.com)

Models:

1. `Customer` - Each Shop Location

   | Field     | Type          | Meaning                                                |
   | --------- | ------------- | ------------------------------------------------------ |
   | `name`    | `string`      | The Name of the customer                               |
   | `phone`   | `string`      | The customer phone number                              |
   | `id`      | `int`         | Identifier                                             |
   
   
   
 | API Endpoint                    | Details                                                                                 |
   | --------------------------- | --------------------------------------------------------------------------------------- |
   | `GET /phones=?country=any`  | List all phones by country optional query param                                         |


To Build Docker Image for backend go to backend directory root then please run: 
change the tag if you want to

`docker build --tag=jumiabackend:latest .`

To Build Docker Image for frontnend go to the frontend directory root then please run: 
change the tag if you want to

`docker build --tag=jumiafrontend:latest .`

After That run the backend docker image:
change the port if you want to.

`docker run -p 8088:8088 jumiabackend:latest`

run the frontend docker image:

`docker run -p 3001:3000 jumiafrontend:latest`

access the frontend on 3001 localhost and search for a valid country to find results

Notes:
- I was not able to write a native SQL query because of the sqlite limitations and could not match the regex unless using a match while fetching all of the numbers
