@echo off
SET MAVEN_WRAPPER_JAR=.mvn\wrapper\maven-wrapper.jar
SET DOWNLOAD_URL=https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar

IF NOT EXIST %MAVEN_WRAPPER_JAR% (
  echo Downloading Maven Wrapper...
  powershell -Command "Invoke-WebRequest -Uri '%DOWNLOAD_URL%' -OutFile '%MAVEN_WRAPPER_JAR%'"
)

SET JAVA_EXEC=java
IF DEFINED JAVA_HOME SET JAVA_EXEC=%JAVA_HOME%\bin\java

%JAVA_EXEC% -classpath %MAVEN_WRAPPER_JAR% "-Dmaven.multiModuleProjectDirectory=%CD%" org.apache.maven.wrapper.MavenWrapperMain %*
