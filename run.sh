#!/bin/bash

DIR=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )
cd $DIR
java -jar -Dlog4j.configuration=file:./src/test/resources/log4j.properties  target/jena-system-in-jetty-debug-0.0.1-SNAPSHOT.jar -p 8080

