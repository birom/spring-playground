#!/bin/bash

export TKN=$(curl -X POST 'http://localhost:8888/auth/realms/master/protocol/openid-connect/token' \
 -H "Content-Type: application/x-www-form-urlencoded" \
 -d "username=admin" \
 -d 'password=admin' \
 -d 'grant_type=password' \
 -d 'client_id=admin-cli' | jq -r '.access_token')

curl -vX POST --data '@./test-users.json' 'http://localhost:8888/auth/admin/realms/microservice-security-realm/users' \
-H "Accept: application/json" \
-H 'Content-Type: application/json;charset=UTF-8' \
-H "Authorization: Bearer $TKN" | jq .

curl -vX POST --data '@./microservice-security-realm.json' 'http://localhost:8888/auth/admin/realms' \
-H "Accept: application/json" \
-H 'Content-Type: application/json;charset=UTF-8' \
-H "Authorization: Bearer $TKN" | jq .