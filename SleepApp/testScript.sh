#!/bin/bash

#To activate the test, start a cygwin terminal and type the location of 
#the test script. EX. "/cygdrive/c/Users/Uzer/Desktop/testScript.sh

#dos2unix.exe ./testScript.sh must be typed in before the script is being 
#run

#
#
# Requires git, ant and that the tools and platform-tools 

# folder in the Android SDK is on your path.

#
# Retrieve the latest version from your repository?

#



TEST_DIR=/cygdrive/c/Users/Uzer/Desktop/tmp-build
mkdir -p 
$TEST_DIR

PATH=$PATH:/cygdrive/c/Program\ Files/Android/android-sdk/tools


cd $TEST_DIR

pwd



get_git()
{
  
rm -fr JohannesCO

  
git clone https://github.com/danwar/JohannesCO
  
RET=$?
  

if [ $RET -ne 0 ] 

then
 echo "Could not clone git repo...... $RET"
    
exit $RET 
  
fi

}







prepare()
{

  
# android update project -p .
  
# android update test-project -m ../ -p test/


ls -al

   

android.bat update project -p .


#android.bat update test -project -m ../ -p test/

}



#
# Compile, sign with debug key install to emulator/device and

# run tests.

#

#
#  MAIN part of the script

#


#
# Generate build.xml

#



cd JohannesCO

cd SleepApp


RET=$?

if [ $RET -ne 0 ] 

then
   echo "Could not go to JohannesCO ...... $RET"
   
exit $RET

fi




get_git

prepare
	

cd test

ant run-tests

