#!/bin/bash

echo '.getting access token'

export TKN=$(curl -X POST 'http://localhost:8888/auth/realms/master/protocol/openid-connect/token' \
 -H "Content-Type: application/x-www-form-urlencoded" \
 -d "username=admin" \
 -d 'password=admin' \
 -d 'grant_type=password' \
 -d 'client_id=admin-cli' | jq -r '.access_token')

echo '..creating realm'

curl -X POST --data '@./microservice-security-realm.json' 'http://localhost:8888/auth/admin/realms' \
-H "Accept: application/json" \
-H 'Content-Type: application/json;charset=UTF-8' \
-H "Authorization: Bearer $TKN"

echo '...creating test user'

LOCATION=$(curl -iX POST --data '@./test-users.json' 'http://localhost:8888/auth/admin/realms/microservice-security-realm/users' \
-H "Accept: application/json" \
-H 'Content-Type: application/json;charset=UTF-8' \
-H "Authorization: Bearer $TKN" \
2>&1 | tr -d '\r' | sed -En 's/^Location: (.*)/\1/p')

echo '...setting user1 password'

curl -X PUT --data '@./reset-user1.json' "${LOCATION}/reset-password" \
-H "Accept: application/json" \
-H 'Content-Type: application/json;charset=UTF-8' \
-H "Authorization: Bearer $TKN"