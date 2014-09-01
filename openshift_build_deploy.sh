#!/bin/bash
gradle project:modules:jruby:distZip
git add project/modules/jruby/build/distributions/gradledemo-jruby-1.0.zip
git commit -m "$*"
git push
