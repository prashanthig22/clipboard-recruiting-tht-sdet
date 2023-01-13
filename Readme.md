This assignment is completed having a provision to run in chrome,Selenium Grid and in docker container.

How to run code in local machine using chrome browser?

Option 1: with Code being cloned & Maven being installed,we can run using mvn clean test in cmd prompt.

Option 2 : With code being cloned,Test can be run by running "AmazonTestCase.Java" in src Test folder.
==============================================================
How to see Test Results in local machine?
Once Tests are run, extent report will be created under target folder with name as Spark.html.
Screenshots will be attached for each step for reference.
============================================================

How to run code in docker container?

1.run "docker compose -f docker-compose-v3-swarm.yml up" in cmd

2.Ensure Grid is up by hitting the URL: http://localhost:4444/

3.run command "docker pull prashanthig22/assignment:latest" in cmd

4.run "docker run -it -–network=”host” --entrypoint "/bin/sh" prashanthig22/assignment" in cmd

5.run "mvn clean test" in cmd
============================================================
How to see Test Results in Docker Container?
1.Get Container ID using the command "docker ps" in cmd 

2.Copy the content of the container to the local system using the command "docker -cp [Container_ID]:/home/clipboard-recruiting-tht-sdet/ Downloads"

3.Check the dowloaded folder and find the Spark.html file inside the target folder
===========================================================

Highlights of the solution:

Implemented Page oblect model for easier maintanence

Have written all the common methods like click(),Sroll and Click() in class called helpermethods.java under CommonUtils

Have written common methods to perform explicit wait and have included exception handling

Incorporated extent reports for viewing test results. Screenshots will be attached in report for each step.


Have included Dockerfile which allows to build a docker image in future too.

 
