#!/bin/bash
#
#To activate the test, start a cygwin terminal and type the location of the 
#test script. EX. # "cd /cygdrive/c/Users/Johannes/Desktop/"
# A reformatter must be done: "dos2unix /cygdrive/c/Users/Johannes/Desktop/testScript.sh"
# Finally: "/cygdrive/c/Users/Johannes/Desktop/testScript.sh" 
#
# Requires git, ant and that the tools and platform-tools 
# folder in the Android SDK is on your path.
#
# Retrieve the latest version from your repository?
#

BASE=/cygdrive/c/Users/Johannes


TEST_DIR=$BASE/Desktop/tmp-build
mkdir -p $TEST_DIR

cd $TEST_DIR
pwd

rm -fr JohannesCO
echo "CLONE in $(pwd)"

'/cygdrive/c/Program Files (x86)/Git/bin/git' clone https://github.com/danwar/JohannesCO
#/cygdrive/c/Program\ Files\ \(x86\)/Git/bin/git clone https://github.com/danwar/JohannesCO
RET=$?
if [ $RET -ne 0 ] 
then
   echo "Could not clone git repo...... $RET"
   exit $RET
fi

#
# Generate build.xml
#

cd JohannesCO
RET=$?
if [ $RET -ne 0 ] 
then
   echo "Could not go to JohannesCO ...... $RET"
   exit $RET
fi


# android update project -p .
# android update test-project -m ../ -p test/

#/cygdrive/c/Program\ Files/Android/android-sdk/tools/android.bat update project -p .
#/cygdrive/c/Program\ Files/Android/android-sdk/tools/android.bat update test-project -m ../ -p test/

#
# Compile, sign with debug key install to emulator/device and
# run tests.
#

cd SleepApp
cd test

echo "WIll now execute ant..... I am in $(pwd)"
sleep 2
/cygdrive/c/Program\ Files/Ant/bin/ant.bat run-tests