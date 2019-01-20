#!/bin/bash

bminstall.sh -b $*
bmsubmit.sh -s /home/godfather/Work/github/sandokandias/godfather-agent/target/godfather-agent-1.0.0-SNAPSHOT.jar
#bmsubmit.sh -s /home/godfather/Work/tools/byteman/lib/javax.servlet-api-3.1.0.jar
bmsubmit.sh  /home/godfather/Work/github/sandokandias/godfather-agent/servlet.btm
bmsubmit.sh
