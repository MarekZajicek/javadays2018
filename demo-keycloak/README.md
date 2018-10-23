# DEMO-KEYCLOAK

Docker image with preconfigured Keycloak for demo purpose.
It contains:
- realm `demo`
- client `demo`
- user `john` with password `000`
- theme `javadays`

## How to build

```shell
$ docker build -t demo-keycloak .
```

## How to run

```shell
$ docker run -d -p 8090:8080 demo-keycloak
```


## Links

- [Administrative console](http://dockerip:8090/auth/admin/master/console/) (user:admin, password: admin)
- [User account](http://dockerip:8090/auth/realms/demo/account)