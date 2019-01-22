#!/bin/bash

bminstall.sh -b $*
bmsubmit.sh -s ~/.m2/repository/br/com/zup/godfather-agent/1.0.0-SNAPSHOT/godfather-agent-1.0.0-SNAPSHOT-jar-with-dependencies.jar
bmsubmit.sh  ./agent-rules.btm
bmsubmit.sh
