### Running the API

**Prerequisites:**

* Java 21
* Gradle

1. Clone the project repository.
2. Navigate to the project directory in your terminal.
3. Run `./gradlew build` to build the project. (On Windows use `gradlew.bat build`)
4. Run `./gradlew bootRun` to start the application. (On Windows use `gradlew.bat bootRun`)

**API Endpoint:**

The API is accessible at `http://localhost:8080` by default (port might vary).

### Testing the API

**1. Adding a Country**

* Use a tool like Postman or curl to send a POST request to `http://localhost:8080/country` with a JSON body containing the country information:

```json
{
  "name": "France",
  "capital": "Paris",
  "population": 65273511
}

```

* The response will be a success message indicating the country information is saved.

**2. Getting All Countries**

* Send a GET request to http://localhost:8080/countries

The response will be a JSON array containing all the countries stored in the database.

**3. Deleting a Country**

* Send a DELETE request to http://localhost:8080/country/{name} where {name} is the name of the country to delete.

* The response will be a message indicating whether the deletion was successful or not.


