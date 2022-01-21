def call (credId,tomcatId,tomcatUser)
sshagent([credId]) {
               sh"""
            scp -o StrictHostKeyChecking=no target/myweb*.war ${tomcatUser}@${tomcatId}/opt/tomcat8/webapps/myweb.war
            ssh ${tomcatUser}r@${tomcatId} /opt/tomcat8/bin/shutdown.sh
            ssh ${tomcatUser}${tomcatId} /opt/tomcat8/bin/startup.sh
            """
