# Shiptime Demo
## Installation

**The demo requires:**
- JDK v17.0.2.
- Gradle 8.4
- NPM 9.5.0


**Install and run backend server:**

**Step 1**: Update configration

open file ./src/main/resources/application.properties in any text editor
update the following properties:

```sh
demo.shiptime.auth.username = "";
demo.shiptime.auth.password = "";
```

The username and password are used to authenticate Shiptime SandBox API.

**Step 2**: build and run java application

```sh
cd ./application
./gradlew clean build
java -jar ./build/libs/demo-0.0.1-SNAPSHOT.jar
```
By default the applicaiton will run on port 8080. If you want to change the port, please update server.port in properties file and rebuild.

**Install and run frontend:**
Front end was developed using React framework

```sh
cd ./web
npm install
npm run start
```

Default application will run on port 3000. If you want to change the port, we need to update CORS domain in MVCConfig.java in backend project.
