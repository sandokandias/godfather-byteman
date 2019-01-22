#!/bin/bash

bminstall.sh -b $*
bmsubmit.sh -s /home/godfather/Work/github/sandokandias/godfather-byteman/godfather-agent/target/godfather-agent-1.0.0-SNAPSHOT-jar-with-dependencies.jar
bmsubmit.sh  /home/godfather/Work/github/sandokandias/godfather-byteman/godfather-agent/agent-rules.btm
bmsubmit.sh
