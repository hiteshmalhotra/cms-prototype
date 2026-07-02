#!/bin/sh
# Maven wrapper script — auto-downloads Maven if not present
set -e

MAVEN_WRAPPER_JAR=".mvn/wrapper/maven-wrapper.jar"
MAVEN_WRAPPER_PROPERTIES=".mvn/wrapper/maven-wrapper.properties"
DOWNLOAD_URL="https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar"

if [ ! -f "$MAVEN_WRAPPER_JAR" ]; then
  echo "Downloading Maven Wrapper..."
  if command -v wget > /dev/null 2>&1; then
    wget -q -O "$MAVEN_WRAPPER_JAR" "$DOWNLOAD_URL"
  elif command -v curl > /dev/null 2>&1; then
    curl -fsSL -o "$MAVEN_WRAPPER_JAR" "$DOWNLOAD_URL"
  else
    echo "ERROR: wget or curl is required to download the Maven Wrapper." >&2
    exit 1
  fi
fi

JAVA_EXEC="java"
if [ -n "$JAVA_HOME" ]; then
  JAVA_EXEC="$JAVA_HOME/bin/java"
fi

exec "$JAVA_EXEC" \
  -classpath "$MAVEN_WRAPPER_JAR" \
  "-Dmaven.multiModuleProjectDirectory=$PWD" \
  org.apache.maven.wrapper.MavenWrapperMain "$@"
