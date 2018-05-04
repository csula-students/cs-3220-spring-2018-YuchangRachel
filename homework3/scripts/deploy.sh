@@ -0,0 +1,18 @@
 +#! /bin/bash
 +
 +USERNAME=$1
 +APPLICATION_PATH="$USERNAME@cs3.calstatela.edu:/home/$USERNAME/www"
 +
 +if [[ -z "$USERNAME" ]]; then
 +	echo "Missing username argument. Pass username like './scripts/deploy.sh cs3220stu01'"
 +	exit 1
 +fi
 +
 +echo "deploying to ${APPLICATION_PATH}"
 +
 +# deploying the compiled class files
 +scp -r build/classes/java/main/* "$APPLICATION_PATH/WEB-INF/classes/"
 +# deploy libraries
 +scp -r lib/* "$APPLICATION_PATH/WEB-INF/lib/"
 +# deploy static contents (including WEB-INF/web.xml)
 +scp -r src/main/webapp/* "$APPLICATION_PATH/"
