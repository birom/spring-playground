# Microservice security (not complete yet)

Example app for experimenting keycloak and oauth2.

## Setup and run the app

- start keycloak with docker-compose.yml file
- create a test realm, client and user with the scripts/keycloak/init.sh
- start the car-service spring boot app
- execute ng build in the webapp directory
- start the  gateway spring boot app