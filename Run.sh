#!/bin/bash
projectName=`pwd|rev|cut -d "/" -f 1|rev`
echo "================================================="
echo "0.Clean and Repackage the project"
mvn clean package
echo "1.Cover old version in /var/lib/tomcat8/webapps/"
echo "  Project Name: ${projectName}"
echo arch53212765 | sudo -S cp target/${projectName}.war /var/lib/tomcat8/webapps 2>/dev/null
echo "2.Restart tomcat and mysql"
echo arch53212765 | sudo -S systemctl restart tomcat8 mysqld 2>/dev/null
echo "3.Open project in firefox!!!"
firefox "localhost:8080/${projectName}"
echo -e "\033[36;;0m  Now the project has run in firefox!!!\033[0m"
echo "================================================="
exit