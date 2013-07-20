appender('CONSOLE', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = '%d{HH:mm:ss} %msg%n'
    }
}
root(INFO, ['CONSOLE'])
