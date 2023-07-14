# Starter-Backend

This project contains a working *FullStack* example.
It can be used as a starting point for your own project.

Application components:
* SpringBoot backend `src\main\java`
* HTML, CSS, JavaScript frontend with Bootstrap `src\main\resources\static`
* configurable connection to a MySQL database
* maven build tool with `pom.xml` project and build configuration

## Getting Started

### Install and setup MySQL database server and workbench
Follow the installation instructions provided here: 
https://dev.mysql.com/downloads/installer/

The tutorial explains how to test and get familiar with your installation: 
https://dev.mysql.com/doc/refman/8.0/en/tutorial.html

Open MySQL workbench and make sure you have
* Created a database for the project `CREATE DATABASE <database-name>;`
* Created a user with a password `CREATE USER <user-name> IDENTIFIED BY <password>;`
* Granted permissions to the user to access the database `GRANT ALL ON <database-name>.* TO '<user-name>'@'%';`

Use `USE <database-name>` to connect to your database.

Before continuing, test your connection.

### IDE
Install IntelliJ Ultimate for Students
* [Free Educational Licenses - Community Support (jetbrains.com)](https://www.jetbrains.com/community/education/#students)
* [Download IntelliJ](https://www.jetbrains.com/idea/download)

### GitLab
Make sure you have a GitLab account and your [SSH key setup](https://docs.gitlab.com/ee/user/ssh.html).
Fork the project from GitLab https://gitlab.com/adsd_hu/starter-backend/-/forks/new

Clone the project using:
* command-line `git clone <your-project>` and open the directory as a new project in IntelliJ
* **or** IntelliJ: File > New > Project from Version Control

### Java
When the project is opened it should detect this is a Maven project and contains Java files.
If Java is not installed yet, you might get an error and suggestion from IntelliJ to install a Java SDK.

Java SDK (JDK) version 17 or higher is recommended.

If you don't want to install JDK through IntelliJ, use this link: [Java Downloads](https://www.oracle.com/java/technologies/downloads/)

### Initial configuration

Open the file [application.properties](./src/main/resources/application.properties) and notice the four lines at the top.

The first line looks for a file called [`.env`](.env) 
To create this file, make a copy of the file [`.env.example`](.env.example) and name it `.env`. 
Make sure this file is in the same directory.
Next, open the file and change the database connection variables based on your MySQL installation from above.
* `DB_JDBC_URL`: Change the name of the database (where it says `starter`)
* `DB_USERNAME`: Fill in the username you created above (where it says `myname`)
* `DB_PASSWORD`: Fill in the password you created above (where it says `mypassword`)

### Initial tests

Run the application with: `mvn spring-boot:run`. 

After compilation and startup is done (this takes a while), inspect if the application started without errors. 
The last line in the console output should look similar to this:
```
Started StarterBackendApplication in 4.145 seconds (process running for 4.443)
```

Open a terminal and run the command `curl http://localhost:8080/greeting/random?name=yourname`. 

You should see an output like this (note that the exact text might be different):
```json
{"text":"Hello there yourname!"}
```

In a browser open the URL [http://localhost:8080/](http://localhost:8080/). Type your name and the hit Submit button.
This should show you a greeting text on the page.

If these steps are successful, you can start developing. Otherwise, please doublecheck all the steps above and / or consult your team-mates.

For automated tests run: `mvn test` (this assumes you have Firefox installed on your system)

## Development

The *starter-backend* project uses the [SpringBoot application framework](https://spring.io/projects/spring-boot). 

The provided SpringBoot application (see [StarterBackendApplication](./src/main/java/nl/hu/adsd/starterbackend/StarterBackendApplication.java)) 
configures a REST Controller [GreetingController](./src/main/java/nl/hu/adsd/starterbackend/GreetingController.java)

Before making adjustments for your own project, explore the files provided in this project and 
try to find similarities with the SpringBoot REST tutorial https://spring.io/guides/tutorials/rest/

The structure (layout) of the project follows a default java directory structure. More info about the structure can be found here:
https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html

### Configuration

The following files hold some configuration settings:
* [`.env`](.env) Environment variables, these might differ between development and production
* [`.env.example`](.env.example) Example file for the `.env` file (make a copy and call it `.env`)
* [`application.properties`](src/main/resources/application.properties) Application-wide configuration
* [`data.sql`](src/main/resources/data.sql) Initial SQL to be executed on the database, to pre-fill some data
* [`pom.xml`](pom.xml) Maven project definition (Project Object Model) for dependencies and building / packaging
* [`StarterBackendConfig.java`](src/main/java/nl/hu/adsd/starterbackend/StarterBackendConfig.java) Programmatic configuration where Spring Beans can be configured

### Backend

The java files in the *starter-project* define a REST-like application whilst also serving static content (html, css, js). 

* Backend code [src/main/java](src/main/java/) 
* Test code [src/main/test](src/test/java/)
* Package `nl.hu.adsd.starterbackend`
* Frontend code [src/main/resources/static](src/main/resources/static) (see below)

To fully understand how the backend code works it's recommended to:
* Look at the code
* Try to follow how the tests are set up
* Start the application and make some api-calls with [curl](https://curl.se/)

Start the backend with `mvn spring-boot:run` and after startup type the following in a terminal
```
curl http://localhost:8080/greeting/random?name=yourname
```

### Frontend

The integrated webserver is configured to look for, so-called 'static' resources. 
The files in that directory will be served to the browser without any processing.

E.g. http://localhost:8080/index.html points to the file under `src/main/resources/static/index.html`

The styling is fully provided by bootstrap, see also: [Bootstrap Intro](https://getbootstrap.com/docs/5.3/getting-started/introduction/)

When the submit button is clicked a call is made to the backend to retrieve a greeting. 
The returned JSON is used to update the DOM of the page, thereby show the greeting with the provided name.


## Production

To create a single `jar` file for this project run `mvn package`. This creates a jar file containing all 
compiled classes and dependencies. The jar-file will be placed under the directory `target/`.

From the terminal, go the directory `cd target/` and run `java -jar starter-backend-0.0.1-SNAPSHOT.jar` 

Note that on a production you will need to override the environment variables or provide a different `.env` file, 
since the production MySQL server might have a different host, database, user or password.

Further deployment steps are not yet defined.