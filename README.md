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


To Build Docker Image run: 
change the tag if you want to

`docker build --tag=jumia:latest .`

After That run the docker image:
change the port if you want to.

`docker run -p8088:8088 jumia:latest`

Notes:
- I was not able to write a native SQL query because of the sqlite limitations and could not match the regex unless using a match while fetching all of the numbers
