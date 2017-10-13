#Microservice security (not compolete yet)

Example app for experimenting keycloak and oauth2.

##Setup and run the app

- start keycloak with docker-compose.yml file
- create a test realm, client and user with the scripts/keycloak/init.sh
- initialize the password for the test user on the keycloak UI
- start the car-service spring boot app
- execute ng build in the webapp directory
- start the  gateway spring boot app