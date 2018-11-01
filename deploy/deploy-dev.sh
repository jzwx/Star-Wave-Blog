APP_DIR=/build/Star-Wave-Blog/build/libs
APP_NAME=Star-Wave-Blog-0.0.1-SNAPSHOT

usage() {
    echo "Usage: sh deploy.sh [start|stop|kills]"
    exit 1
}

kills(){
    PID=$(ps -ef | grep "$APP_NAME".jar | grep -v grep | awk '{ print $2 }')
    if [ -z "$PID" ]
    then
        echo 'service has closed.'
    else
        echo 'service is closing.' $PID
        kill -9 $PID
    fi
}

start(){
    #rm -f $APP_DIR/tpid
    #rm -f tpid
    #nohup java -jar xx.jar --spring.profiles.active=dev > /dev/null 2>&1 &
    nohup java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000 -jar $APP_DIR/"$APP_NAME".jar --spring.profiles.active=dev > /dev/null 2>&1 &
    #echo $! > tpid
    echo 'Start Success!'
}

stop(){
    tpid=`ps -ef|grep $APP_NAME|grep -v grep|grep -v kill|awk '{print $2}'`
    if [ ${tpid} ]; then
        echo 'Stop Process...'
        kill -15 $tpid
    fi
    sleep 5
    tpid=`ps -ef|grep $APP_NAME|grep -v grep|grep -v kill|awk '{print $2}'`
    if [ ${tpid} ]; then
        echo 'Kill Process!'
        kill -9 $tpid
    else
       echo 'Stop Success!'
    fi
}

check(){
    tpid=`ps -ef|grep $APP_NAME|grep -v grep|grep -v kill|awk '{print $2}'`
    if [ ${tpid} ]; then
        echo 'App is running.'
    else
        echo 'App is NOT running.'
    fi
}

case "$1" in
    "start")
        start
        ;;
    "stop")
        stop
        ;;
    "kill")
        kills
        ;;
    *)
        usage
        ;;
esac