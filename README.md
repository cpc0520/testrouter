# testrouter

generated using Luminus version "3.44"

## Running

To start a web server for the application, run:

    lein run 
    
## Function
1. Simple GET/POST API
```sh
$ http POST :3000/foobar
```
```
HTTP/1.1 200 OK
Connection: Keep-Alive
Content-Type: application/json; charset=utf-8
Date: Mon, 29 Jul 2019 12:02:48 GMT
Server: Aleph/0.4.4
content-length: 17

{
    "foobar": "post"
}

```

```shell script
$ http GET :3000/foobar
```

```
HTTP/1.1 200 OK
Connection: Keep-Alive
Content-Type: application/json; charset=utf-8
Date: Mon, 29 Jul 2019 12:03:49 GMT
Server: Aleph/0.4.4
content-length: 16

{
    "foobar": "get"
}


```
