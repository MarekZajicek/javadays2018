# DEMO-OIDC-SPRINGBOOT2-AUTH-BEARER

Simple demo application demonstrating _rest api_ with _bearer token_ authorization.


## How to run

```shell
$ ./mvnw clean spring-boot:run
```


## How to test

- requires running Keycloak server, see `demo-keycloak` module

- obtaining token

    ```shell
    $ JWT=`curl \
           -d 'client_id=demo' \
           -d 'username=john' \
           -d 'password=000' \
           -d 'grant_type=password' \
           http://sso.local:8090/auth/realms/demo/protocol/openid-connect/token \
           | sed 's/.*access_token":"//g' | sed 's/".*//g'`
    ```

- sending request

    ```shell
    $ curl http://demo.local:8092/api/name -H "Authorization: Bearer $JWT"
    ```



## Examples

- example of response from authorization server

    ```
    eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJWbmVnZHlKbDV3aUV6MmhHR2hwZzVOOVhVOHFFdDQ0Sk53Sl90VllqeUs0In0.eyJqdGkiOiJkZGU5MjYyMS02ZTM1LTRkODQtYTY4MS1jMzQwNjljYWNmMGEiLCJleHAiOjE1NDA5ODQxNjksIm5iZiI6MCwiaWF0IjoxNTQw
    OTgzODY5LCJpc3MiOiJodHRwOi8vc3NvLmxvY2FsOjgwOTAvYXV0aC9yZWFsbXMvZGVtbyIsImF1ZCI6ImRlbW8iLCJzdWIiOiI1MjY3OThlNy00MTUwLTQwYzEtYTI3YS02OTM2NDNmYTJmMTYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJkZW1vIiwiYXV0aF90aW1lIjowLCJzZXNzaW9uX3N0
    YXRlIjoiNDg2YTdjMzMtOTgyMi00Yzg5LThmMDAtMjViMTNmYzU1NWVhIiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6W10sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJhdWRpdG9yIiwiYWRtaW4iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFn
    ZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInJvbGVzIjpbImFkbWluIiwiYXVkaXRvciJdLCJuYW1lIjoiVG9tYXMgSHJhZGVjIiwicHJlZmVycmVkX3VzZXJu
    YW1lIjoidG9tIiwiZ2l2ZW5fbmFtZSI6IlRvbWFzIiwiZmFtaWx5X25hbWUiOiJIcmFkZWMifQ.kOMIEsHGUv0_tQTj0yVNAR1I9bR3dlrfYxp2GJ4L2FX9fefiPElARzykiMUWMbV9NVyXlCuY-w0oXAarQe1LpNHcm-l8Kkc_zo_ZJNch-4tBXySM8He_LyKqTVRmNvP2RPiChBMZTgy1qyULf
    MPDK1MhPpRUKStS3rojizvduB6ByH31z64amGiBSKIO_45KlVGbrs62QeV9-br3SzmkXIKrNxVOjd72o7J-a3qauFliA912kwmqjOtTX3DzQaL2qLzji1z2Z73im4g0u2G9o8s8EdOcpeaeFZ6i80hprXLAi86WFRSjLyWALZaZmrJIwF31a6_abAHaTf-L106_9A
    ```

- example of decoded access token

   ```json
    {
      "jti": "dde92621-6e35-4d84-a681-c34069cacf0a",
      "exp": 1540984169,
      "nbf": 0,
      "iat": 1540983869,
      "iss": "http://sso.local:8090/auth/realms/demo",
      "aud": "demo",
      "sub": "526798e7-4150-40c1-a27a-693643fa2f16",
      "typ": "Bearer",
      "azp": "demo",
      "auth_time": 0,
      "session_state": "486a7c33-9822-4c89-8f00-25b13fc555ea",
      "acr": "1",
      "allowed-origins": [],
      "scope": "email profile",
      "roles": [
        "admin",
        "auditor"
      ],
      "preferred_username": "john"
    }
    ```
