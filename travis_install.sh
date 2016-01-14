#!/usr/bin/env bash

cd ./ShadowCommon
mvn clean install
cd ../SilenceEngine
gradle clean build javadoc
cd ..
mkdir ./libs
mkdir ./libs/SilenceEngine
mkdir ./libs/LWJGL
mkdir ./libs/ShadowCommon
cp ./SilenceEngine/build/libs/SilenceEngine.jar ./libs/SilenceEngine/SilenceEngine.jar
rsync ./SilenceEngine/libs ./libs/LWJGL
rsync ./ShadowCommon/build ./libs/ShadowCommon