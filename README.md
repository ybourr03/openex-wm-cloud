# openx-cloud-wm

OpenEx packaged template server to help you start a new openEx server with a default camel route.

If you need documentation about OpenEx : see here https://sites.google.com/decathlon.com/openex/resources



**Prerequisistes :**
* valid maven install: https://maven.apache.org/install.html
* valid jdk8 install

1. First build the packaged server

```shell
mvn clean install
```

The server is generated in ```target``` directory.

2. Then you can run the karaf server

```shell
./target/assembly/bin/karaf
```