# Casino JWT Service Authentication Controller

This controller is responsible for handling authentication and registration requests in the Casino JWT Service.

## Table of Contents

- [Endpoints](#endpoints)
  - [Registration](#registration)
  - [Authentication](#authentication)
  - [OAuth Authentication](#oauth-authentication)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Endpoints

### Registration

Allows users to register in the system.

- **URL**: `/api/v1/auth/registration`
- **HTTP Method**: POST
- **Request Parameters**:
  - `firstName` (String): User's first name.
  - `lastName` (String): User's last name.
  - `email` (String): User's email address.
  - `password` (String): User's password.
- **Response**: Returns a string response representing the result of the registration.

**Status 200**
<img width="1615" alt="Снимок экрана 2023-10-28 в 19 09 32" src="https://github.com/Pekar7/jwt-auth/assets/90376574/6186d985-b946-4a5e-bd36-8fa48b2f9424">


### Authentication

Allows users to authenticate and obtain an access token.

- **URL**: `/api/v1/auth/authentication`
- **HTTP Method**: POST
- **Request Parameters**:
  - `email` (String): User's email address.
  - `password` (String): User's password.
- **Response**: Returns an `AuthenticationResponse` object wrapped in a `ResponseEntity`.

**Status 200 Valid Token**
<img width="1451" alt="Снимок экрана 2023-10-28 в 19 15 30" src="https://github.com/Pekar7/jwt-auth/assets/90376574/7f8d3ba1-139f-4732-9191-5bcffeacfc66">


**Status 403 Invalid Token** 
<img width="1486" alt="Снимок экрана 2023-10-28 в 19 15 50" src="https://github.com/Pekar7/jwt-auth/assets/90376574/5e4fa374-6a4d-4b75-9e16-1231353cc6c7">


### OAuth Authentication

Allows users to authenticate using OAuth tokens.

- **URL**: `/api/v1/auth/oauth`
- **HTTP Method**: POST
- **Request Parameters**:
  - `jwtToken` (String): OAuth token for authentication.
- **Response**: Returns a response wrapped in a `ResponseEntity`.

**Status 200 Valid Token** 
<img width="1582" alt="Снимок экрана 2023-10-28 в 19 20 20" src="https://github.com/Pekar7/jwt-auth/assets/90376574/1885a2b3-5406-40b9-91af-8f56190fd5e7">


## Getting Started

To get started, make sure you have the Casino JWT Service up and running. You can configure the service using the `application.yml` file. The default configuration assumes PostgreSQL as the database.

## Usage

To use the endpoints, send HTTP requests to the respective URLs with the required parameters. You can use tools like Postman or `curl` for testing. Make sure to have valid input data for registration and authentication.

## Contributing

Feel free to contribute to this project by opening issues or creating pull requests. We welcome your input to make this service better.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
