# Arguments to pass: $1:script, $2:init, $3:duration

nohup /usr/IBM/WebSphereR/AppServer/java/bin/java -Xms16m -Xmx32m -cp . Scheduler $1 $2 $3 > Scheduler.log &