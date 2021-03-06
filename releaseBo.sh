#!/bin/sh

svn_status=$(svn status)

if [ ! -z "$svn_status" ]
then
	echo "You have local uncommitted changes"
	exit -1
fi

svn update

mvn -q -U clean install javadoc:javadoc 

e="$?"
if [ $e -ne 0 ]
then
        echo "build failed exiting..."
        exit -1
fi

snapshot=`mvn -U org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version | grep -v '\['|grep -v 'Down'`
release=${snapshot%"-SNAPSHOT"}

echo "preparing release version $release"

mvn -q -U --batch-mode release:prepare -Darguments="-DskipTests"
 
e="$?"
if [ $e -ne 0 ]
then
	echo "release preparation failed exiting..."
	exit -1
fi

mvn -q -U release:perform -Darguments="-DskipTests"

e="$?"
if [ $e -ne 0 ]
then
        echo "release failed exiting..."
        exit -1
fi

mail -s "Bo2 $release released" `cat recipientsOne.txt` < changelog.txt

printf "\n\n$release\n--------\n\n" >> history.txt
cat changelog.txt >> history.txt

:>changelog.txt

svn commit changelog.txt history.txt -m "added to release history"
