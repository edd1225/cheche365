// Register Status Listener
statusListener OnConsoleStatusListener



// Settings
def commonAppenders         = ['console', 'commonDailyRollingFile']
def appAppenders            = ['console', 'appDailyRollingFile']
def springAppenders         = ['springDailyRollingFile']
def httpAppenders           = ['console', 'httpDailyRollingFile']

def patternLayout = '%d{HH:mm:ss.SSS} [%thread] %-5level %logger{60} - %msg %n'

def logFilePathPrefix       = 'build/logs'

def maxLogArchiveHistoryDays = 180



// Appenders
appender('console', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = patternLayout
    }
}

appender('commonDailyRollingFile', RollingFileAppender) {
    file = "$logFilePathPrefix/common.log"
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "$logFilePathPrefix/common.%d{yyyy-MM-dd}.gz"
        maxHistory = maxLogArchiveHistoryDays
    }
    encoder(PatternLayoutEncoder) {
        pattern = patternLayout
    }
}

appender('appDailyRollingFile', RollingFileAppender) {
    file = "$logFilePathPrefix/app.log"
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "$logFilePathPrefix/app.%d{yyyy-MM-dd}.gz"
        maxHistory = maxLogArchiveHistoryDays
    }
    encoder(PatternLayoutEncoder) {
        pattern = patternLayout
    }
}

appender('springDailyRollingFile', RollingFileAppender) {
    file = "$logFilePathPrefix/spring.log"
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "$logFilePathPrefix/spring.%d{yyyy-MM-dd}.gz"
        maxHistory = maxLogArchiveHistoryDays
    }
    encoder(PatternLayoutEncoder) {
        pattern = patternLayout
    }
}

appender('httpDailyRollingFile', RollingFileAppender) {
    file = "$logFilePathPrefix/http.log"
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "$logFilePathPrefix/http.%d{yyyy-MM-dd}.gz"
        maxHistory = maxLogArchiveHistoryDays
    }
    encoder(PatternLayoutEncoder) {
        pattern = patternLayout
    }
}



//  Loggers
root(WARN, commonAppenders)

logger('com.cheche365.cheche.cpicuk.client', DEBUG, appAppenders, false)
logger('org.springframework', INFO, springAppenders, false)
logger('org.apache.commons.httpclient', INFO, httpAppenders, false)
