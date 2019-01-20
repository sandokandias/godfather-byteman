#!/bin/bash

bminstall.sh -b $*
bmsubmit.sh -s /home/godfather/Work/github/sandokandias/godfather-agent/target/godfather-agent-1.0.0-SNAPSHOT-jar-with-dependencies.jar
#bmsubmit.sh -s /home/godfather/Work/tools/byteman/lib/gson-2.8.5.jar
bmsubmit.sh  /home/godfather/Work/github/sandokandias/godfather-agent/jackson.btm
bmsubmit.sh
