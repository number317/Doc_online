#Instruction
**Important**: *This project runs on Linux and depends on libreoffice to convert documents.*

This is a simple maven web project, you can get it with:
```bash
git clone git@github.com:number317/Doc_online.git
cd Doc_online
mvn clean package
```
Then copy /target/Doc\_online.war to your tomcat's webapps. Restart tomcat and open localhost:8080/Doc\_online/Login.jsp in your web browser. Now you can see the login page. But you haven't set the database yet, so you can't login now. Start mysql, open your terminate and type
```bash
mysql -u root -p
```
Input your password, then import the sql script in the /database directory:
```sql
source path/fileOnline_db.sql;
source path/data.sql;
source path/proc.sql;
source path/trigger.sql;
```
Restart mysql and you can login now. The username is 01234567890123, password is 000000. You can upload **doc, ppt, xls, txt, png, pdf** and so on form documents, the web will convert it to pdf and you can read it online.

Finally, this project has some bugs and it does't work very well, if I have time, I will fix them.
