#To activate the test, start a terminal and type the location of the test script. EX. "../Desktop/testScript.sh
#
#
#!/bin/bash
#
# Requires git, ant and that the tools and platform-tools 
# folder in the Android SDK is on your path.
#
# Retrieve the latest version from your repository?
#

TEST_DIR=$HOME/Desktop/tmp-build
mkdir -p $TEST_DIR

cd $TEST_DIR
pwd

rm -fr JohannesCO

git clone https://github.com/danwar/JohannesCO
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


android update project -p .
android update test-project -m ../ -p test/

#
# Compile, sign with debug key install to emulator/device and
# run tests.
#

cd test
ant run-tests