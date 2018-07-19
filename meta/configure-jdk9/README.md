# Configure JDK 9

## Download and Install JDK 9
Get it here: https://s3-us-west-2.amazonaws.com/java-401-d1/jdk-9.0.4_osx-x64_bin.dmg

## Create New Project
* Create new Intellij Project
* Choose Gradle
* Project SDK: Select New- JDK

![step 01](step-01-choose-new-jdk.png)

## Find Java Virtual Machine Home Directory
* Click dropdown- navigate to Java Virtual Machines
* Then select jdk -9
* Then expand jdk 9
*  Click to expand ‘contents’
* Select ‘Home’
* Press Open

![step 02](step-02-move-up-to-virtual-machine-directory.png)
![step 03](step-03-expand-java9-dir-to-home.png)

## Set Project SDK to JDK 9
* Select  java 9 from right side drop down menu
* Select Next

![step 04](step-04-select-java9-as-project-sdk.png)

## Enter Project Name as GroupID and ArtifactID
* Enter project name for GroupID
* Enter project name for ArtifactID
* Press next

![step 05](step-05-enter-project-name-group-and-artifact-id.png)

## Leave Most Gradle Settings as Default
* Leave everything to default
* Gradle JVM: Choose 1.9 from dropdown
* Press Next

![step 06](step-06-select-jdk9.png)

## Verify Project Location and Finish
* Verify project location is where you want it to be
* Click Finish
