#!/usr/bin/env bash

# step0 defind the var info
CONFIG_PATH=$1
# step1 echo the bash usage
usage() {
    echo 'this is the springboot web programe common utils shell !'
    echo '########### the input parameter for master is ###########'
    echo 'the [CONFIG_PATH] is $CONFIG_PATH'
    echo '#########################################################'
}

# step2 defind your custom function


# main fun body

case $2 in
    "start" ) echo 'start !!!';;
    "end" ) echo 'end!!!';;
esac
